package mifta.code.dispendukproject1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KkActivity extends AppCompatActivity {
    TextView tanggal, bulan, tahun, hari;
    private List<tampil> results = new ArrayList<>();
    private KkAdapter kkAdapter;
    RecyclerView tampilKk;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kk);

        tanggal = findViewById(R.id.tv_date);
        bulan = findViewById(R.id.tv_month);
        tahun = findViewById(R.id.tv_year);
        hari = findViewById(R.id.tv_day);
        progressBar = findViewById(R.id.progressBar);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String year_ = String.valueOf(year);
        tahun.setText(year_.substring(Math.max(year_.length() - 2, 0)));
        int date = calendar.get(Calendar.DATE);
        tanggal.setText(String.valueOf(date));
        int month = calendar.get(Calendar.MONTH);
        bulan.setText(String.valueOf(month + 1));
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            hari.setText("Senin");
        } else if (day == 2) {
            hari.setText("Selasa");
        } else if (day == 3) {
            hari.setText("Rabu");
        } else if (day == 4) {
            hari.setText("Kamis");
        } else if (day == 5) {
            hari.setText("Jum'at");
        } else if (day == 6) {
            hari.setText("Sabtu");
        } else if (day == 7) {
            hari.setText("Minggu");
        }

        tampilKk = findViewById(R.id.rv_kk);
        tampilKk.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        tampilKk.setLayoutManager(llm);

        tampil();
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }


    private void tampil() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String jwt_ = sharedPreferences.getString("jwt", "0");
        API api = koneksi.getClient().create(API.class);

        Call<respon> aksi = api.count_kk_kec();

        aksi.enqueue(new Callback<respon>() {
            @Override
            public void onResponse(Call<respon> call, Response<respon> response) {
                String kode = response.body().getValue();
                results.clear();
                if (kode.equals("1")) {
                    showLoading(false);
                    results = response.body().getResult();
                    kkAdapter = new KkAdapter(KkActivity.this, results);
                    tampilKk.setAdapter(kkAdapter);
                showLoading(true);
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
        startActivity(new Intent(KkActivity.this, LoginActivity.class));
        finish();
    }
}