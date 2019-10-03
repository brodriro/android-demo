package me.rzknairb.demoapp.views.comments;

import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.Reusable;
import me.rzknairb.demoapp.views.BasePresenter;
import me.rzknairb.domain.entities.Feed;

/**
 * Created by Brian Rodriguez on 2/10/2019
 */
@Reusable
public class CommentPresenter extends BasePresenter<CommentPresenter.View> {

    @Inject
    public CommentPresenter(View view) {
        super(view);
    }

    public void start(String post) {
      Feed feed =   new Gson().fromJson(post, Feed.class);
      if (feed == null) getView().onError();

      getView().onDataReady(feed);
    }

    public interface View extends BasePresenter.View{
        void onDataReady(Feed post);
        void onError();
    }
}
