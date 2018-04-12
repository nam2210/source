package com.hnam.firebasechatapp;

/**
 * Created by nampham on 4/12/18.
 */
public class MyMessage {
    private String text;
    private long timestampe;

    public MyMessage() {
    }

    public MyMessage(String text, long timestampe) {
        this.text = text;
        this.timestampe = timestampe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimestampe() {
        return timestampe;
    }

    public void setTimestampe(long timestampe) {
        this.timestampe = timestampe;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "text='" + text + '\'' +
                ", timestampe=" + timestampe +
                '}';
    }
}
