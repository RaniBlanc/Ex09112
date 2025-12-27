package com.example.ex09112;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String s1 = etNum1.getText().toString();
        String s2 = etNum2.getText().toString();

        if (item.getItemId() == R.id.op_cls) {
            etNum1.setText("");
            etNum2.setText("");
            tvResult.setText("");
            return true;
        }

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
            return true;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        int id = item.getItemId();

        if (id == R.id.op_add) tvResult.setText("Result: " + (n1 + n2));
        else if (id == R.id.op_sub) tvResult.setText("Result: " + (n1 - n2));
        else if (id == R.id.op_mul) tvResult.setText("Result: " + (n1 * n2));
        else if (id == R.id.op_div) {
            if (n2 == 0) tvResult.setText("Cannot divide by zero");
            else tvResult.setText("Result: " + (n1 / n2));
        }
        return true;
    }
}