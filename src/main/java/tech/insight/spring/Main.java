package tech.insight.spring;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.bridge.SLF4JBridgeHandler;
import tech.insight.spring.test.HelloServlet;

import java.io.File;
import java.util.logging.LogManager;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    public static void main(String[] args) throws Exception {
//        new ApplicationContext("tech.insight.spring");
        tomcat();
    }



    public static void tomcat() throws LifecycleException {
//        LogManager.getLogManager().reset();
//        SLF4JBridgeHandler.removeHandlersForRootLogger();
//        SLF4JBridgeHandler.install();
        int port = 8080;
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();
        Context context = tomcat.addContext(contextPath, docBase);
        HelloServlet helloServlet = new HelloServlet();

        tomcat.addServlet(contextPath, "helloServlet", helloServlet);
        context.addServletMappingDecoded("/*", "helloServlet");
        tomcat.start();
        System.out.println("tomcat start...  port :" + port);
    }
}
