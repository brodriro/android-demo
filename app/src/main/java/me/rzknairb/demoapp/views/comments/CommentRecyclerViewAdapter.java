package me.rzknairb.demoapp.views.comments;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder> {

    private List<Feed.Comment> mValues;
    private final OnClickProfileListener mListener;

    public CommentRecyclerViewAdapter(OnClickProfileListener listener) {
        mListener = listener;
        mValues = new ArrayList<>();
    }

    public void setList(List<Feed.Comment> list) {
        Log.e("COMMENT", "size:" + list.size());
        mValues = list;
        notifyDataSetChanged();
    }
    public void addComment(Feed.Comment comment){
        mValues.add(comment);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Feed.Comment comment = mValues.get(position);

        holder.tv_comment.setText(comment.getComment());
        holder.userImage.setOnClickListener(v -> mListener.onClickProfile(comment.getUser_id()));

        Glide.with(holder.itemView.getContext())
                .load(comment.getUser_image())
                .centerCrop()
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.comment_item_imageview)
        CircleImageView userImage;
        @BindView(R.id.comment_item_text)
        TextView tv_comment;

        public final View mView;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, mView);
        }
    }

    public interface OnClickProfileListener {
        void onClickProfile(String idProfile);
    }
}
