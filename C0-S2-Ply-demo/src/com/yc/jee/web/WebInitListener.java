package com.yc.jee.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yc.jee.common.Config;

@WebListener
public class WebInitListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	arg0.getServletContext().setAttribute("config", Config.PROPS);
    }
	
}
