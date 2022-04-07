package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        Intent intent = getIntent();
        String expenseName = intent.getStringExtra("expenseName");
        ImageView imageView = findViewById(R.id.imageView);
        TextView expenseTextView = findViewById(R.id.expenseTextView);
        String expenseText = "Enter your " + expenseName + ":";
        expenseTextView.setText(expenseText);
        switch (expenseName) {
            case "Home Rent":
                imageView.setImageDrawable(getDrawable(R.drawable.homeicon));
                break;
            case "Eating Out":
                imageView.setImageDrawable(getDrawable(R.drawable.food_drink_icon));
                break;
            case "Travel":
                imageView.setImageDrawable(getDrawable(R.drawable.travel_icon));
                break;
            case "Shopping":
                imageView.setImageDrawable(getDrawable(R.drawable.shopping_icon));
                break;
        }
        Button expenseAddButton = findViewById(R.id.expenseAddButton);
        expenseAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText expenseValue = findViewById(R.id.expenseEditText);
                String value = expenseValue.getText().toString();
                Intent intent2 = new Intent();
                intent2.putExtra("value", value);
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }
}