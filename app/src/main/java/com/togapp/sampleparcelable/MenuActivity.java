package com.togapp.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textView;

    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("neme","mike");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        Intent intent = getIntent();
        processIntnet(intent);
    }

    private void processIntnet(Intent intent) {
        if (intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);
            if(intent != null){
                textView.setText("전달받은데이터\nNumber : " + data.number + "\nMessage : " + data.message);
            }

        }
    }

}