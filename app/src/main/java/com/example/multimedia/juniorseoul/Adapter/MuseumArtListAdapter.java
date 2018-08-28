package com.example.multimedia.juniorseoul.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.multimedia.juniorseoul.Classess.KidsCafeListItem;
import com.example.multimedia.juniorseoul.Classess.MuseumArtListItem;
import com.example.multimedia.juniorseoul.R;

import java.util.ArrayList;

public class MuseumArtListAdapter extends BaseAdapter {
    private ArrayList<MuseumArtListItem> listViewItemList = new ArrayList<>();

    public MuseumArtListAdapter(){

    }

    @Override
    public int getCount(){
        return listViewItemList.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.kids_cafe_list_item, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.kids_cafe_list_name) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        MuseumArtListItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        nameTextView.setText(listViewItem.getName());

        return convertView;
    }
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(String name) {
        MuseumArtListItem item = new MuseumArtListItem();

        item.setName(name);

        listViewItemList.add(item);
    }

}