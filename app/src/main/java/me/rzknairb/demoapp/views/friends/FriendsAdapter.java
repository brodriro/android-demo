package me.rzknairb.demoapp.views.friends;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.rzknairb.demoapp.R;
import me.rzknairb.domain.entities.User;

/**
 * Created by Brian Rodriguez on 12/10/2019
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    private List<User> friendsList;
    private FriendAdapterListener listener;

    @Inject
    public FriendsAdapter() {
        friendsList = new ArrayList<>();
    }

    public void addListener(FriendAdapterListener friendAdapterListener) {
        this.listener = friendAdapterListener;
    }

    public void updateList(List<User> list) {
        this.friendsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_friend_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user = friendsList.get(position);

        holder.fullname.setText(String.format("%s %s", user.getName(), user.getLastname()));
        if (!user.getImage().trim().isEmpty()) {
            Glide.with(holder.mView)
                    .load(user.getImage())
                    .centerCrop()
                    .into(holder.userImage);
        }

        if (listener != null) {
            holder.mView.setOnClickListener(v -> listener.onClickItemListener(String.valueOf(user.getId())));
            holder.mainWrapper.setOnClickListener(v -> holder.mView.callOnClick());
        }


        holder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, holder.leftWrapper);
        holder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, holder.rightWrapper);
        final String LocalTag = "Swipe";
        holder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {
            }

            @Override
            public void onOpen(SwipeLayout layout) {
                Log.e(LocalTag, "onOpen");
                if (layout.getCurrentBottomView() != null && layout.getCurrentBottomView().getId() == holder.leftWrapper.getId()){
                    listener.onSwipeLeft(user);
                    layout.close();
                }

                if (layout.getCurrentBottomView() != null && layout.getCurrentBottomView().getId() == holder.rightWrapper.getId()){
                    listener.onSwipeRight(user);
                    layout.close();
                }

                if (layout.getCurrentBottomView() != null && layout.getCurrentBottomView().getId() == holder.mainWrapper.getId()){
                    Log.e(LocalTag, "mainWrapper");
                }
            }

            @Override
            public void onStartClose(SwipeLayout layout) {
                Log.e(LocalTag, "onStartClose");
            }

            @Override
            public void onClose(SwipeLayout layout) {
                Log.e(LocalTag, "onClose");
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                Log.e(LocalTag, "onHandRelease");
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.friendsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_friends_image)
        CircleImageView userImage;
        @BindView(R.id.tv_friend_fullname)
        TextView fullname;
        @BindView(R.id.swipeLayout_friends_item)
        SwipeLayout swipeLayout;
        @BindView(R.id.sfi_leftWrapper)
        LinearLayout leftWrapper;
        @BindView(R.id.sfi_rightWrapper)
        LinearLayout rightWrapper;
        @BindView(R.id.sfi_mainWrapper)
        LinearLayout mainWrapper;

        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, mView);
        }
    }

    public interface FriendAdapterListener {
        void onClickItemListener(String idUser);
        void onSwipeLeft(User user);
        void onSwipeRight(User user);
    }

}
