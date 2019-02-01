package com.yuan.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/2/1 0001.
 */

public class MyAdapter extends BaseAdapter {

    public List<BaseResponse<Bean>> mylist;
    public LayoutInflater inflater;

    public MyAdapter(Context context,List<BaseResponse<Bean>> outlist)
    {
        mylist=outlist;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list,null);
            holder = new Holder();
            holder.te = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.te.setText(mylist.get(position).toString());
        return convertView;
    }

}
class Holder{
    TextView te;
}


