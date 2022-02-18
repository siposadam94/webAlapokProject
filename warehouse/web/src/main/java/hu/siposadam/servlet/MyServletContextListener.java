//package hu.siposadam.servlet;
//
//import javax.faces.webapp.FacesServlet;
//import javax.servlet.Registration;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
//import javax.servlet.ServletRegistration;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class MyServletContextListener implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);
//
//        //Registering the JSF Servlet
//        ServletRegistration.Dynamic facesServlet = sce.getServletContext().addServlet("FacesServlet", FacesServlet.class);
//        //Specifying the Servlet Mapping
//        facesServlet.addMapping("*.xhtml");
//        //Setting Priority, 0 or higher for eager, if negative then it's lazy
//        facesServlet.setLoadOnStartup(1);
//    }
//}
