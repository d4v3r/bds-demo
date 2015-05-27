package com.pivotal.twitter;

import java.util.Properties;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializer;
import com.gemstone.gemfire.pdx.PdxWriter;

public class TweetSerializer implements PdxSerializer, Declarable{

	@Override
	public void init(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object fromData(Class<?> clazz, PdxReader reader) {
		if (clazz == Tweet.class) {
			Tweet tweet = new Tweet();
			tweet.setId(reader.readString("id"));
			tweet.setFrom_user(reader.readString("from_user"));
			tweet.setCreated_at(reader.readString("created_at"));
			tweet.setText(reader.readString("text"));
			tweet.setLanguage_code(reader.readString("language_code"));
			tweet.setRetweet_count(reader.readInt("retweet_count"));
			// etc.
			return tweet;
		}
			return null;
	}
	

	@Override
	public boolean toData(Object obj, PdxWriter writer) {
		  if(!(obj instanceof Tweet)) {
		      return false;
		    }
		  Tweet tweet  = (Tweet)obj;
		  writer.writeString("id", tweet.getId())
		  .writeString("from_user", tweet.getFrom_user())
		  .writeString("created_at", tweet.getCreated_at())
		  .writeString("text", tweet.getText())
		  .writeString("language_code", tweet.getLanguage_code())
		  .writeInt("retweet_count", tweet.getRetweet_count());
		  
		  
		  return true;
	}

}
