package me.rzknairb.demoapp.views.user_profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseActivity;


public class UserProfileActivity extends BaseActivity implements UserProfilePresenter.View {

    private static final String USER_ID = "USER_ID";

    public static Intent getCallIntent(Context context, String userId) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        intent.putExtra(UserProfileActivity.USER_ID, userId);
        return intent;
    }

    @BindView(R.id.profile_fullname)
    TextView tvFullname;
    @BindView(R.id.profile_image)
    CircleImageView imageView;
    @BindView(R.id.profile_ibPhone)
    ImageButton ivPhone;
    @BindView(R.id.profile_ibEmail)
    ImageButton ivEmail;

    @BindView(R.id.profile_likes)
    TextView likes;
    @BindView(R.id.profile_posts)
    TextView posts;
    @BindView(R.id.profile_shares)
    TextView shares;
    @BindView(R.id.profile_friends)
    TextView friends;

    @BindView(R.id.profile_years)
    TextView years;
    @BindView(R.id.profile_email)
    TextView email;
    @BindView(R.id.profile_location)
    TextView location;
    @BindView(R.id.profile_occupation)
    TextView occupation;

    @BindView(R.id.profile_main)
    ConstraintLayout profileContainer;


    @Inject
    UserProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ButterKnife.bind(this);

       // presenter.start(getIntent().getStringExtra(USER_ID));
        initViews();

    }

    private void initViews() {
        profileContainer.setBackground(getDrawable(R.drawable.layout_radius_primary));
    }

}
