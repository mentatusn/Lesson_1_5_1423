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
    public static final int REQUEST_CODE = 1;

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
                String strMssage = "Мое сообщение: "+editText1.getText();
                Message messageObj = new Message();
                messageObj.setMessage(strMssage);
                i.putExtra(KEY_MESSAGE, messageObj);
                //startActivity(i);
                startActivityForResult(i,REQUEST_CODE);
            }
        });

        Intent i = getIntent();
        Bundle extras = i.getExtras();



        if(extras!=null){
            String message = extras.getString(MainActivity.KEY_MESSAGE);
            editText1.setText(message);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)
        if(requestCode==REQUEST_CODE){
            String message = data.getExtras().getString(MainActivity.KEY_MESSAGE);
            editText1.setText("onActivityResult WORK "+message);
        }

    }

    void another(){
        //button1
    }
}