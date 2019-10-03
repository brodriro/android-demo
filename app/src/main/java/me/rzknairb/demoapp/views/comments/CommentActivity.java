package me.rzknairb.demoapp.views.comments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.ButterKnife;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseActivity;
import me.rzknairb.domain.entities.Feed;

public class CommentActivity extends BaseActivity implements CommentPresenter.View {

    private static final String PARAM_POST = "FEED";

    public static Intent getCallIntent(Context context, Feed post) {
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra(CommentActivity.PARAM_POST, new Gson().toJson(post, Feed.class));
        return intent;
    }

    @Inject
    CommentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);

        presenter.start(getIntent().getStringExtra(PARAM_POST));

    }

    @Override
    public void onDataReady(Feed post) {
        Toast.makeText(this, "onDataIsReady", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "onError", Toast.LENGTH_SHORT).show();
    }
}
