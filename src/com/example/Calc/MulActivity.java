package com.example.Calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MulActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        final TextView viewA = (TextView) findViewById(R.id.a);
        final TextView viewB = (TextView) findViewById(R.id.b);

        final EditText comment = (EditText) findViewById(R.id.comment);

        final int a = getIntent().getIntExtra("a", 0);
        final int b = getIntent().getIntExtra("b", 0);

        viewA.setText(String.valueOf(a));
        viewB.setText(String.valueOf(b));



        View result = findViewById(R.id.result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                int result  = a*b;
                intent.putExtra("result", result);
                intent.putExtra("comment", comment.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
