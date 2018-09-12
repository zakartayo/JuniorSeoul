package com.example.multimedia.juniorseoul.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.multimedia.juniorseoul.Classess.ParcelBitmapList;
import com.example.multimedia.juniorseoul.R;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.ItemViewHolder> {
    ParcelBitmapList mItems;
    int size;

public DetailRecyclerAdapter(ParcelBitmapList items, int size){
        mItems = items;
        this.size = size;
    }


// 새로운 뷰 홀더 생성
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

// View 의 내용을 해당 포지션의 데이터로 바꿉니다.
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.imageView.setImageBitmap(mItems.getBitmap(position));
    }

// 데이터 셋의 크기를 리턴해줍니다.
    @Override
    public int getItemCount() {
        return size;
    }

// 커스텀 뷰홀더
// item layout 에 존재하는 위젯들을 바인딩합니다.
   public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.kidscafe_detail_img);
        }
    }
}