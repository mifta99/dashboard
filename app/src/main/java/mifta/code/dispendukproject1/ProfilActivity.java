package mifta.code.dispendukproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfilActivity extends AppCompatActivity {
    ImageView foto;
    TextView nama, nip, jabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        foto = (ImageView) findViewById(R.id.im_fotoprofil);
        nama = (TextView) findViewById(R.id.tv_nama);
        nip = (TextView) findViewById(R.id.tv_nip);
        jabatan = (TextView) findViewById(R.id.tv_jabatan);

        final SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
        final String nama_ = sharedPreferences.getString("nama", "0");
        final String foto_ = sharedPreferences.getString("foto", "0");
        final String nip_ = sharedPreferences.getString("nip", "0");
        final String jabatan_ = sharedPreferences.getString("jabatan", "0");

        Glide.with(ProfilActivity.this)
                .load(foto_)
                .into(foto);

        nama.setText(nama_);
        nip.setText(nip_);
        jabatan.setText(jabatan_);
    }
}