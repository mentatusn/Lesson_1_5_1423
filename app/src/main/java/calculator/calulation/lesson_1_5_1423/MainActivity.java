package calculator.calulation.lesson_1_5_1423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button button1;
    EditText editText1;

    public static final String KEY_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        button1 = findViewById(R.id.button1);
        editText1 = findViewById(R.id.editText1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                String message = "Мое сообщение: "+editText1.getText();
                i.putExtra(KEY_MESSAGE, message);
                startActivity(i);
            }
        });

        Intent i = getIntent();
        Bundle extras = i.getExtras();



        if(extras!=null){
            String message = extras.getString(MainActivity.KEY_MESSAGE);
            editText1.setText(message);
        }

    }
    void another(){
        //button1
    }
}