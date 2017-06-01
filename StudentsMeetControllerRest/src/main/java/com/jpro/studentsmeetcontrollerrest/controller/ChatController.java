package com.jpro.studentsmeetcontrollerrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpro.studentsmeetbackend.dao.ChatDAO;
import com.jpro.studentsmeetbackend.model.Blog;
import com.jpro.studentsmeetbackend.model.Chat;
import com.jpro.studentsmeetbackend.model.ChatMessage;

@RestController
public class ChatController {
	
private static final Logger log=LoggerFactory.getLogger(ChatController.class);
	
	@Autowired
	private Chat chat;
	
	@Autowired
	private ChatDAO chatDAO;
	
	@PostMapping("/createChat")
	public ResponseEntity<Chat> createChat(@RequestBody Chat newChat){
		boolean valid=chatDAO.createChat(newChat);
		if(valid)
		{
			newChat.setErrorCode("200");
			newChat.setErrorMsg("Chat Created");
			return new ResponseEntity<Chat>(newChat,HttpStatus.OK);
		}
		else
		{
			log.debug("Error creating chat");
			newChat.setErrorCode("400");
			newChat.setErrorMsg("Chat not Created");
			return new ResponseEntity<Chat>(newChat,HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllChat")
	public ResponseEntity<List<Chat>> getAllChat(){
		log.debug("Getting all chats");
		return new ResponseEntity<List<Chat>>(chatDAO.getAllChat(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllChatMessage/{chatID}")
	public ResponseEntity<List<ChatMessage>> getAllChatMessgae(@PathVariable("chatID") long chatID){
		log.debug("Getting all chat messages");
		return new ResponseEntity<List<ChatMessage>>(chatDAO.getAllChatMessage(chatID),HttpStatus.OK);
	}
	
	@GetMapping("/getChatById/{chatID}")
	public ResponseEntity<Chat> getChatById(@PathVariable("chatID") long chatID){
		log.debug("Getting all chat messages");
		return new ResponseEntity<Chat>(chatDAO.getChatById(chatID),HttpStatus.OK);
	}
	
	@GetMapping("/removeChat/{chatID}")
	public String removeChat(@PathVariable("chatID") long chatID){
		boolean valid=chatDAO.removeChat(chatID);
		if(valid){
			return "Success";
		}
		else{
			return "Error";
		}
	}

}
