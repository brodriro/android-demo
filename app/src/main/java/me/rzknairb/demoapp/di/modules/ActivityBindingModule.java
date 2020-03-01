package me.rzknairb.demoapp.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.rzknairb.demoapp.views.social_app.comments.CommentActivity;
import me.rzknairb.demoapp.views.social_app.feed.FeedFragment;
import me.rzknairb.demoapp.views.social_app.friends.FriendsFragment;
import me.rzknairb.demoapp.views.social_app.home.HomeActivity;
import me.rzknairb.demoapp.views.social_app.profile.ProfileFragment;
import me.rzknairb.demoapp.views.social_app.user_profile.UserProfileActivity;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract HomeActivity homeActivityInjector();

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract ProfileFragment profileFragmentInjector();

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract FeedFragment feedFragmentInjector();

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract CommentActivity commentActivityInjector();

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract UserProfileActivity userProfileActivityInjector();

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract FriendsFragment friendsFragmentInjector();
}