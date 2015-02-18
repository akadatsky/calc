package com.example.Calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    public static final int REQUEST_CODE_MUL = 1;
    public static final int REQUEST_CODE_DIV = 2;

    private EditText value1;
    private EditText value2;

    private TextView resultView;
    private TextView commentView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        value1 = (EditText) findViewById(R.id.value1);
        value2 = (EditText) findViewById(R.id.value2);

        resultView = (TextView) findViewById(R.id.text);
        commentView = (TextView) findViewById(R.id.comment);

        View mul = findViewById(R.id.buttonMul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, MulActivity.class);
                intent.putExtra("a", Integer.parseInt(value1.getText().toString()));
                intent.putExtra("b", Integer.parseInt(value2.getText().toString()));
                startActivityForResult(intent, REQUEST_CODE_MUL);
            }
        });

        View div = findViewById(R.id.buttonDiv);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, MulActivity.class);
                intent.putExtra("a", Integer.parseInt(value1.getText().toString()));
                intent.putExtra("b", Integer.parseInt(value2.getText().toString()));
                startActivityForResult(intent, REQUEST_CODE_DIV);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MUL) {
            int result = data.getIntExtra("result", 0);
            resultView.setText(getString(R.string.result_mul) + result);

            String comment = data.getStringExtra("comment");
            commentView.setText(comment);
        }

        if (requestCode == REQUEST_CODE_DIV) {
            double result = data.getDoubleExtra("result", 0);
            resultView.setText(getString(R.string.result_div) + result);

            String comment = data.getStringExtra("comment");
            commentView.setText(comment);
        }
    }
}
