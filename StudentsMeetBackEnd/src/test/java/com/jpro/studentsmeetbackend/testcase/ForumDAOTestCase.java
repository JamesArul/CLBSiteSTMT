package com.jpro.studentsmeetbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.studentsmeetbackend.dao.ForumDAO;
import com.jpro.studentsmeetbackend.model.Forum;

import junit.framework.Assert;

public class ForumDAOTestCase {
	
	@Autowired
	static Forum forum;
	
	@Autowired
	static ForumDAO forumDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jpro.studentsmeetbackend");
		context.refresh();
		forum = (Forum) context.getBean("forum");
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void createForumTestCase(){
		forum.setForumName("General Public Forum");
		boolean flag=forumDAO.createForum(forum);
		Assert.assertEquals("createForumTestCase",true,flag);
	}
	
	//@Test
	public void updateForumTestCase(){
		forum.setForumId(5);
		forum.setForumName("General Public Forum");
		boolean flag=forumDAO.updateForum(forum);
		Assert.assertEquals("updateForumTestCase",true,flag);
	}
	
	//@Test
	public void getAllForumTestCase(){
		int flag=forumDAO.getAllForum().size();
		Assert.assertEquals("updateForumTestCase",1,flag);
	}
	
	//@Test
	public void getForumByIDandRemoveTestCase(){
		forum=forumDAO.getForumbyID(5);
		boolean flag=forumDAO.removeForum(forum);
		Assert.assertEquals("getForumByIDandRemoveTestCase",true,flag);
	}
}
