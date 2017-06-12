package com.jpro.studentsmeetbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.studentsmeetbackend.dao.ChatDAO;
import com.jpro.studentsmeetbackend.model.Chat;
import com.jpro.studentsmeetbackend.model.ChatMessage;

import junit.framework.Assert;

public class ChatDAOTestCase {
	
	@Autowired
	static Chat chat;
	
	@Autowired
	static ChatDAO chatDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jpro.studentsmeetbackend");
		context.refresh();
		chat = (Chat) context.getBean("chat");
		chatDAO = (ChatDAO) context.getBean("chatDAO");
	}
	
	//@Test
	public void createChatTestCase(){
		chat.setIsPrivateChat('Y');
		chat.setReportChat('N');
		chat.setChatTopic("Private Chat");
		boolean flag=chatDAO.createChat(chat);
		Assert.assertEquals("createChatTestCases", true, flag);
	}
	
	//@Test
	public void removeChatandGetChatByIDTestCase(){
		chat=chatDAO.getChatById(1);
		boolean flag=chatDAO.removeChat(chat);
		Assert.assertEquals("createChatTestCases", true, flag);
	}
	
	//@Test
	public void addChatMessage(){
		ChatMessage msg=new ChatMessage();
		msg.setChatID(2);
		msg.setChatMsg("Hi");
		msg.setUserID("US002");
		boolean flag=chatDAO.addChatMessage(msg.getChatID(), msg);
		Assert.assertEquals("createChatTestCases", true, flag);
	}
	
	//@Test
	public void getAllChatTestCase(){
		int flag=chatDAO.getAllChat().size();
		Assert.assertEquals("createChatTestCases", 1, flag);
	}
	
	//@Test
	public void getALLChatMessageTestCase(){
		int flag=chatDAO.getAllChatMessage(2).size();
		Assert.assertEquals("createChatTestCases", 2, flag);
	}
	
	//@Test
	public void reportChatTestCase(){
		boolean flag=chatDAO.reportChat(2);
		Assert.assertEquals("reportChatTestCase", true, flag);
	}
	
	//@Test
	public void getAllReportedChatTestCase(){
		int flag=chatDAO.getAllReportedChats().size();
		Assert.assertEquals("getAllReportedChatTestCase", 1, flag);
	}
	
	@Test
	public void getPrivateChats(){
		int flag=chatDAO.getPrivateChatsOfUser("US002").size();
		Assert.assertEquals("getPrivateChats", 1, flag);
	}

}
