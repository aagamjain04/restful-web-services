package com.project.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    public HelloWorldBean(String message) {
        this.message = message;
    }
}
