package me.rzknairb.data.remote.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import me.rzknairb.data.remote.API;
import me.rzknairb.data.remote.entities.FeedResponse;
import me.rzknairb.domain.entities.Feed;
import me.rzknairb.domain.repositories.FeedRemoteRepository;

public class FeedRemoteRepositoryImp extends RetrofitRepository implements FeedRemoteRepository {

    @Inject
    public FeedRemoteRepositoryImp(){

    }

    @Override
    public Single<List<Feed>> getFeed() {
        API api = getRetrofit(API.BASE_URL).create(API.class);
        return api.getFeed().map(feedResponses -> {
            List<Feed> feed = new ArrayList<>();
            for (FeedResponse row: feedResponses ) feed.add(row.toFeed());
            return feed;
        });
    }
}
