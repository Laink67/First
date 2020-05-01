package ru.laink.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> expressions = new ArrayList<>();
    private EditText etFirstNumber;
    private EditText etSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);

        Button btPlus = findViewById(R.id.btPlus);
        Button btMinus = findViewById(R.id.btMinus);
        Button btMultiply = findViewById(R.id.btMultiply);
        Button btDivision = findViewById(R.id.btDivision);

        ListView listView = findViewById(R.id.listView);

        // создаем адаптер
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, expressions);

        listView.setAdapter(adapter);

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressions.add(getExpression(getFirst() + getSecond(), getFirst(), getSecond(), "+"));
                adapter.notifyDataSetChanged();
            }
        });

        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressions.add(getExpression(getFirst() - getSecond(), getFirst(), getSecond(), "-"));
                adapter.notifyDataSetChanged();
            }
        });

        btMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressions.add(getExpression(getFirst() * getSecond(), getFirst(), getSecond(), "*"));
                adapter.notifyDataSetChanged();
            }
        });

        btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressions.add(getExpression(getFirst() / getSecond(), getFirst(), getSecond(), "/"));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private Integer getFirst() {
        return Integer.valueOf(etFirstNumber.getText().toString());
    }

    private Integer getSecond() {
        return Integer.valueOf(etSecondNumber.getText().toString());
    }

    private String getExpression(int result, int first, int second, String sign) {
        return result + "=" +
                first + sign + second;
    }
}
