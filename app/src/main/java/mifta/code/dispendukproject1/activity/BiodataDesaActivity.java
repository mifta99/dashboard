package mifta.code.dispendukproject1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.Circle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.adapter.BiodataDesaAdapter;
import mifta.code.dispendukproject1.api.API;
import mifta.code.dispendukproject1.api.koneksi;
import mifta.code.dispendukproject1.api.respon;
import mifta.code.dispendukproject1.api.tampil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static mifta.code.dispendukproject1.api.Colors.colors;

public class BiodataDesaActivity extends AppCompatActivity {
    TextView tanggal, bulan, tahun, hari, total_kab, nama;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    private List<tampil> results = new ArrayList<>();
    private BiodataDesaAdapter biodataDesaAdapter;
    private int no_kec;
    private String nama_kec, tot_kec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata_desa);

        tanggal = findViewById(R.id.tv_date);
        bulan = findViewById(R.id.tv_month);
        tahun = findViewById(R.id.tv_year);
        hari = findViewById(R.id.tv_day);
        progressBar = findViewById(R.id.progressBar);
        total_kab = findViewById(R.id.tv_totalKab);
        nama = findViewById(R.id.tv_nama);

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

        recyclerView = findViewById(R.id.rv_kk);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Circle circle = new Circle();
        circle.setColor(colors[8]);
        progressBar.setIndeterminateDrawable(circle);

        Intent intent = getIntent();
        no_kec = intent.getIntExtra("no_kec",0);
        nama_kec = intent.getStringExtra("nama_kec");
        tot_kec = intent.getStringExtra("tot_kec");

        total_kab.setText(tot_kec);
        nama.setText("KECAMATAN " + nama_kec);

        desa();
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
    private void desa() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String jwt_ = sharedPreferences.getString("jwt", "0");
        API api = koneksi.getClient().create(API.class);

        Call<respon> aksi = null;
        if (no_kec == 1) {
            aksi = api.biodata_1jat(jwt_);
        } else if (no_kec == 2) {
            aksi = api.biodata_2bes(jwt_);
        } else if (no_kec == 3) {
            aksi = api.biodata_3sub(jwt_);
        }else if (no_kec == 4) {
            aksi = api.biodata_4mlan(jwt_);
        } else if (no_kec == 5) {
            aksi = api.biodata_5kend(jwt_);
        }else if (no_kec == 6) {
            aksi = api.biodata_6pan(jwt_);
        } else if (no_kec == 7) {
            aksi = api.biodata_7sit(jwt_);
        }else if (no_kec == 8) {
            aksi = api.biodata_8panji(jwt_);
        } else if (no_kec == 9) {
            aksi = api.biodata_9mang(jwt_);
        }else if (no_kec == 10) {
            aksi = api.biodata_10kap(jwt_);
        } else if (no_kec == 11) {
            aksi = api.biodata_11arj(jwt_);
        }else if (no_kec == 12) {
            aksi = api.biodata_12jang(jwt_);
        } else if (no_kec == 13) {
            aksi = api.biodata_13asem(jwt_);
        }else if (no_kec == 14) {
            aksi = api.biodata_14putih(jwt_);
        } else if (no_kec == 15) {
            aksi = api.biodata_15sumb(jwt_);
        }else if (no_kec == 16) {
            aksi = api.biodata_16glugur(jwt_);
        } else if (no_kec == 17) {
            aksi = api.biodata_17bung(jwt_);
        }

        aksi.enqueue(new Callback<respon>() {
            @Override
            public void onResponse(Call<respon> call, Response<respon> response) {
                Log.d("coderespon", String.valueOf(response.code()));
                results.clear();
                if (response.code() != 200) {
                    Toast.makeText(BiodataDesaActivity.this, "Token tidak valid atau Token expired", Toast.LENGTH_SHORT).show();
                    logout();
                } else {
                    showLoading(false);
                    results = response.body().getResult();
                    biodataDesaAdapter = new BiodataDesaAdapter(BiodataDesaActivity.this, results);
                    recyclerView.getRecycledViewPool().clear();
                    biodataDesaAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(biodataDesaAdapter);
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
        startActivity(new Intent(BiodataDesaActivity.this, LoginActivity.class));
        finish();
    }
}