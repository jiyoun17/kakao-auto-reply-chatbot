package com.daou.bot.vo;

public class MessageVO {
	
	private String text;
	private PhotoVO photo;
	private MessageButtonVO messageButton;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PhotoVO getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoVO photo) {
		this.photo = photo;
	}

	public MessageButtonVO getMessageButton() {
		return messageButton;
	}

	public void setMessageButton(MessageButtonVO messageButton) {
		this.messageButton = messageButton;
	}

	@Override
	public String toString() {
		return "MessageVO [text=" + text + ", photo=" + photo + ", messageButton=" + messageButton + "]";
	}
}
