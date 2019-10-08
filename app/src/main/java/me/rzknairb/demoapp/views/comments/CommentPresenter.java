package me.rzknairb.demoapp.views.comments;

import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;
import me.rzknairb.domain.entities.Feed;
import me.rzknairb.domain.entities.User;
import me.rzknairb.domain.usecases.ProfileUseCase;

/**
 * Created by Brian Rodriguez on 2/10/2019
 */
@Reusable
public class CommentPresenter extends BasePresenter<CommentPresenter.View> {

    @Inject
    public CommentPresenter(View view) {
        super(view);
    }

    @Inject
    ProfileUseCase profileUseCase;

    private User mSession;

    public void start(String post) {
        Feed feed = new Gson().fromJson(post, Feed.class);
        if (feed == null) {
            getView().onError();
            return;
        }

        getView().onDataReady(feed);

        mSession = profileUseCase.getSession();
    }

    public void onNewComment(String comment) {
        if (comment.trim().isEmpty()) {
            getView().onCommentIsEmpty();
            return;
        }

        Feed.Comment mComment = new Feed().new Comment(
                String.valueOf(mSession.getId()),
                mSession.getUsername(),
                mSession.getImage(),
                comment
        );

        getView().onNewComment(mComment);
    }

    public void onClickProfile(String idProfile) {
        getView().goToUserProfile(idProfile);
    }

    public interface View extends BasePresenter.View {
        void onDataReady(Feed post);

        void onError();

        void onCommentIsEmpty();

        void onNewComment(Feed.Comment comment);

        void goToUserProfile(String idProfile);
    }
}
