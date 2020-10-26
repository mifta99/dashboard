package mifta.code.dispendukproject1.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.Circle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mifta.code.dispendukproject1.Utils.API;
import mifta.code.dispendukproject1.Adapter.KkAdapter;
import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.Utils.koneksi;
import mifta.code.dispendukproject1.Model.respon;
import mifta.code.dispendukproject1.Model.tampil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static mifta.code.dispendukproject1.Utils.Colors.colors;

public class KkActivity extends AppCompatActivity {
    TextView tanggal, bulan, tahun, hari, total_kab;
    private List<tampil> results = new ArrayList<>();
    private KkAdapter kkAdapter;
    RecyclerView tampilKk;
    ProgressBar progressBar;
    SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kk);

        tanggal = findViewById(R.id.tv_date);
        bulan = findViewById(R.id.tv_month);
        tahun = findViewById(R.id.tv_year);
        hari = findViewById(R.id.tv_day);
        progressBar = findViewById(R.id.progressBar);
        total_kab = findViewById(R.id.tv_totalKab);
//        spinKitView = findViewById(R.id.spin_kit);


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String year_ = String.valueOf(year);
        tahun.setText(year_.substring(Math.max(year_.length() - 2, 0)));
        int date = calendar.get(Calendar.DATE);
        tanggal.setText(String.valueOf(date));
        int month = calendar.get(Calendar.MONTH);
        bulan.setText(String.valueOf(month + 1));
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 2) {
            hari.setText("Senin");
        } else if (day == 3) {
            hari.setText("Selasa");
        } else if (day == 4) {
            hari.setText("Rabu");
        } else if (day == 5) {
            hari.setText("Kamis");
        } else if (day == 6) {
            hari.setText("Jum'at");
        } else if (day == 7) {
            hari.setText("Sabtu");
        } else if (day == 1) {
            hari.setText("Minggu");
        }

        tampilKk = findViewById(R.id.rv_kk);
        tampilKk.setHasFixedSize(true);

        Circle doubleBounce = new Circle();
//        doubleBounce.setBounds(0, 0, 100, 100);
        doubleBounce.setColor(colors[8]);
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        tampilKk.setLayoutManager(llm);

        tampil_kab();
        tampil_kec();
    }

//    private void showLoading(Boolean state) {
//        if (state) {
//
//            progressBar.setVisibility(View.VISIBLE);
//        } else {
//            progressBar.setVisibility(View.GONE);
//        }
//    }


    private void tampil_kec() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String jwt_ = sharedPreferences.getString("jwt", "0");
        API api = koneksi.getClient().create(API.class);

        Call<respon> aksi = api.count_kk_kec();

        aksi.enqueue(new Callback<respon>() {
            @Override
            public void onResponse(Call<respon> call, Response<respon> response) {
//                showLoading(true);
                progressBar.setVisibility(View.VISIBLE);
                String kode = response.body().getValue();
                results.clear();
                if (kode.equals("1")) {
//                    showLoading(false);
                    progressBar.setVisibility(View.GONE);
                    results = response.body().getResult();
                    kkAdapter = new KkAdapter(KkActivity.this, results);
                    tampilKk.setAdapter(kkAdapter);
//                Log.d("coderespon", String.valueOf(response.code()));
//                if (response.code() != 200){
//                   Toast.makeText(KkActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
//                    logout();
//                }else {
//
//                    }
                }

            }

            @Override
            public void onFailure(Call<respon> call, Throwable t) {

            }
        });
    }
    private void tampil_kab() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String jwt_ = sharedPreferences.getString("jwt", "0");
        API api = koneksi.getClient().create(API.class);

        Call<respon> aksi = api.count_kk_kab();

        aksi.enqueue(new Callback<respon>() {
            @Override
            public void onResponse(Call<respon> call, Response<respon> response) {
                String kode = response.body().getValue();
                results.clear();
                if (kode.equals("1")) {
                    results = response.body().getResult();
                    for (int i = 0; i < results.size(); i++) {
                        total_kab.setText(String.valueOf(results.get(i).getTOTAL()));
                    }
//                Log.d("coderespon", String.valueOf(response.code()));
//                if (response.code() != 200){
//                   Toast.makeText(KkActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
//                    logout();
//                }else {
//
//                    }
                }

            }

            @Override
            public void onFailure(Call<respon> call, Throwable t) {

            }
        });
    }
    private void logout() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        SharedPreferences.Editor akses = sharedPreferences.edit();
        akses.clear();
        akses.commit();
        startActivity(new Intent(KkActivity.this, AktaKelahiranActivity.LoginActivity.class));
        finish();
    }
}