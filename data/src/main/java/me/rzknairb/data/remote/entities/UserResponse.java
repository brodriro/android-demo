package me.rzknairb.data.remote.entities;

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
    private SocialResponse socialResponse;

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
        this.socialResponse = socialResponse;
    }
}
