package me.rzknairb.demoapp.di.modules;


import dagger.Binds;
import dagger.Module;
import me.rzknairb.demoapp.views.home.HomeActivity;
import me.rzknairb.demoapp.views.home.HomePresenter;

@Module
public abstract class PresenterViewModule {

    @Binds
    abstract HomePresenter.View provideHomeView(HomeActivity homeActivity);


}
