package me.rzknairb.data.remote.entities;

import java.util.ArrayList;
import java.util.List;

import me.rzknairb.domain.entities.Feed;
import me.rzknairb.domain.repositories.FeedRemoteRepository;

public class FeedResponse {
    private int id;
    private String user_id;
    private String username;
    private String user_image;
    private String body;
    private String image;
    private String likes;
    private List<CommentResponse> comment;

    private class CommentResponse {
        private String user_id;
        private String username;
        private String user_image;
        private String comment;

        public CommentResponse(String user_id, String username, String user_image, String comment) {
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
        public Feed.Comment toComent() {
            return new Feed().new Comment(getUser_id(),getUsername(),getUser_image(),getComment());
        }
    }

    public FeedResponse(int id, String user_id, String username, String user_image, String body, String image, String likes, List<CommentResponse> comment) {
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

    public List<CommentResponse> getComment() {
        return comment;
    }

    public Feed toFeed(){
        return new Feed(
                getId(),
                getUser_id(),
                getUsername(),
                getUser_image(),
                getBody(),
                getImage(),
                getLikes(),
                toFeedComment(getComment())
        );
    }

    private List<Feed.Comment> toFeedComment(List<CommentResponse> list) {
        List<Feed.Comment> mComments = new ArrayList<>();
        for (CommentResponse row: getComment()) mComments.add(row.toComent());
        return mComments;
    }
}
