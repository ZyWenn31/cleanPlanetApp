module tserkovnikov.com.cleanplanetapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires org.hibernate.orm.core;
    requires spring.core;
    // Jakarta API
    requires jakarta.annotation;
    requires jakarta.cdi; // ⚠️ именно это вызывает ошибку — модуль может не существовать!
    // requires jakarta.persistence;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires spring.beans;
    requires jdk.compiler;
    requires jakarta.transaction;
    requires javafx.base;
    //requires tserkovnikov.com.cleanplanetapp;
    requires javafx.graphics;

    exports tserkovnikov.com.cleanplanetapp;
    opens tserkovnikov.com.cleanplanetapp to javafx.fxml;

    exports tserkovnikov.com.cleanplanetapp.controller;
    opens tserkovnikov.com.cleanplanetapp.controller;

    exports tserkovnikov.com.cleanplanetapp.service;
    opens tserkovnikov.com.cleanplanetapp.service;

    exports tserkovnikov.com.cleanplanetapp.repository;
    opens tserkovnikov.com.cleanplanetapp.repository;

    exports tserkovnikov.com.cleanplanetapp.model;
    opens tserkovnikov.com.cleanplanetapp.model;

    exports tserkovnikov.com.cleanplanetapp.configuration;
    opens tserkovnikov.com.cleanplanetapp.configuration;
}