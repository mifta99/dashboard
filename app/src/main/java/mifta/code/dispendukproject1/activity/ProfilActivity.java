package mifta.code.dispendukproject1.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.auth0.android.jwt.JWT;
import com.bumptech.glide.Glide;

import java.util.List;

import mifta.code.dispendukproject1.R;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView foto, back;
    TextView nama, nip, jabatan;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        foto = findViewById(R.id.im_fotoprofil);
        nama = findViewById(R.id.tv_nama);
        nip = findViewById(R.id.tv_nip);
        jabatan = findViewById(R.id.tv_jabatan);
        logout = findViewById(R.id.bt_logout);
        back = findViewById(R.id.im_back);

        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String jwt_ = sharedPreferences.getString("jwt", "0");
        JWT jwt = new JWT(jwt_);
        List<String> aud = jwt.getAudience();
        final String nama_ = aud.get(2);
        final String foto_ = aud.get(4);
        final String nip_ = aud.get(3);
        final String jabatan_ = aud.get(5);

        Glide.with(ProfilActivity.this)
                .load(foto_)
                .placeholder(R.drawable.ic_loading)
                .into(foto);

        nama.setText(nama_);
        nip.setText(nip_);
        jabatan.setText(jabatan_);

        logout.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_logout:
                logout();
                break;
            case R.id.im_back:
                Intent a = new Intent(ProfilActivity.this, DashboardActivity.class);
                startActivity(a);
                finish();
                break;
        }
    }

    private void logout() {
        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        SharedPreferences.Editor akses = sharedPreferences.edit();
        akses.clear();
        akses.commit();
        startActivity(new Intent(ProfilActivity.this, LoginActivity.class));
        finish();
    }
}