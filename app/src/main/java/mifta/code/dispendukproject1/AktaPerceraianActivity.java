package mifta.code.dispendukproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Circle;

import static mifta.code.dispendukproject1.Colors.colors;

public class AktaPerceraianActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akta_perceraian);

        Circle doubleBounce = new Circle();
//        doubleBounce.setBounds(0, 0, 100, 100);
        doubleBounce.setColor(colors[8]);
        progressBar.setIndeterminateDrawable(doubleBounce);
    }
}