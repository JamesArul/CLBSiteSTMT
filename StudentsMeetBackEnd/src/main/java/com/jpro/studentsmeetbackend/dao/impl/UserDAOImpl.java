package com.jpro.studentsmeetbackend.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jpro.studentsmeetbackend.dao.UserDAO;
import com.jpro.studentsmeetbackend.model.Friend;
import com.jpro.studentsmeetbackend.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean createUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e){
			System.err.println(e);
			return false;
		}
	}

	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e){
			System.err.println(e);
			return false;
		}
	}

	public User getUserById(String userID) {
		return  sessionFactory.getCurrentSession().get(User.class, userID);
	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public List<Friend> getAllFriendsOfUser(String userID) {
		User user=(User) getUserById(userID);
		return user.getUserFriends();
	}

	public boolean userValidate(String userID, String userPassword) {
			User user=getUserById(userID);
			if(user.getUserPassword().equals(userPassword)){
				return true;
			}
			else{
				return false;
			}			
	}

	public boolean sendFriendRequest(String senderID, String receiverId) {
		try
		{
		User receiveUser=(User) sessionFactory.getCurrentSession().createQuery("from User where userID='"+receiverId+"'").uniqueResult();
		Friend friend=new Friend();
		friend.setFriendId(senderID);
		friend.setFriendStatus("Request received");
		friend.setIsOnline('N');
		receiveUser.getUserFriends().add(friend);
		sessionFactory.getCurrentSession().update(receiveUser);
		log.debug("Friend request added");
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean acceptFriendRequest(String receiverId, String senderID) {
		try {
			String sql="delete from USER_FRIENDS where USERID=:receiverID and FRIENDID=:senderId";
			SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setParameter("senderId", senderID);
			query.setParameter("receiverID", receiverId);
			query.executeUpdate();
		User receiveUser=(User) sessionFactory.getCurrentSession().createQuery("from User where userID='"+receiverId+"'").uniqueResult();
		User sendUser=(User) sessionFactory.getCurrentSession().createQuery("from User where userID='"+senderID+"'").uniqueResult();
		log.debug("Acquired request sending user and receiving user");
		Friend sfriend=new Friend();
		sfriend.setFriendId(senderID);
		sfriend.setIsOnline('N');
		log.debug("Moving request sender:"+senderID+"to list of Friends");
		sfriend.setFriendStatus("Friend");
		receiveUser.getUserFriends().add(sfriend);
		Friend rfriend=new Friend();
		rfriend.setFriendId(receiverId);
		rfriend.setIsOnline('N');
		rfriend.setFriendStatus("Friend");
		sendUser.getUserFriends().add(rfriend);
		log.debug("Updating the users");
		updateUser(receiveUser);
		updateUser(sendUser);
		return true;
		}
		catch(Exception e)
		{
			log.debug("Error occured while accepting request");
			return false;
		}

	}

	public boolean rejectRequest(String senderId, String receiverID) {
		try
		{
			String sql="delete from USER_FRIENDS where USERID=:receiverID and FRIENDID=:senderId";
			SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setParameter("senderId", senderId);
			query.setParameter("receiverID", receiverID);
			query.executeUpdate();
		log.debug("Request rejected");
		return true;
		}
		catch(Exception e){
			log.debug("Error occured while rejecting request");
			return false;
		}
	}

	public boolean setUserOffline(String userID) {
		try{
			User user=(User) sessionFactory.getCurrentSession().createQuery("from User where userID='"+userID+"'").uniqueResult();
			user.setIsOnline('N');
			user.setLastSeenOnline(new Date());
			log.debug(userID+"is now Offline");
			updateUser(user);
			return true;
			}
			catch(Exception e){
				log.debug("Error occured while setting user offline");
				return false;
			}
	}

	public boolean setUserPhoto(String userID, String filePath) {
		// TODO Auto-generated method stub
		return false;
	}

}
