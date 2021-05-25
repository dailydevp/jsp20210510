package ch20;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener01
 *
 */
//@WebListener 어노테이션설정 혹은 web.xml에 설정.
public class AppListener01 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener01() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
    //그 어떤것보다 빠르게 최초로 실행된당. 프로그램이 처음 실행되자마자 실행되는것.
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("어플리케이션 초기화 되었습니다.");
         ServletContext application = sce.getServletContext();
         String driver = application.getInitParameter("jdbcdriver");
         String url = application.getInitParameter("jdbcUrl");
         
         System.out.println(driver);
         System.out.println(url);
         
         System.out.println("초기화 메소드 종료");
    }
	
}
