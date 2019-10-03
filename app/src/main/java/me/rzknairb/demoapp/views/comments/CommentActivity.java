package me.rzknairb.demoapp.views.comments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import me.rzknairb.demoapp.R;
import me.rzknairb.domain.entities.Feed;

public class CommentActivity extends AppCompatActivity {

    private static final String PARAM_POST = "FEED";

    public static Intent getCallIntent(Context context, Feed post) {
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra(CommentActivity.PARAM_POST, new Gson().toJson(post, Feed.class));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }
}
