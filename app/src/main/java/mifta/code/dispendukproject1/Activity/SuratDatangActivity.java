package mifta.code.dispendukproject1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Circle;

import mifta.code.dispendukproject1.R;

import static mifta.code.dispendukproject1.Utils.Colors.colors;

public class SuratDatangActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_datang);

        progressBar = findViewById(R.id.progressBar);

        Circle circle = new Circle();
        circle.setColor(colors[8]);
        progressBar.setIndeterminateDrawable(circle);
    }
}