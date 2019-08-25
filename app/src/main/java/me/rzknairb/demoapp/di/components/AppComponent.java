package me.rzknairb.demoapp.di.components;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import me.rzknairb.demoapp.application.DemoApp;
import me.rzknairb.demoapp.di.modules.ActivityBindingModule;
import me.rzknairb.demoapp.di.modules.AppModule;

@Singleton
@Component(modules = {ActivityBindingModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<DemoApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}