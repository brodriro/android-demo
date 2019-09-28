package me.rzknairb.domain.entities;

import java.util.List;

public class Feed {
    private int id;
    private String user_id;
    private String username;
    private String user_image;
    private String body;
    private String image;
    private String likes;
    private List<Comment> comment;

    public class Comment {
        private String user_id;
        private String username;
        private String user_image;
        private String comment;

        public Comment(String user_id, String username, String user_image, String comment) {
            this.user_id = user_id;
            this.username = username;
            this.user_image = user_image;
            this.comment = comment;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getUsername() {
            return username;
        }

        public String getUser_image() {
            return user_image;
        }

        public String getComment() {
            return comment;
        }
    }

    public Feed() {
    }

    public Feed(int id, String user_id, String username, String user_image, String body, String image, String likes, List<Comment> comment) {
        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.user_image = user_image;
        this.body = body;
        this.image = image;
        this.likes = likes;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_image() {
        return user_image;
    }

    public String getBody() {
        return body;
    }

    public String getImage() {
        return image;
    }

    public String getLikes() {
        return likes;
    }

    public List<Comment> getComment() {
        return comment;
    }
}