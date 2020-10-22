package mifta.code.dispendukproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.CircleSprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import static mifta.code.dispendukproject1.Colors.colors;

public class AktaKelahiranActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akta_kelahiran);

        progressBar = findViewById(R.id.progressBarakta);
    }
}