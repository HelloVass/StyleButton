package cn.lydia.pero.stylebuttondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by hello on 2017/11/30.
 */

public class SampleActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);

    findViewById(R.id.uiib_test).setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {

      }
    });

    findViewById(R.id.uitb_test).setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {

      }
    });

    findViewById(R.id.uirl_test).setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {

      }
    });
  }
}
