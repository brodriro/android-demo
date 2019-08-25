package me.rzknairb.demoapp.di.modules;

import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class ActivityBindingModule {
/**
    @ContributesAndroidInjector(modules = {PresenterViewModule.class})
    abstract LoginActivity loginActivityInjector();*/

}