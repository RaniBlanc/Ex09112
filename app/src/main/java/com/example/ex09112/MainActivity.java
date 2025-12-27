package com.example.ex09112;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        if (item.getItemId() == R.id.clear) {
            et1.setText("");
            et2.setText("");
            tvResult.setText("");
            return true;
        }

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
            return true;
        }

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);

        double result = 0;

        if (item.getItemId() == R.id.add) {
            result = a + b;
        } else if (item.getItemId() == R.id.sub) {
            result = a - b;
        } else if (item.getItemId() == R.id.mul) {
            result = a * b;
        } else if (item.getItemId() == R.id.div) {
            if (b == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return true;
            }
            result = a / b;
        }

        tvResult.setText(String.valueOf(result));
        return true;
    }
}
