package com.yixiangyang.utcTime;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class UtcConfig {
	@Autowired
	  private Environment env;

	  @PostConstruct
	  public void initUtcConfiguration(){
		 
	    String timeZone =env.getProperty("time.zone");
	    if (timeZone != null) {
	      System.setProperty("user.timezone", timeZone);
	      TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	      System.out.println(TimeZone.getTimeZone(timeZone));
	      
	      System.out.println(System.currentTimeMillis());
	    }
	  }
}
