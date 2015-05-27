package com.pivotal.twitter;

import java.io.Serializable;

public class Tweet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1936114283319156908L;
	
	private String id;
	private String from_user;
	private String created_at;
	private String text;
	private String language_code;
	private int retweet_count;
	

	  
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom_user() {
		return from_user;
	}

	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLanguage_code() {
		return language_code;
	}

	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	public int getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}




}
