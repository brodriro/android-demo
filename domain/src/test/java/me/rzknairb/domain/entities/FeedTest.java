package me.rzknairb.domain.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FeedTest {

    private Feed feed;

    @Before
    public void setUp() throws Exception {
        feed = new Feed(1, "c01", "rzkbrian", "image", "hello world", "_image", "52", new ArrayList<Feed.Comment>());
    }

    @Test
    public void getId() {
        assertEquals(feed.getId(),1);
    }

    @Test
    public void getUser_id() {
        assertEquals(feed.getUser_id(), "c01");
    }

    @Test
    public void getUsername() {
        assertEquals(feed.getUsername(), "rzkbrian");
    }


    @Test
    public void getUser_image() {
        assertEquals(feed.getUser_image(),"image");
    }

    @Test
    public void getBody() {
        assertEquals(feed.getBody(), "hello world");
    }

    @Test
    public void getImage() {
        assertEquals(feed.getImage(), "_image");
    }

    @Test
    public void getLikes() {
        assertEquals(feed.getLikes(), "52");
    }

    @Test
    public void getComment() {
        assertEquals(feed.getComment().size(), 0);
    }
}