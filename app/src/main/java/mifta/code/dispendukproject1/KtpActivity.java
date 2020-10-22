package mifta.code.dispendukproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Circle;

import static mifta.code.dispendukproject1.Colors.colors;

public class KtpActivity extends AppCompatActivity {

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