package com.yuan.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019/1/26 0026.
 */

public interface RetrofitService {
    @GET("article/list/{page}/json")
    Call<BaseResponse<Bean>> getBean(@Path("page") int page);
}
