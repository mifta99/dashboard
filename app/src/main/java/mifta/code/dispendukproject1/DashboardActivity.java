package mifta.code.dispendukproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtUser;
    ImageView foto, kk, ktp, akta;
    private Menu action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        kk = (ImageView) findViewById(R.id.im_kk);
        akta = (ImageView) findViewById(R.id.im_akta);
        ktp = (ImageView) findViewById(R.id.im_ktp);
        foto = (ImageView) findViewById(R.id.im_foto);
        txtUser = (TextView) findViewById(R.id.tv_user);

        kk.setOnClickListener(this);
        akta.setOnClickListener(this);
        ktp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
            Intent d = new Intent(DashboardActivity.this, AkteActivity.class);
            startActivity(d);
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