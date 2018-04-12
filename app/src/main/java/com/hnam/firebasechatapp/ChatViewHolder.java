package com.hnam.firebasechatapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
        View.OnLongClickListener {

    private int position;
    private MyMessage item;

    private OnChatViewHolderListener mListener;

    private TextView tvTitle;
    private TextView tvDescription;

    public interface OnChatViewHolderListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    public ChatViewHolder(View view, OnChatViewHolderListener listener) {
        super(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        tvTitle = view.findViewById(R.id.tv_title);
        tvDescription = view.findViewById(R.id.tv_description);
        mListener = listener;

    }

    public void renderUi(int position, MyMessage entity) {
        this.position = position;
        tvTitle.setText(entity.getText());

        Date date = new Date();
        date.setTime(entity.getTimestampe());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        String time = sdf.format(date);
        tvDescription.setText(time);
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onClick(position);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mListener != null) {
            mListener.onLongClick(position);
        }
        return false;
    }
}