package com.jpro.studentsmeetbackend.model;

import javax.persistence.Embeddable;

@Embeddable
public class Friend extends BaseDomain {
	
	private String friendId;
	
	private String friendStatus;
	
	private char isOnline;

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(String friendStatus) {
		this.friendStatus = friendStatus;
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}
	
}
