package com.example.my_10intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sub01 extends AppCompatActivity {
    private static final String TAG = "Sub01";

    Button btnSub1;
    TextView tvSub1;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub01);

        btnSub1=findViewById(R.id.btnSub1);
        tvSub1=findViewById(R.id.tvSub1);

        //데이터 받는곳
        intent = getIntent();




       String id =intent.getStringExtra("id");
       int pw =intent.getIntExtra("pw",0);
       PersonDto person1 =
               (PersonDto) intent.getSerializableExtra("person1");

        Log.d(TAG, "onCreate: id : " + id);
        Log.d(TAG, "onCreate: pw : " + pw);

        tvSub1.setText("받은값은 : " + id + ", "+ pw);
        tvSub1.append("\nperson1 :" + person1.getId() +
                ", " + person1.getPw());

        // 메인에 데이터 보내기

        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent();
                reIntent.putExtra("key",
                        tvSub1.getText().toString() + "ㅋㅋㅋ");
                setResult(RESULT_OK, reIntent);
                finish();

            }
        });
    }
}
