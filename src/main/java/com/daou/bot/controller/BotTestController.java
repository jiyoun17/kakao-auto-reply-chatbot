package com.daou.bot.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class BotTestController {

	// 키보드
	@RequestMapping(value = "/keyboard", method = RequestMethod.GET)
	public String keyboard() {

		System.out.println("/keyboard");

		JSONObject jobjBtn = new JSONObject();
		jobjBtn.put("type", "text");

		return jobjBtn.toJSONString();
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String message(@RequestBody JSONObject resObj) {

		System.out.println("/message");
		System.out.println(resObj.toJSONString());

		String content;
		content = (String) resObj.get("content");
		JSONObject jobjRes = new JSONObject();
		JSONObject jobjText = new JSONObject();

		// 사용자 구현
		if (content.contains("안녕")) {
			jobjText.put("text", "안녕하세요 :)");
		} else if (content.contains("이름")) {
			jobjText.put("text", "저는 윤지연 입니다.");
		} else if (content.contains("어디")) {
			jobjText.put("text", "경기도 용인시 수지구 디지털벨리로 81 다우디지털스퀘어 6층");
		} else {
			jobjText.put("text", "몰라~");
		}

		jobjRes.put("message", jobjText);
		System.out.println(jobjRes.toJSONString());

		return jobjRes.toJSONString();
	}
}
