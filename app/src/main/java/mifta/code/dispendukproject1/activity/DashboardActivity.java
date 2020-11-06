package mifta.code.dispendukproject1.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.auth0.android.jwt.JWT;
import com.bumptech.glide.Glide;

import java.util.List;

import mifta.code.dispendukproject1.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtUser, txt_ktp, txt_kk, txt_akta, txt_pindah, txt_datang, txt_biodata;
    ImageView foto, kk, ktp, akta, datang, pindah, biodata, kelahiran, kematian, perkawinan, perceraian;
    TableRow tbl1, tbl2, tbl3, tbl4, tbl5, tbl6, tbl7, tbl8;
    private Menu action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle(" ");

        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String jwt_ = sharedPreferences.getString("jwt", "0");
        JWT jwt = new JWT(jwt_);
        List<String> aud = jwt.getAudience();

        kk = findViewById(R.id.im_kk);
        akta = findViewById(R.id.im_akta);
        ktp = findViewById(R.id.im_ktp);
        foto = findViewById(R.id.im_foto);
        datang = findViewById(R.id.im_datang);
        pindah = findViewById(R.id.im_pindah);
        biodata = findViewById(R.id.im_biodata);
        txtUser = findViewById(R.id.tv_user);
        txt_ktp = findViewById(R.id.txt_ktp);
        txt_kk = findViewById(R.id.txt_kk);
        txt_akta = findViewById(R.id.txt_akta);
        txt_pindah = findViewById(R.id.txt_pindah);
        txt_datang = findViewById(R.id.txt_datang);
        txt_biodata = findViewById(R.id.txt_biodata);
        kelahiran = findViewById(R.id.im_akta_kelahiran);
        kematian = findViewById(R.id.im_akta_kematian);
        perkawinan = findViewById(R.id.im_akta_perkawinan);
        perceraian = findViewById(R.id.im_akta_perceraian);
        tbl1 = findViewById(R.id.tbl1);
        tbl2 = findViewById(R.id.tbl2);
        tbl3 = findViewById(R.id.tbl3);
        tbl4 = findViewById(R.id.tbl4);
        tbl5 = findViewById(R.id.tbl5);
        tbl6 = findViewById(R.id.tbl6);
        tbl7 = findViewById(R.id.tbl7);
        tbl8 = findViewById(R.id.tbl8);


        final String nama_ = aud.get(2);
        final String status_ = aud.get(1);
        final String foto_ = aud.get(4);

        if (status_.equals("dafduk")) {
            akta.setVisibility(View.INVISIBLE);
            txt_akta.setVisibility(View.INVISIBLE);
        } else if (status_.equals("capil")) {
            tbl1.setVisibility(View.GONE);
            tbl2.setVisibility(View.GONE);
            tbl3.setVisibility(View.GONE);
            tbl4.setVisibility(View.GONE);

            tbl5.setVisibility(View.VISIBLE);
            tbl6.setVisibility(View.VISIBLE);
            tbl7.setVisibility(View.VISIBLE);
            tbl8.setVisibility(View.VISIBLE);
        }

        txtUser.setText("HALO " + nama_);
        Glide.with(DashboardActivity.this)
                .load(foto_)
                .placeholder(R.drawable.ic_loading)
                .into(foto);
        kk.setOnClickListener(this);
        akta.setOnClickListener(this);
        ktp.setOnClickListener(this);
        datang.setOnClickListener(this);
        pindah.setOnClickListener(this);
        biodata.setOnClickListener(this);
        kelahiran.setOnClickListener(this);
        kematian.setOnClickListener(this);
        perkawinan.setOnClickListener(this);
        perceraian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_kk:
                Intent a = new Intent(DashboardActivity.this, KkActivity.class);
                startActivity(a);
                break;
            case R.id.im_ktp:
                Intent b = new Intent(DashboardActivity.this, KtpActivity.class);
                startActivity(b);
                break;
            case R.id.im_akta:
                Intent c = new Intent(DashboardActivity.this, AkteActivity.class);
                startActivity(c);
                break;
            case R.id.im_datang:
                Intent e = new Intent(DashboardActivity.this, SuratDatangActivity.class);
                startActivity(e);
                break;
            case R.id.im_pindah:
                Intent f = new Intent(DashboardActivity.this, SuratPindahActivity.class);
                startActivity(f);
                break;
            case R.id.im_biodata:
                Intent g = new Intent(DashboardActivity.this, BiodataActivity.class);
                startActivity(g);
                break;
            case R.id.im_akta_kelahiran:
                Intent h = new Intent(DashboardActivity.this, AktaKelahiranActivity.class);
                startActivity(h);
                break;
            case R.id.im_akta_kematian:
                Intent i = new Intent(DashboardActivity.this, AktaKematianActivity.class);
                startActivity(i);
                break;
            case R.id.im_akta_perkawinan:
                Intent j = new Intent(DashboardActivity.this, AktaPerkawinanActivity.class);
                startActivity(j);
                break;
            case R.id.im_akta_perceraian:
                Intent k = new Intent(DashboardActivity.this, AktaPerceraianActivity.class);
                startActivity(k);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        action = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_profil) {
            Intent d = new Intent(DashboardActivity.this, ProfilActivity.class);
            startActivity(d);
            finish();
        }
        if (id == R.id.menu_logout) {
            logout();
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        SharedPreferences.Editor akses = sharedPreferences.edit();
        akses.clear();
        akses.commit();
        startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
        finish();
    }
}