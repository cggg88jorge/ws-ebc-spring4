package com.makingdevs

import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletRegistration

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class MyWebApplicationInitializer implements WebApplicationInitializer {

  private static final String CONFIG_LOCATION = "com.makingdevs"

  @Override
  void onStartup(ServletContext servletContext) throws ServletException {

    System.out.println("Initializing Application for " + servletContext.getServerInfo())

    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext()
    rootContext.register(WebConfig.class)
    servletContext.addListener(new ContextLoaderListener(rootContext))

    AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext()
    // dispatcherContext.register(DispatcherConfig.class)

    // Register and map the dispatcher servlet
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext))
    dispatcher.setLoadOnStartup(1)
    dispatcher.addMapping("/")
  }
}
