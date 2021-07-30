package calculator.calulation.lesson_1_5_1423;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    Button button2;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        button2 = findViewById(R.id.button2);
        editText2 = findViewById(R.id.editText2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,MainActivity.class);
                String message = "Мое сообщение: "+editText2.getText();
                i.putExtra(MainActivity.KEY_MESSAGE, message);
                startActivity(i);
            }
        });

        Intent i = getIntent();
        Bundle extras = i.getExtras();



        if(extras!=null){
            String message = extras.getString(MainActivity.KEY_MESSAGE);
            editText2.setText(message);
        }

    }
}