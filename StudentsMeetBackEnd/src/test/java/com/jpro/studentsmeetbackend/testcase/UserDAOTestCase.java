package com.jpro.studentsmeetbackend.testcase;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpro.studentsmeetbackend.dao.UserDAO;
import com.jpro.studentsmeetbackend.model.Friend;
import com.jpro.studentsmeetbackend.model.Qualification;
import com.jpro.studentsmeetbackend.model.User;

import junit.framework.Assert;



public class UserDAOTestCase {
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jpro.studentsmeetbackend");
		context.refresh();
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	//@Test
	public void createUserTestCase() {
		user.setUserID("US002");
		user.setIsOnline('N');
		user.setUserName("Dinesh");
		user.setUserPassword("1234567");
		user.setUserRole("ROLE_USER");
		/*
		Qualification qual=new Qualification();
		BigDecimal num=new BigDecimal(81.2);
		qual.setTenthPercentage(num);
		num=new BigDecimal(81.583);
		qual.setTwelfthPercentage(num);
		num=new BigDecimal(7.00);
		qual.setBachelorCGPAPercentage(num);
		user.setUserQualification(qual);
		*/
		boolean flag=userDAO.createUser(user);
		Assert.assertEquals("createUserTestCase", true,flag);
	}
	
	//@Test
	public void updateAndGetByIdTestCase(){
		user=userDAO.getUserById("US001");
		user.setUserName("James Arul");
		boolean flag=userDAO.updateUser(user);
		Assert.assertEquals("updateAndGetByIdTestCase", true,flag);
	}

	//@Test
	public void getAllUserTestCase(){
		int flag=userDAO.getAllUsers().size();
		Assert.assertEquals("getAllUserTestCase", 2,flag);
	}
	
	//@Test
	public void validateUserTestCase(){
		boolean flag=userDAO.userValidate("US001","1234567");
		Assert.assertEquals("validateUserTestCase", true,flag);
	}
	
	//@Test
	public void setUserOfflineTestCase(){
		boolean flag=userDAO.setUserOffline("US001");
		Assert.assertEquals("setUserOfflineTestCase", true,flag);
	}
	
	//@Test
	public void sendFriendRequestTestCase(){
		boolean flag=userDAO.sendFriendRequest("US001", "US002");
		Assert.assertEquals("sendFriendRequestTestCase", true,flag);
	}
	
	//@Test
	public void acceptFriendRequestTestCase(){
		boolean flag=userDAO.acceptFriendRequest("US002", "US001");
		Assert.assertEquals("acceptFriendRequestTestCase", true,flag);
	}
	
	//@Test
	public void rejectUserRequestTestCase(){
		boolean flag=userDAO.rejectRequest("US002", "US001");
		Assert.assertEquals("rejectUserRequestTestCase", true,flag);
	}
	
	//@Test
	public void getAllFriendsTestCase(){
		int flag=userDAO.getAllFriendsOfUser("US001").size();
		Assert.assertEquals("rejectUserRequestTestCase", 1,flag);
	}
	
	//@Test
	public void setUSerPhotoTestCase(){
		String path="F:\\Pr2\\ProfileImages\\w05.gif";
		boolean flag=userDAO.setUserPhoto("US001", path);
		Assert.assertEquals("setUSerPhotoTestCase", true,flag);
	}
	
	//@Test
	public void userImageTestCase(){
		user=userDAO.getUserById("US001");
		System.out.println(user.getUserImage().length);
	}
	
	@Test
	public void getUserFriendRequests(){
		List<Friend> friends=userDAO.getFriendsReqOfUser("ECOOL");
		Friend f=friends.get(0);
		System.out.println(f.getFriendId());
	}
	
}
