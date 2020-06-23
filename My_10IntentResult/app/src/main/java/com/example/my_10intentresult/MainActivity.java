package com.example.my_10intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final int REQUEST_CODE = 1004;

    Button BtnMain;
    TextView tvMain;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);
        BtnMain = findViewById(R.id.btnMain);
        BtnMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 데이터 보내기
                PersonDto person1 = new PersonDto("css",3333); //dto에서 아이디 비밀번호

                Intent intent = new Intent(MainActivity.this,Sub01.class);
                intent.putExtra("id","KIM");
                intent.putExtra("pw",1234);
                intent.putExtra("person1", person1);


                startActivityForResult(intent,REQUEST_CODE );

            }
        });

        }

            // 데이터 받기

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
            if(requestCode == REQUEST_CODE){ //1004이면
                if(data != null){
                   String key = data.getStringExtra("key");
                   tvMain.setText(key);
                }
           }



        super.onActivityResult(requestCode, resultCode, data);



    }
}
