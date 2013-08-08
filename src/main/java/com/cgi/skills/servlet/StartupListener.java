package com.cgi.skills.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cgi.skills.db.DataInitializer;

/**
 * Performs webapp initializion tasks
 */
@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        final String environment = sce.getServletContext().getInitParameter("environment");

        final EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("com.cgi.skills." + environment);

        sce.getServletContext().setAttribute("emf", emf);

        final EntityManager em = emf.createEntityManager();

        try {
            new DataInitializer(em).initData();
        } finally {
            em.close();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do
    }
}
