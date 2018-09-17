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

		KeyboardVO keyboard = new KeyboardVO(new String[] {"사진", "라벨", "에코메세지"});
		return keyboard;
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseMessageVO message(@RequestBody RequestMessageVO vo) {

		ResponseMessageVO resVO = new ResponseMessageVO();
		MessageVO msgVO = new MessageVO();
		
		if(vo.getContent().equals("메인화면")) {
			
			msgVO.setText("지연이 봇에 오신걸 환영합니다!");
			
			KeyboardVO keyboard = new KeyboardVO(new String[] {"사진", "링크", "echo"});
			resVO.setKeyboard(keyboard);

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

			msgVO.setText("도넛북 바로가기"); 
			msgVO.setMessageButton(messageButton);

		} else {
			msgVO.setText(vo.getContent());
		}
		
		resVO.setMessage(msgVO);
		return resVO; 
	}
}
