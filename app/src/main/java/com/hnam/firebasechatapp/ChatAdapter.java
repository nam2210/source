package com.hnam.firebasechatapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by nampham on 4/12/18.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {
    private static final String TAG = ChatAdapter.class.getSimpleName();
    private Activity mActivity;
    private List<MyMessage> mData;
    private LayoutInflater mLayoutInflater;


    public ChatAdapter(Activity activity) {
        mLayoutInflater = LayoutInflater.from(activity);
        mActivity = activity;
        mData = new ArrayList<>();
    }

    public void setData(List<MyMessage> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(MyMessage data){
        mData.add(data);
        notifyItemInserted(mData.size() - 1);
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.row_chat, parent, false);
        return new ChatViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        MyMessage entity = mData.get(position);
        holder.renderUi(position, entity);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    private final ChatViewHolder.OnChatViewHolderListener listener = new ChatViewHolder.OnChatViewHolderListener() {
        @Override
        public void onClick(int position) {

        }

        @Override
        public void onLongClick(int position) {

        }
    };
}
