package me.rzknairb.demoapp.di.modules;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;
import me.rzknairb.data.remote.repositories.FeedRemoteRepositoryImp;
import me.rzknairb.data.remote.repositories.UserRemoteRepositoryImp;
import me.rzknairb.domain.repositories.FeedRemoteRepository;
import me.rzknairb.domain.repositories.UserRemoteRepository;

@Module
public class AppModule {

    @Provides
    public Context context(Application application) {
        return application;
    }

    @Provides
    @Singleton
    UserRemoteRepository providesUserRemoteRepository(UserRemoteRepositoryImp userRemoteRepositoryImp) {
        return userRemoteRepositoryImp;
    }

    @Provides
    @Singleton
    FeedRemoteRepository providesFeedRemoteRepository(FeedRemoteRepositoryImp feedRemoteRepositoryImp){
        return feedRemoteRepositoryImp;
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