package calculator.calulation.lesson_1_5_1423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class InterceptActivity extends AppCompatActivity {


    Button button2;
    EditText editText2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept);
        button2 = findViewById(R.id.button2);
        editText2 = findViewById(R.id.editText2);
        imageView = findViewById(R.id.imageView);

        Intent i = getIntent();
        String action = i.getAction();
        String type = i.getType();

        Bundle extras = i.getExtras();

        if(action.equals(Intent.ACTION_SEND)){
            if(type.startsWith("image/")){
                imageView.setImageURI(extras.getParcelable(Intent.EXTRA_STREAM));
            }else if(type.startsWith("text/")){
                String subject = extras.getString(Intent.EXTRA_SUBJECT);
                String text = extras.getString(Intent.EXTRA_TEXT);
                editText2.setText(String.format("%s",  text));
            }
        }


    }
}