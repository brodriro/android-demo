package me.rzknairb.domain.usecases;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import me.rzknairb.domain.entities.Feed;
import me.rzknairb.domain.repositories.FeedRemoteRepository;

@Singleton
public class FeedUseCase {

    @Inject
    public FeedUseCase() {
    }

    @Inject
    FeedRemoteRepository feedRemoteRepository;

    public Single<List<Feed>> getFeed() {
        return feedRemoteRepository.getFeed();
    }
}
