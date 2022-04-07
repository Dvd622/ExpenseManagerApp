package com.example.expensemanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Integer totalAmount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListView expenseListView = findViewById(R.id.expenseListView);
        ArrayList<String> expenseList = new ArrayList<String>();
        expenseList.add("Home Rent");
        expenseList.add("Eating Out");
        expenseList.add("Travel");
        expenseList.add("Shopping");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, expenseList);
        expenseListView.setAdapter(adapter);

        expenseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                intent.putExtra("expenseName", expenseList.get(i));
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==1) {
            String value = data.getStringExtra("value");
            Integer expenseAmount = Integer.parseInt(value);
            totalAmount = totalAmount + expenseAmount;
            TextView totalExpense = findViewById(R.id.expensesTextView);
            String totalExpenseText = "Total spend: " + totalAmount.toString();
            totalExpense.setText(totalExpenseText);
        }
    }
}