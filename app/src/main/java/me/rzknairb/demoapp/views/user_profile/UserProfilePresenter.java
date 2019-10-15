package me.rzknairb.demoapp.views.user_profile;

import com.uber.autodispose.AutoDispose;

import javax.inject.Inject;

import dagger.Reusable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.rzknairb.demoapp.views.BasePresenter;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.usecases.UserProfileUseCase;

/**
 * Created by Brian Rodriguez on 7/10/2019
 */
@Reusable
public class UserProfilePresenter extends BasePresenter<UserProfilePresenter.View> {

    @Inject
    UserProfileUseCase useCase;

    @Inject
    public UserProfilePresenter(View view) {
        super(view);
    }


    public void start(String userId) {
        useCase.getUserById(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .as(AutoDispose.autoDisposable(getView()))
                .subscribe(
                        user -> getView().onProfileReady(user),
                        throwable -> getView().onErrorProfile()
                );
    }

    public interface View extends BasePresenter.View{
        void onProfileReady(User user);
        void onErrorProfile();

        void showLoading();

        void hideLoading();
    }
}
