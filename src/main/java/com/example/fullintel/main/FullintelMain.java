package com.example.fullintel.main;

import com.example.fullintel.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.example.fullintel")
@SpringBootApplication
public class FullintelMain {

    public static void main(String[] args) {
        try {
            /*ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfiguration.class);
            UserDao userDao = factory.getBean(UserDao.class);
            userDao.selectAllUser("admin@capestart.com","b85e2529d52e65a03acba2d8591b712c");
            //userDao.insertUser();*/

            SpringApplication.run(FullintelMain.class, args);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
