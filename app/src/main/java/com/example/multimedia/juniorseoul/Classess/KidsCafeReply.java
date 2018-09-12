package com.example.multimedia.juniorseoul.Classess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KidsCafeReply {
    @SerializedName("list")
    @Expose
    private ArrayList<ReplyList> replyList = null;

    public ArrayList<ReplyList> getReplyList() {
        return replyList;
    }

    public void setReplyList(ArrayList<ReplyList> replyList){
        this.replyList = replyList;
    }
}
