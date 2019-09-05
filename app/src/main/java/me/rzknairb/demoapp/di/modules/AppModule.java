package me.rzknairb.demoapp.di.modules;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;
import me.rzknairb.data.remote.repositories.UserRemoteRepository;
import me.rzknairb.domain.repositories.UserRemoteRepositoryImp;

@Module
public class AppModule {

    @Provides
    public Context context(Application application) {
        return application;
    }

    /*
    @Provides
    @Singleton
    UserLocalRepositoryImp providesUserDatabaseRepository(UserLocalRepository loginLocalRepository) {
        return loginLocalRepository;
    }*/

    @Provides
    @Singleton
    UserRemoteRepositoryImp providesUserRemoteRepository(UserRemoteRepository userRemoteRepository) {
        return userRemoteRepository;
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