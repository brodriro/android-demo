package me.rzknairb.demoapp.views.profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.rzknairb.demoapp.R;
import me.rzknairb.demoapp.views.BaseFragment;
import me.rzknairb.domain.entities.User;

public class ProfileFragment extends BaseFragment implements ProfilePresenter.View {

    @Inject
    ProfilePresenter profilePresenter;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.profile_fullname)
    TextView tvFullname;


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profilePresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onLoadProfile(User user) {
        tvFullname.setText(user.getName() + " " + user.getLastname());
        Log.e("ProfileFragment", user.getEmail());
        Toast.makeText(this.getContext(), "Implementar Perfil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorProfile() {
        Toast.makeText(this.getContext(), "Error al cargar Perfil", Toast.LENGTH_SHORT).show();
    }
}
