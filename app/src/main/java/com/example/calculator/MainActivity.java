package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etBill = findViewById(R.id.etBill);
        EditText etPercent = findViewById(R.id.etPercent);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvTipAmount = findViewById(R.id.tvTipAmount);
        TextView tvTotal = findViewById(R.id.tvTotal);

        btnCalculate.setOnClickListener(v -> {
            String billText = etBill.getText().toString().replace(',', '.');
            String percentText = etPercent.getText().toString().replace(',', '.');

            if (billText.isEmpty()) {
                etBill.setError("Введите сумму");
                return;
            }
            if (percentText.isEmpty()) {
                etPercent.setError("Введите процент");
                return;
            }

            double bill;
            double percent;
            try {
                bill = Double.parseDouble(billText);
                percent = Double.parseDouble(percentText);
            } catch (NumberFormatException e) {
                return;
            }

            double tipAmount = bill * percent / 100.0;
            double total = bill + tipAmount;

            tvTipAmount.setText(String.format("Чаевые: ", tipAmount));
            tvTotal.setText(String.format("Итого: ", total));
        });
    }
}