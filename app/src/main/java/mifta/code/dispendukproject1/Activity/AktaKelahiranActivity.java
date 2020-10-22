package mifta.code.dispendukproject1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.Circle;

import mifta.code.dispendukproject1.Utils.API;
import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.Utils.koneksi;
import mifta.code.dispendukproject1.Model.respon;
import retrofit2.Call;
import retrofit2.Callback;

import static mifta.code.dispendukproject1.Utils.Colors.colors;

public class AktaKelahiranActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akta_kelahiran);

        progressBar = findViewById(R.id.progressBarakta);

        Circle doubleBounce = new Circle();
//        doubleBounce.setBounds(0, 0, 100, 100);
        doubleBounce.setColor(colors[7]);
        progressBar.setIndeterminateDrawable(doubleBounce);
    }

    public static class KtpActivity extends AppCompatActivity {

        ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ktp);

            progressBar = findViewById(R.id.progressBar);

            Circle circle = new Circle();
            circle.setColor(colors[8]);
            progressBar.setIndeterminateDrawable(circle);


        }
    }

    public static class KtpPencetakanActivity extends AppCompatActivity {

        ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ktp_pencetakan);

            progressBar = findViewById(R.id.progressBar);

            Circle doubleBounce = new Circle();
    //        doubleBounce.setBounds(0, 0, 100, 100);
            doubleBounce.setColor(colors[8]);
            progressBar.setIndeterminateDrawable(doubleBounce);
        }
    }

    public static class KtpPerekamanActivity extends AppCompatActivity {

        ProgressBar progressBar;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ktp_perekaman);

            progressBar = findViewById(R.id.progressBar);

            Circle doubleBounce = new Circle();
    //        doubleBounce.setBounds(0, 0, 100, 100);
            doubleBounce.setColor(colors[8]);
            progressBar.setIndeterminateDrawable(doubleBounce);
        }
    }

    public static class LoginActivity extends AppCompatActivity implements View.OnClickListener {
        EditText username, password;
        Button login;
        private boolean login1 = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            username = findViewById(R.id.et_username);
            password = findViewById(R.id.et_password);
            login = findViewById(R.id.bt_login);

            login.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_login:
                    login();
                    break;
            }
        }

        @Override
        protected void onResume() {
            super.onResume();

            SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
            login1 = sharedPreferences.getBoolean("login2", false);
            if (login1) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        }

        private void login() {
            String usename_ = username.getText().toString();
            String password_ = password.getText().toString();

            API api = koneksi.getClient().create(API.class);

            Call<respon> aksi = api.login(usename_, password_);
            aksi.enqueue(new Callback<respon>() {
                @Override
                public void onResponse(Call<respon> call, retrofit2.Response<respon> response) {
                    if (response.code()==200) {
                        SharedPreferences sharedPreferences = getSharedPreferences("myproject", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("login2", true);
                        editor.putString("jwt", response.body().getJwt());
                        editor.commit();
                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Email atau Password anda salah", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<respon> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Tidak ada koneksi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}