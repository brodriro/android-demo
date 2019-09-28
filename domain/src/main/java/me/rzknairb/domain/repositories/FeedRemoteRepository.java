package me.rzknairb.domain.repositories;

import java.util.List;

import io.reactivex.Single;
import me.rzknairb.domain.entities.Feed;

public interface FeedRemoteRepository {
    Single<List<Feed>> getFeed();
}
