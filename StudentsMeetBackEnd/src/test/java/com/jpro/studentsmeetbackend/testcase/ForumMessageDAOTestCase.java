package com.jpro.studentsmeetbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.studentsmeetbackend.dao.ForumMessageDAO;
import com.jpro.studentsmeetbackend.model.ForumMessage;

import junit.framework.Assert;



public class ForumMessageDAOTestCase {
	
	@Autowired
	static ForumMessage forumMessage;
	
	@Autowired
	static ForumMessageDAO forumMessageDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jpro.studentsmeetbackend");
		context.refresh();
		forumMessage = (ForumMessage) context.getBean("forumMessage");
		forumMessageDAO = (ForumMessageDAO) context.getBean("forumMessageDAO");
	}

	//@Test
	public void createForumMsgTestCase(){
		forumMessage.setForumId(6);
		forumMessage.setUserId("US001");
		forumMessage.setMsgData("This is a general forum open to all for your opinions and concerns");
		boolean flag=forumMessageDAO.createForumMessage(forumMessage);
		Assert.assertEquals("createForumMsgTestCase",true,flag);
	}
	
	//@Test
	public void getForumMsgTestCase(){
		boolean flag=false;
		forumMessage=forumMessageDAO.getForumMessage(8);
		if(forumMessage!=null)
		{
			flag=true;
		}
		Assert.assertEquals("getForumMsgTestCase",true,flag);
	}
	
	//@Test
	public void reportForumMsgTestCase(){
		forumMessage=forumMessageDAO.getForumMessage(8);
		boolean flag=forumMessageDAO.reportForumMessage(forumMessage);
		Assert.assertEquals("reportForumMsgTestCase",true,flag);
	}
	
	//@Test
	public void getAllForumMsgTestCase(){
		int flag=forumMessageDAO.getAllForumMessage(6).size();
		Assert.assertEquals("reportForumMsgTestCase",1,flag);
	}
	//@Test
	public void removeMSgTestCase(){
		forumMessage=forumMessageDAO.getForumMessage(7);
		boolean flag=forumMessageDAO.removeForumMessage(forumMessage);
		Assert.assertEquals("removeMSgTestCase",true,flag);
	}
	
	//@Test
	public void getAllReportedChat(){
		int flag=forumMessageDAO.getAllReportedMessage(6).size();
		Assert.assertEquals("getAllReportedChat",1,flag);
	}

}
