package me.rzknairb.demoapp.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.rzknairb.demoapp.views.home.HomeActivity;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract HomeActivity homeActivityInjector();

}