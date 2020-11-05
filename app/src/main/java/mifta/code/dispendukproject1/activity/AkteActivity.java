package mifta.code.dispendukproject1.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.api.API;
import mifta.code.dispendukproject1.api.koneksi;
import mifta.code.dispendukproject1.api.respon;
import mifta.code.dispendukproject1.api.tampil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AkteActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView kelahiran, kematian, perkawinan, perceraian;
    private List<tampil> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akte);

        kelahiran = findViewById(R.id.bt_kelahiran);
        kematian = findViewById(R.id.bt_kematian);
        perkawinan = findViewById(R.id.bt_perkawinan);
        perceraian = findViewById(R.id.bt_perceraian);

        kelahiran.setOnClickListener(this);
        kematian.setOnClickListener(this);
        perkawinan.setOnClickListener(this);
        perceraian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_kelahiran:
                Intent a = new Intent(AkteActivity.this, AktaKelahiranActivity.class);
                startActivity(a);
                break;
            case R.id.bt_kematian:
                Intent b = new Intent(AkteActivity.this, AktaKematianActivity.class);
                startActivity(b);
                break;
            case R.id.bt_perceraian:
                Intent c = new Intent(AkteActivity.this, AktaPerceraianActivity.class);
                startActivity(c);
                break;
            case R.id.bt_perkawinan:
                Intent d = new Intent(AkteActivity.this, AktaPerkawinanActivity.class);
                startActivity(d);
                break;
        }
    }

//    private void logout() {
//        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
//        SharedPreferences.Editor akses = sharedPreferences.edit();
//        akses.clear();
//        akses.commit();
//        startActivity(new Intent(AkteActivity.this, LoginActivity.class));
//        finish();
//    }

//    private void tampil_kelahiran() {
//        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
//        final String jwt_ = sharedPreferences.getString("jwt", "0");
//        API api = koneksi.getClient().create(API.class);
//
//        Call<respon> aksi = api.count_kelahiran_kab(jwt_);
//
//        aksi.enqueue(new Callback<respon>() {
//            @Override
//            public void onResponse(Call<respon> call, Response<respon> response) {
//                results.clear();
//                if (response.code() != 200) {
//                    Toast.makeText(AkteActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
//                    logout();
//                } else {
//                    results = response.body().getResult();
//                    for (int i = 0; i < results.size(); i++) {
//                        kelahiran.setText(String.valueOf(results.get(i).TOTAL));
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<respon> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void tampil_kematian() {
//        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
//        final String jwt_ = sharedPreferences.getString("jwt", "0");
//        API api = koneksi.getClient().create(API.class);
//
//        Call<respon> aksi = api.count_kematian_kab(jwt_);
//
//        aksi.enqueue(new Callback<respon>() {
//            @Override
//            public void onResponse(Call<respon> call, Response<respon> response) {
//                results.clear();
//                if (response.code() != 200) {
//                    Toast.makeText(AkteActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
//                    logout();
//                } else {
//                    results = response.body().getResult();
//                    for (int i = 0; i < results.size(); i++) {
//                        kematian.setText(String.valueOf(results.get(i).TOTAL));
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<respon> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void tampil_perceraian() {
//        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
//        final String jwt_ = sharedPreferences.getString("jwt", "0");
//        API api = koneksi.getClient().create(API.class);
//
//        Call<respon> aksi = api.count_perceraian_kab(jwt_);
//
//        aksi.enqueue(new Callback<respon>() {
//            @Override
//            public void onResponse(Call<respon> call, Response<respon> response) {
//                results.clear();
//                if (response.code() != 200) {
//                    Toast.makeText(AkteActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
//                    logout();
//                } else {
//                    results = response.body().getResult();
//                    for (int i = 0; i < results.size(); i++) {
//                        perceraian.setText(String.valueOf(results.get(i).TOTAL));
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<respon> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void tampil_perkawinan() {
//        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
//        final String jwt_ = sharedPreferences.getString("jwt", "0");
//        API api = koneksi.getClient().create(API.class);
//
//        Call<respon> aksi = api.count_perkawinan_kab(jwt_);
//
//        aksi.enqueue(new Callback<respon>() {
//            @Override
//            public void onResponse(Call<respon> call, Response<respon> response) {
//                results.clear();
//                if (response.code() != 200) {
//                    Toast.makeText(AkteActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
//                    logout();
//                } else {
//                    results = response.body().getResult();
//                    for (int i = 0; i < results.size(); i++) {
//                        perkawinan.setText(String.valueOf(results.get(i).TOTAL));
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<respon> call, Throwable t) {
//
//            }
//        });
//    }
}