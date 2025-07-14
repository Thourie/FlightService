package com.thourie.flightservice.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletContext;

public final class TemplateEngineUtil {
    public static TemplateEngine getTemplateEngine(ServletContext servletContext) {
        JakartaServletWebApplication app = JakartaServletWebApplication.buildApplication(servletContext);

        WebApplicationTemplateResolver resolver = new WebApplicationTemplateResolver(app);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setPrefix("/WEB-INF/templates/");  // Папка с шаблонами
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        return engine;
    }
}