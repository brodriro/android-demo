package me.rzknairb.demoapp.di.modules;


import dagger.Binds;
import dagger.Module;
import me.rzknairb.demoapp.views.comments.CommentActivity;
import me.rzknairb.demoapp.views.comments.CommentPresenter;
import me.rzknairb.demoapp.views.feed.FeedFragment;
import me.rzknairb.demoapp.views.feed.FeedPresenter;
import me.rzknairb.demoapp.views.home.HomeActivity;
import me.rzknairb.demoapp.views.home.HomePresenter;
import me.rzknairb.demoapp.views.profile.ProfileFragment;
import me.rzknairb.demoapp.views.profile.ProfilePresenter;

@Module
public abstract class PresenterViewModule {

    @Binds
    abstract HomePresenter.View provideHomeView(HomeActivity homeActivity);

    @Binds
    abstract ProfilePresenter.View provieProfileView(ProfileFragment profileFragment);

    @Binds
    abstract FeedPresenter.View provideFeedView(FeedFragment feedFragment);

    @Binds
    abstract CommentPresenter.View provideCommentView(CommentActivity commentActivity);
}
