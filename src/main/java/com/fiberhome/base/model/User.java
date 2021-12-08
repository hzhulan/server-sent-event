package com.fiberhome.base.model;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/9/8 7:46
 */
public class User {

    private Integer id;

    private Integer age;

    private String name;

    private int sort;

    public User() {
    }

    public User(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User(Integer id, Integer age, String name, int sort) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
