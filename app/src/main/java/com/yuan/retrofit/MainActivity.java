package com.yuan.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public List<BaseResponse<Bean>> mylist = new ArrayList<BaseResponse<Bean>>();
    public Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory
                        .create(new GsonBuilder().create())).build();

        RetrofitService service=retrofit.create(RetrofitService.class);
        Call<BaseResponse<Bean>> call=service.getBean(1);
        call.enqueue(new Callback<BaseResponse<Bean>>() {
            @Override
            public void onResponse(Call<BaseResponse<Bean>> call, Response<BaseResponse<Bean>> response) {
                if (response.body() != null) {
                    BaseResponse<Bean> bean=response.body();
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(mylist.toString());

//                    mylist = bean.   这里该怎么写？？;

                    MyAdapter adapter = new MyAdapter(MainActivity.this,mylist);
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Bean>> call, Throwable t) {
                System.out.println("失败");
            }
        });
    }
}
