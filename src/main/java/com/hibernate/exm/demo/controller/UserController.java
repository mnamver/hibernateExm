package com.hibernate.exm.demo.controller;


import com.hibernate.exm.demo.entitiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping()
    public void createUser(){

        System.out.println("sdfasd");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        User user = new User();
        user.setName("mehmet");
        user.setPrice(33);

        tx.begin();
        entityManager.persist(user);
        tx.commit();
        entityManager.close();


    }

}
