package mifta.code.dispendukproject1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import mifta.code.dispendukproject1.R;

public class KtpActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView perekaman, pencetakan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktp);

        perekaman = findViewById(R.id.bt_perekaman);
        pencetakan = findViewById(R.id.bt_pencetakan);

        perekaman.setOnClickListener(this);
        pencetakan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_pencetakan:
                Intent a = new Intent(KtpActivity.this, KtpPencetakanActivity.class);
                startActivity(a);
                break;
            case R.id.bt_perekaman:
                Intent b = new Intent(KtpActivity.this, KtpPerekamanActivity.class);
                startActivity(b);
                break;
        }
    }
}