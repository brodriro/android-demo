package me.rzknairb.demoapp.views.feed;

import com.uber.autodispose.AutoDispose;

import java.util.List;

import javax.inject.Inject;

import dagger.Reusable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.rzknairb.demoapp.views.BasePresenter;
import me.rzknairb.domain.entities.Feed;
import me.rzknairb.domain.usecases.FeedUseCase;

@Reusable
public class FeedPresenter extends BasePresenter<FeedPresenter.View> {

    @Inject
    public FeedPresenter(View view) {
        super(view);
    }

    @Inject
    FeedUseCase useCase;

    public void start() {
        useCase.getFeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .as(AutoDispose.autoDisposable(getView()))
                .subscribe(
                        feed -> getView().feedReady(feed),
                        throwable -> getView().onErrorList()
                );
    }

    public interface View extends BasePresenter.View {

        void feedReady(List<Feed> feed);

        void onErrorList();

        void showLoading();

        void hideLoading();
    }
}
