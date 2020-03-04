package me.rzknairb.demoapp.di.modules;


import dagger.Binds;
import dagger.Module;
import me.rzknairb.demoapp.views.social_app.comments.CommentActivity;
import me.rzknairb.demoapp.views.social_app.comments.CommentPresenter;
import me.rzknairb.demoapp.views.social_app.feed.FeedFragment;
import me.rzknairb.demoapp.views.social_app.feed.FeedPresenter;
import me.rzknairb.demoapp.views.social_app.friends.FriendsFragment;
import me.rzknairb.demoapp.views.social_app.friends.FriendsPresenter;
import me.rzknairb.demoapp.views.social_app.home.HomeActivity;
import me.rzknairb.demoapp.views.social_app.home.HomePresenter;
import me.rzknairb.demoapp.views.social_app.profile.ProfileFragment;
import me.rzknairb.demoapp.views.social_app.profile.ProfilePresenter;
import me.rzknairb.demoapp.views.social_app.user_profile.UserProfileActivity;
import me.rzknairb.demoapp.views.social_app.user_profile.UserProfilePresenter;

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

    @Binds
    abstract UserProfilePresenter.View provideUserProfileView(UserProfileActivity userProfileActivity);

    @Binds
    abstract FriendsPresenter.View provideFriendsView(FriendsFragment friendsFragment);
}
