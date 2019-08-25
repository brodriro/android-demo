package me.rzknairb.demoapp.di.modules;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;
import me.rzknairb.data.local.repositories.UserLocalRepository;
import me.rzknairb.domain.repositories.UserDatabaseRepository;

@Module
public class AppModule {

    @Provides
    public Context context(Application application) {
        return application;
    }

    @Provides
    @Singleton
    UserDatabaseRepository providesUserDatabaseRepository(UserLocalRepository loginLocalRepository) {
        return loginLocalRepository;
    }


    @Singleton
    @Provides
    RealmConfiguration providerRealm(Application context) {
        Realm.init(context);
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name("demoapp");
        builder.rxFactory(new RealmObservableFactory());
        return builder.build();
    }
}