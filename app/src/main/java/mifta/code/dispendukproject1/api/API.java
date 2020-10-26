package mifta.code.dispendukproject1.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("login.php")
    Call<respon> login(@Field("username") String username,
                       @Field("password") String password);

    @GET("count_kk_kab.php")
    Call<respon> count_kk_kab();
    //@Header("Authorization") String Authorization
    @GET("count_kk_kec.php")
    Call<respon> count_kk_kec();
}
