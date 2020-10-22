package mifta.code.dispendukproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.github.ybq.android.spinkit.style.Circle;

import static mifta.code.dispendukproject1.Colors.colors;

public class AkteActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akte);

        progressBar =  findViewById(R.id.progressBar);
        Circle doubleBounce = new Circle();
//        doubleBounce.setBounds(0, 0, 100, 100);
        doubleBounce.setColor(colors[8]);
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }
}