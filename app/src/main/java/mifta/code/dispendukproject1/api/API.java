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

    @FormUrlEncoded
    @POST("biodata_desa.php")
    Call<respon> biodata_desa(@Header("Authorization") String Authorization,
                              @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("kelahiran_desa.php")
    Call<respon> kelahiran_desa(@Header("Authorization") String Authorization,
                                @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("kematian_desa.php")
    Call<respon> kematian_desa(@Header("Authorization") String Authorization,
                               @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("kk_desa.php")
    Call<respon> kk_desa(@Header("Authorization") String Authorization,
                         @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("pencetakan_desa.php")
    Call<respon> pencetakan_desa(@Header("Authorization") String Authorization,
                                 @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("perceraian_desa.php")
    Call<respon> perceraian_desa(@Header("Authorization") String Authorization,
                                 @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("perekaman_desa.php")
    Call<respon> perekaman_desa(@Header("Authorization") String Authorization,
                                @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("perkawinan_desa.php")
    Call<respon> perkawinan_desa(@Header("Authorization") String Authorization,
                                 @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("perpindahan_desa.php")
    Call<respon> perpindahan_desa(@Header("Authorization") String Authorization,
                                  @Field("NO_KEC") int NO_KEC);

    @FormUrlEncoded
    @POST("biodata_detail.php")
    Call<respon> biodata_detail(@Header("Authorization") String Authorization,
                                @Field("NO_KEC") int NO_KEC,
                                @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("kk_detail.php")
    Call<respon> kk_detail(@Header("Authorization") String Authorization,
                           @Field("NO_KEC") int NO_KEC,
                           @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("kelahiran_detail.php")
    Call<respon> kelahiran_detail(@Header("Authorization") String Authorization,
                                  @Field("NO_KEC") int NO_KEC,
                                  @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("kematian_detail.php")
    Call<respon> kematian_detail(@Header("Authorization") String Authorization,
                                 @Field("NO_KEC") int NO_KEC,
                                 @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("pencetakan_detail.php")
    Call<respon> pencetakan_detail(@Header("Authorization") String Authorization,
                                   @Field("NO_KEC") int NO_KEC,
                                   @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("perekaman_detail.php")
    Call<respon> perekaman_detail(@Header("Authorization") String Authorization,
                                  @Field("NO_KEC") int NO_KEC,
                                  @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("perpindahan_detail.php")
    Call<respon> perpindahan_detail(@Header("Authorization") String Authorization,
                                    @Field("NO_KEC") int NO_KEC,
                                    @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("perkawinan_detail.php")
    Call<respon> perkawinan_detail(@Header("Authorization") String Authorization,
                                   @Field("NO_KEC") int NO_KEC,
                                   @Field("NO_KEL") int NO_KEL);

    @FormUrlEncoded
    @POST("perceraian_detail.php")
    Call<respon> perceraian_detail(@Header("Authorization") String Authorization,
                                   @Field("NO_KEC") int NO_KEC,
                                   @Field("NO_KEL") int NO_KEL);
}
