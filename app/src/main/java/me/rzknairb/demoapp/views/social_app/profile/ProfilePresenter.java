package me.rzknairb.demoapp.views.social_app.profile;

import com.uber.autodispose.AutoDispose;

import javax.inject.Inject;

import dagger.Reusable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.rzknairb.demoapp.views.BasePresenter;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.usecases.ProfileUseCase;

@Reusable
public class ProfilePresenter extends BasePresenter<ProfilePresenter.View> {

    @Inject
    public ProfilePresenter(View view) {
        super(view);
    }

    @Inject
    ProfileUseCase profileUseCase;


    public void start() {
        profileUseCase.getProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getView().showLoading() )
                .doFinally(() -> getView().hideLoading())
                .as(AutoDispose.autoDisposable(getView()))
                .subscribe(
                        user -> getView().onLoadProfile(user),
                        throwable -> getView().onErrorProfile()
                );
    }


    public interface View extends BasePresenter.View {
        void onLoadProfile(User user);

        void onErrorProfile();

        void showLoading();

        void hideLoading();
    }
}
