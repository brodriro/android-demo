package me.rzknairb.demoapp.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.rzknairb.demoapp.views.comments.CommentActivity;
import me.rzknairb.demoapp.views.feed.FeedFragment;
import me.rzknairb.demoapp.views.home.HomeActivity;
import me.rzknairb.demoapp.views.profile.ProfileFragment;

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
}