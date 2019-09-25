package me.rzknairb.data.remote.entities;

import me.rzknairb.domain.entities.User;

public class UserResponse {

    private int id;
    private String username;
    private String name;
    private String lastname;
    private String image;
    private String occupation;
    private String age;
    private String email;
    private String location;
    private SocialResponse social;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getImage() {
        return image;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public SocialResponse getSocial() {
        return social;
    }

    private class SocialResponse {
        private String posts;
        private String likes;
        private String shares;
        private String friends;

        public SocialResponse(String posts, String likes, String shares, String friends) {
            this.posts = posts;
            this.likes = likes;
            this.shares = shares;
            this.friends = friends;
        }

        public String getPosts() {
            return posts;
        }

        public String getLikes() {
            return likes;
        }

        public String getShares() {
            return shares;
        }

        public String getFriends() {
            return friends;
        }

        public User.Social toSocial() {
            return new User().new Social(
                    getLikes(), getShares(), getPosts(), getFriends()
            );
        }
    }

    public UserResponse(int id, String username, String name, String lastname, String image, String occupation,
                        String age, String email, String location, SocialResponse socialResponse) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
        this.occupation = occupation;
        this.age = age;
        this.email = email;
        this.location = location;
        this.social = socialResponse;
    }

    public User toUser() {
        return new User(
            getId(),
                getUsername(),
                getName(),
                getLastname(),
                getImage(),
                getOccupation(),
                getAge(),
                getEmail(),
                getLocation(),
                getSocial().toSocial()
        );
    }
}
