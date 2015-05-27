package com.pivotal.twitter;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

public class CopyOfTweet implements PdxSerializable{

	private String id;
	private String from_user;
	private String created_at;
	private String text;
	private String language_code;
	private int retweet_count;
	
	@Override
	public void fromData(PdxReader in) {
		this.id = in.readString("id");
		this.from_user = in.readString("from_user");
		this.created_at = in.readString("created_at");
		this.text = in.readString("text");
		this.language_code = in.readString("language_code");
		this.retweet_count = in.readInt("retweet_count");
	}

	@Override
	public void toData(PdxWriter out) {
		out.writeString("id", this.id);
		out.writeString("from_user", this.from_user);
		out.writeString("created_at", this.created_at);
		out.writeString("text", this.text);
		out.writeString("language_code", this.language_code);
		out.writeInt("retweet_count", this.retweet_count);
		
	}
	  @Override
	   public String toString() {
	     final StringBuilder buffer =  new StringBuilder( "{ type = ");
	    buffer.append(getClass().getName());
	    buffer.append( ", id = ").append(getId());
	    buffer.append( ", from_user = ").append(getFrom_user());
	    buffer.append( ", created_at = ").append(getCreated_at());
	    buffer.append( ", text = ").append(getText());
	    buffer.append( ", language_code = ").append(getLanguage_code());
	    buffer.append( ", retweet_count = ").append(getRetweet_count());
	    buffer.append( " }");
	     return buffer.toString();
	  }
	  
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
