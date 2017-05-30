package com.jpro.studentsmeetbackend.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="STMT_CHAT")
public class Chat extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long chatId;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="STMT_CHAT_MESSAGES",joinColumns=@JoinColumn(name="chatId"))
	private List<ChatMessage> chat_Messages=new LinkedList<ChatMessage>();

	public long getChatId() {
		return chatId;
	}

	public void setChatId(long chatId) {
		this.chatId = chatId;
	}

	public List<ChatMessage> getChat_Messages() {
		return chat_Messages;
	}

	public void setChat_Messages(List<ChatMessage> chat_Messages) {
		this.chat_Messages = chat_Messages;
	}
	
}
