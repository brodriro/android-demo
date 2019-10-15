package me.rzknairb.demoapp.views.friends;

import com.uber.autodispose.AutoDispose;

import java.util.List;

import javax.inject.Inject;

import dagger.Reusable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.rzknairb.demoapp.views.BasePresenter;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.usecases.FriendsUseCase;

/**
 * Created by Brian Rodriguez on 11/10/2019
 */

@Reusable
public class FriendsPresenter extends BasePresenter<FriendsPresenter.View> {

    @Inject
    FriendsUseCase useCase;

    @Inject
    public FriendsPresenter(View view) {
        super(view);
    }

    public void start() {
        useCase.getFriends()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(getView()))
                .subscribe(list -> getView().onDataReady(list), throwable -> getView().onError());
    }

    public interface View extends BasePresenter.View {
        void onDataReady(List<User> list);

        void onError();

        void showLoading();

        void hideLoading();
    }
}
