package com.jason.model;

import java.io.Serializable;

/**
 * Description:
 *
 * @author jason
 * @date 2019-01-31 12:11
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String age;

    public Person() {
    }

    public Person(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
