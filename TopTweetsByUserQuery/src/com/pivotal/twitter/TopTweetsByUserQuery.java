package com.pivotal.twitter;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.cache.query.Struct;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.terminal.Terminal;

public class TopTweetsByUserQuery {


  public static void main(String[] args) throws Exception {
    new TopTweetsByUserQuery().run();
  }

  @SuppressWarnings("static-access")
public void run() throws Exception {
	Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
	//terminal.enterPrivateMode();
	
	Screen screen = new Screen(terminal);
	screen.startScreen();
    System.out.println("Connecting to the distributed system and creating the cache...");

    // Create the cache which causes the cache-xml-file to be parsed
    ClientCache cache = new ClientCacheFactory()
        .set("name", "CqClient")
        .set("cache-xml-file", "xml/Client.xml")
        .create();


    // Get the query service
    QueryService queryService = cache.getQueryService();
    
    while(true){
    
    Query query = queryService.newQuery("select distinct from_user, retweet_count from /tweet order by retweet_count desc, from_user desc limit 10");
    Object result = query.execute();
    formatQueryResult(result, screen);
    screen.refresh();
    Thread.currentThread().sleep(1000);

    }
    
  }




  
  private String formatQueryResult(Object result, Screen screen) {
	    if (result == null) {
	      return "null";
	    }
	    else if (result == QueryService.UNDEFINED) {
	      return "UNDEFINED";
	    }
	    if (result instanceof SelectResults) {
	      Collection<?> collection = ((SelectResults<?>)result).asList();
	      StringBuffer sb = new StringBuffer();
	      
    	  Set<ScreenCharacterStyle> hs = new HashSet<ScreenCharacterStyle>();
    	  hs.add(ScreenCharacterStyle.Underline);    	 
    	  hs.add(ScreenCharacterStyle.Bold);
    	  Date now = new Date();
    	  SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:ss");
	      screen.putString(6, 3, "Top tweets by User ("+ DATE_FORMAT.format(now) +")",Terminal.Color.WHITE, Terminal.Color.BLACK, hs);
	      screen.putString(6, 5, "User",Terminal.Color.WHITE, Terminal.Color.BLACK, ScreenCharacterStyle.Bold);
	      screen.putString(41, 5, "Retweet Count",Terminal.Color.WHITE, Terminal.Color.BLACK, ScreenCharacterStyle.Bold);
	      int y = 6;
	      for (Object e: collection) {
	    	  Struct es = (Struct)e;
	    	  String from_user = (String)es.get("from_user");
	    	  int retweet_count = (Integer)es.get("retweet_count");
	    	  retweet_count = retweet_count - 50000;
	    	  Set<ScreenCharacterStyle> hs2 = new HashSet<ScreenCharacterStyle>();
	    	  screen.putString(6, y, from_user , Terminal.Color.WHITE, Terminal.Color.BLACK,hs2);
	    	  screen.putString(41, y, Integer.toString(retweet_count), Terminal.Color.WHITE, Terminal.Color.BLACK,hs2);
	        y++;
	      }
	      return sb.toString();
	    }
	    else {
	      return result.toString();
	    }
	  }
}
