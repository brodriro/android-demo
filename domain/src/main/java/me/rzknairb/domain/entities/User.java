package me.rzknairb.domain.entities;

public class User {
    private int id;
    private String username;
    private String name;
    private String lastname;
    private String image;
    private String occupation;
    private String age;
    private String email;
    private String location;
    private Social social;

    public User() {
    }


    class Social {
        private String likes;
        private String shares;
        private String posts;
        private String friends;
    }
}
