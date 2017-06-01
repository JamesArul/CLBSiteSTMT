package com.jpro.studentsmeetbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.studentsmeetbackend.dao.ChatDAO;
import com.jpro.studentsmeetbackend.dao.ReportChatDAO;
import com.jpro.studentsmeetbackend.model.Chat;
import com.jpro.studentsmeetbackend.model.ReportUserChat;


public class ReportChatDAOTestCase {
	
	@Autowired
	static ReportUserChat reportUserChat;
	
	@Autowired
	static ReportChatDAO reportChatDAO;
	
	@Autowired
	static ChatDAO chatDAO;
	
	@Autowired
	static Chat chat;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jpro.studentsmeetbackend");
		context.refresh();
		reportUserChat = (ReportUserChat) context.getBean("reportUserChat");
		reportChatDAO = (ReportChatDAO) context.getBean("reportChatDAO");
		chatDAO=(ChatDAO) context.getBean("chatDAO");
		chat=(Chat) context.getBean("chat");
	}

	@Test
	public void createReportChatTestCase(){
		reportUserChat.setChatID(1);
	}

}
