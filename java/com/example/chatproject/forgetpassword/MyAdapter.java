package com.example.chatproject.forgetpassword;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chatproject.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<Admin> admins;
    LayoutInflater layoutInflater;

    public MyAdapter(Context aContext, ArrayList<Admin> admins) {
        this.admins = admins;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return admins.size();
    }

    @Override
    public Object getItem(int position) {
        return admins.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.admin_list_item, null);
            holder = new ViewHolder();
            holder.adminName = convertView.findViewById(R.id.name);
            holder.adminType = convertView.findViewById(R.id.type);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adminName.setText(admins.get(position).getName());
        holder.adminType.setText(admins.get(position).getType());
        return convertView;
    }

    static class ViewHolder {
        TextView adminName;
        TextView adminType;
    }
}
