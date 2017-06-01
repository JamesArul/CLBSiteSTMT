package com.jpro.studentsmeetbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.studentsmeetbackend.dao.CommentDAO;
import com.jpro.studentsmeetbackend.model.Comment;

import junit.framework.Assert;


public class CommentDAOTestCase {
	
	@Autowired
	static Comment comment;
	
	@Autowired
	static CommentDAO commentDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jpro.studentsmeetbackend");
		context.refresh();
		comment = (Comment) context.getBean("comment");
		commentDAO = (CommentDAO) context.getBean("commentDAO");
	}

	//@Test
	public void addCommentTestCase() {
		boolean flag=commentDAO.addComment(3, "US001", "Thanks for using Students Meet");
		Assert.assertEquals("addCommentTestCase", true,flag);
	}
	
	//@Test
	public void getAllCommentTestCase(){
		int flag=commentDAO.getAllComments(3).size();
		Assert.assertEquals("getAllCommentTestCase", 1,flag);
	}
	
	//@Test
	public void reportCommentTestCase(){
		boolean flag=commentDAO.reportComment(4);
		Assert.assertEquals("reportCommentTestCase", true,flag);
	}
	
	//@Test 
	public void getCommentTestCase(){
		boolean flag=false;
		comment=commentDAO.getComment(4);
		if(comment!=null)
			flag=true;
		Assert.assertEquals("getCommentTestCase", true,flag);
	}
	
	//@Test
	public void getAllReportedCommentsTestCase(){
		int flag=commentDAO.getAllReportedComments(3).size();
		Assert.assertEquals("getAllReportedCommentsTestCase", 1,flag);
	}
	
	//@Test
	public void removeCommentTestCase(){
		commentDAO.removeComment(4);
	}

}
