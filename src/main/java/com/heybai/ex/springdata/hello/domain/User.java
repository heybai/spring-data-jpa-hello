package com.heybai.ex.springdata.hello.domain;

import org.hibernate.annotations.Cache;

import javax.persistence.*;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

@Entity @Table(name = "user")
@Cache(usage = READ_WRITE)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
