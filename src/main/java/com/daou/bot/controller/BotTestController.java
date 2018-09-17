package com.daou.bot.controller;

import org.springframework.web.bind.annotation.*;

import com.daou.bot.vo.KeyboardVO;
import com.daou.bot.vo.MessageButtonVO;
import com.daou.bot.vo.MessageVO;
import com.daou.bot.vo.PhotoVO;
import com.daou.bot.vo.RequestMessageVO;
import com.daou.bot.vo.ResponseMessageVO;

@RestController
public class BotTestController {

	@RequestMapping(value = "/keyboard", method = RequestMethod.GET)
	public KeyboardVO keyboard() {

		KeyboardVO keyboard = new KeyboardVO(new String[] {"소개", "사진", "링크"});
		return keyboard;
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseMessageVO message(@RequestBody RequestMessageVO vo) {

		ResponseMessageVO resVO = new ResponseMessageVO();
		MessageVO msgVO = new MessageVO();
		
		if (vo.getContent().contains("안녕")) {
			msgVO.setText("안녕하세요 :) 지연이 봇에 오신걸 환영합니다! '메뉴'를 입력하시면 메뉴를 확인 할 수 있습니다.");
		} else if (vo.getContent().contains("이름")) {
			msgVO.setText("저는 윤지연 입니다.");
		} else if (vo.getContent().contains("어디")) {
			msgVO.setText("경기도 용인시 수지구 디지털벨리로 81 다우디지털스퀘어 6층");
		} else if(vo.getContent().equals("메뉴")) {
			
			KeyboardVO keyboard = new KeyboardVO(new String[] {"소개", "사진", "링크"});
			resVO.setKeyboard(keyboard);
			
			msgVO.setText(vo.getContent());

		} else if(vo.getContent().equals("소개")) {
			
			msgVO.setText("안녕하세요. 도넛북입니다.");
			
		} else if(vo.getContent().equals("사진")) {
			
			PhotoVO photo = new PhotoVO();
			photo.setUrl("https://www.donutbook.co.kr/images/common/logo_donutbook.jpg");
			photo.setWidth(210);
			photo.setHeight(44);
			
			msgVO.setPhoto(photo);
			msgVO.setText(vo.getContent());
			
		} else if(vo.getContent().equals("링크")) {
			
			MessageButtonVO messageButton = new MessageButtonVO();
			messageButton.setLabel("도넛북");
			messageButton.setUrl("https://www.donutbook.co.kr/index.do");
			
			msgVO.setMessage_button(messageButton);
			msgVO.setText(vo.getContent());

		} else {
			msgVO.setText(vo.getContent());
		}
		
		resVO.setMessage(msgVO);
		return resVO; 
	}
}
