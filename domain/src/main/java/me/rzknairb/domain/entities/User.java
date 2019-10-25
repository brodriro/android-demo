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
    private String phone;
    private Social social;

    public User() {
    }

    public User(int id, String username, String name, String lastname, String image, String occupation,
                String age, String email, String location, String phone, Social social) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
        this.occupation = occupation;
        this.age = age;
        this.email = email;
        this.location = location;
        this.phone = phone;
        this.social = social;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
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

    public Social getSocial() {
        return social;
    }

    public class Social {
        private String likes;
        private String shares;
        private String posts;
        private String friends;

        public Social(String likes, String shares, String posts, String friends) {
            this.likes = likes;
            this.shares = shares;
            this.posts = posts;
            this.friends = friends;
        }

        public String getLikes() {
            return likes;
        }

        public String getShares() {
            return shares;
        }

        public String getPosts() {
            return posts;
        }

        public String getFriends() {
            return friends;
        }
    }
}
