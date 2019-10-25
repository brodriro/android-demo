package me.rzknairb.demoapp.views.user_profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.utils.Utils;
import me.rzknairb.demoapp.views.BaseActivity;
import me.rzknairb.domain.entities.User;


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

        presenter.start(getIntent().getStringExtra(USER_ID));
        initViews();

    }

    private void initViews() {
        profileContainer.setBackground(getDrawable(R.drawable.layout_radius_primary));
        ivEmail.setVisibility(android.view.View.GONE);
        ivPhone.setVisibility(android.view.View.GONE);

        years.setText("");
        email.setText("");
        location.setText("");
        occupation.setText("");
    }

    @Override
    public void onProfileReady(User user) {

        Glide.with(this)
                .load(user.getImage())
                .centerCrop()
                .into(imageView);

        if (!user.getEmail().trim().isEmpty()) {
            ivEmail.setVisibility(View.VISIBLE);
            email.setText(user.getEmail());
        }

        if (!user.getAge().trim().isEmpty()) {
            ivPhone.setVisibility(View.VISIBLE);
        }

        likes.setText(user.getSocial().getLikes());
        shares.setText(user.getSocial().getShares());
        posts.setText(user.getSocial().getPosts());
        friends.setText(user.getSocial().getFriends());


        tvFullname.setVisibility(View.VISIBLE);
        tvFullname.setText(String.format("%s %s", user.getName(), user.getLastname()));
        location.setText(user.getLocation());
        occupation.setText(user.getOccupation());
        years.setText(user.getAge());

        ivPhone.setOnClickListener(v -> onCallPhone(v,  user.getPhone()));
        ivEmail.setOnClickListener(v -> onSendEmail(v, user.getEmail(), user.getName()));
    }

    private void onSendEmail(View view, String email, String username) {
        startActivity(Utils.sendEmailAction(email, username));
    }

    private void onCallPhone(View view, String phoneNumber) {
        startActivity(Utils.sendPhoneAction(phoneNumber));
    }

    @Override
    public void onErrorProfile() {
        Toast.makeText(this, "Error al cargar usuario", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showLoading() {
        showProgressBar();
    }

    @Override
    public void hideLoading() {
        hideProgressBar();
    }
}
