package me.rzknairb.demoapp.views.profile;

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
    ProfileUseCase profileUseCase;


    @Inject
    public ProfilePresenter(View view) {
        super(view);
    }

    public void start() {
        profileUseCase.getProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(getView()))
                .subscribe(
                        user -> getView().onLoadProfile(user),
                        throwable -> getView().onErrorProfile()
                );
    }


    public interface View extends BasePresenter.View {
        void onLoadProfile(User user);

        void onErrorProfile();
    }
}
