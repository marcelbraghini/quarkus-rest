package br.com.marcelbraghini.quarkusrest.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class User {

    public String login;
    public String name;
    public String blog;
    public String location;
    public String bio;

    public User() {
    }

    public User(final String login,
                final String name,
                final String blog,
                final String location,
                final String bio
                ) {
        this.login = login;
        this.name = name;
        this.blog = blog;
        this.location = location;
        this.bio = bio;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getBlog() {
        return blog;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

}
