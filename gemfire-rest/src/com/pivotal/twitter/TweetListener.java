package com.pivotal.twitter;

import java.util.Properties;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
import com.gemstone.gemfire.pdx.PdxInstance;

public class TweetListener extends CacheListenerAdapter implements Declarable{

	  public void afterCreate(EntryEvent event) {
		  	String s = null;
		  	s.getBytes();
		    String eKey = (String)event.getKey();
		    PdxInstance eVal = (PdxInstance)event.getNewValue();
		    
		    
		    
		   
		  }

	@Override
	public void init(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
