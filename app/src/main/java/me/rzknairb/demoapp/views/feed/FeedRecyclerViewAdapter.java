package me.rzknairb.demoapp.views.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.rzknairb.demoapp.R;
import me.rzknairb.domain.entities.Feed;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter.ViewHolder> {

    private List<Feed> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FeedRecyclerViewAdapter(OnListFragmentInteractionListener listener) {
        mListener = listener;
        mValues = new ArrayList<>();
    }

    public void setList(List<Feed> list) {
        mValues = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_feed_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Feed post = mValues.get(position);

        holder.description.setText(post.getBody().replace("\n", ""));
        holder.username.setText(post.getUsername());
        holder.tv_likes.setText(post.getLikes());
        holder.bt_comment.setOnClickListener(v -> mListener.onListFragmentInteraction(post));

        Glide.with(holder.itemView.getContext())
                .load(post.getUser_image())
                .centerCrop()
                .into(holder.userImage);
        Glide.with(holder.itemView.getContext())
                .load(post.getImage())
                .into(holder.mainImage);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_feed_row_profile)
        CircleImageView userImage;
        @BindView(R.id.iv_feed_item_main)
        ImageView mainImage;
        @BindView(R.id.tv_feed_item_description)
        TextView description;
        @BindView(R.id.tv_feed_item_username)
        TextView username;
        @BindView(R.id.btn_feed_item_comment)
        Button bt_comment;
        @BindView(R.id.tv_feed_item_likes)
        TextView tv_likes;

        public final View mView;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, mView);
        }
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Feed item);
    }
}
