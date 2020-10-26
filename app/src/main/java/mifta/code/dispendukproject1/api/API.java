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

    @GET("count_ktp_perekaman_kab.php")
    Call<respon> count_ktp_perekaman_kab();
    //@Header("Authorization") String Authorization
    @GET("count_ktp_perekaman_kec.php")
    Call<respon> count_ktp_perekaman_kec();

    @GET("count_perpindahan_kab.php")
    Call<respon> count_perpindahan_kab();
    //@Header("Authorization") String Authorization
    @GET("count_perpindahan_kec.php")
    Call<respon> count_perpindahan_kec();

    @GET("count_biodata_kec.php")
    Call<respon> count_biodata_kec();
    //@Header("Authorization") String Authorization
    @GET("count_biodata_kab.php")
    Call<respon> count_biodata_kab();

    @GET("count_kelahiran_kab.php")
    Call<respon> count_kelahiran_kab();
    //@Header("Authorization") String Authorization
    @GET("count_kelahiran_kec.php")
    Call<respon> count_kelahiran_kec();

    @GET("count_kematian_kab.php")
    Call<respon> count_kematian_kab();
    //@Header("Authorization") String Authorization
    @GET("count_kematian_kec.php")
    Call<respon> count_kematian_kec();

    @GET("count_perceraian_kab.php")
    Call<respon> count_perceraian_kab();
    //@Header("Authorization") String Authorization
    @GET("count_perceraian_kec.php")
    Call<respon> count_perceraian_kec();

    @GET("count_perkawinan_kab.php")
    Call<respon> count_perkawinan_kab();
    //@Header("Authorization") String Authorization
    @GET("count_perkawinan_kec.php")
    Call<respon> count_perkawinan_kec();
}
