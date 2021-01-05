package mifta.code.dispendukproject1.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("login.php")
    Call<respon> login(@Field("username") String username,
                       @Field("password") String password);

    @GET("count_kk_kab.php")
    Call<respon> count_kk_kab(@Header("Authorization") String Authorization);

    @GET("count_kk_kec.php")
    Call<respon> count_kk_kec(@Header("Authorization") String Authorization);

    @GET("count_ktp_perekaman_kab.php")
    Call<respon> count_ktp_perekaman_kab(@Header("Authorization") String Authorization);

    @GET("count_ktp_perekaman_kec.php")
    Call<respon> count_ktp_perekaman_kec(@Header("Authorization") String Authorization);

    @GET("count_ktp_pencetakan_kab.php")
    Call<respon> count_ktp_pencetakan_kab(@Header("Authorization") String Authorization);

    @GET("count_ktp_pencetakan_kec.php")
    Call<respon> count_ktp_pencetakan_kec(@Header("Authorization") String Authorization);

    @GET("count_perpindahan_kab.php")
    Call<respon> count_perpindahan_kab(@Header("Authorization") String Authorization);

    @GET("count_perpindahan_kec.php")
    Call<respon> count_perpindahan_kec(@Header("Authorization") String Authorization);

    @GET("count_biodata_kec.php")
    Call<respon> count_biodata_kec(@Header("Authorization") String Authorization);

    @GET("count_biodata_kab.php")
    Call<respon> count_biodata_kab(@Header("Authorization") String Authorization);

    @GET("count_kelahiran_kab.php")
    Call<respon> count_kelahiran_kab(@Header("Authorization") String Authorization);

    @GET("count_kelahiran_kec.php")
    Call<respon> count_kelahiran_kec(@Header("Authorization") String Authorization);

    @GET("count_kematian_kab.php")
    Call<respon> count_kematian_kab(@Header("Authorization") String Authorization);

    @GET("count_kematian_kec.php")
    Call<respon> count_kematian_kec(@Header("Authorization") String Authorization);

    @GET("count_perceraian_kab.php")
    Call<respon> count_perceraian_kab(@Header("Authorization") String Authorization);

    @GET("count_perceraian_kec.php")
    Call<respon> count_perceraian_kec(@Header("Authorization") String Authorization);

    @GET("count_perkawinan_kab.php")
    Call<respon> count_perkawinan_kab(@Header("Authorization") String Authorization);

    @GET("count_perkawinan_kec.php")
    Call<respon> count_perkawinan_kec(@Header("Authorization") String Authorization);

    @GET("biodata_1jat.php")
    Call<respon> biodata_1jat(@Header("Authorization") String Authorization);

    @GET("biodata_2bes.php")
    Call<respon> biodata_2bes(@Header("Authorization") String Authorization);

}
