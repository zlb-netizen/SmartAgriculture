package com.cqsx.rgzn.smartagriculture.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cqsx.rgzn.smartagriculture.R;
import com.cqsx.rgzn.smartagriculture.Untils.Rabat;

import java.util.ArrayList;

public class RabatAdapter extends BaseAdapter {
    private Context c;
    private ArrayList<Rabat> list;
    private LayoutInflater inflater;

    public RabatAdapter(Context c, ArrayList<Rabat> list) {
        this.c = c;
        this.list = list;
        inflater =((Activity)c).getLayoutInflater();
    }

    @Override
    public String toString() {
        return "FeiAdapter{" +
                "c=" + c +
                ", list=" + list +
                ", inflater=" + inflater +
                '}';
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int id =  ((Rabat)this.getItem(i)).getImgID();
        boolean isSend = ((Rabat)this.getItem(i)).isSend();
        String msg = ((Rabat)this.getItem(i)).getMsg();
        if(isSend)
            view = inflater.inflate(R.layout.right_item,viewGroup,false);
        else
            view = inflater.inflate(R.layout.left_item,viewGroup,false);
        ImageView img  = view.findViewById(R.id.iv_item_icon);
        TextView textView  = view.findViewById(R.id.tv_item_msg);
        img.setImageResource(id);
        textView.setText(msg);


        return view;
    }
}
