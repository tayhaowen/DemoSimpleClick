package sg.edu.rp.c346.id20042303.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay;
    TextView tv;
    EditText etData;
    ToggleButton tdEnabler;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById( R.id.btnDisplay);
        tv = findViewById(R.id.tv);
        etData = findViewById(R.id.etData);
        tdEnabler = findViewById(R.id.toggleBtn);
        rgGender = findViewById(R.id.rgGender);

        String abc = tv.getText().toString();
        System.out.println(abc);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc = etData.getText().toString();
                if(abc.isEmpty()){
                    tv.setText("Nothing has been entered");
                    Toast.makeText( MainActivity.this,
                            "Please input something",
                            Toast.LENGTH_SHORT).show();
                }else{
                    int checkedRB = rgGender.getCheckedRadioButtonId();
                    if(checkedRB == R.id.rbFemale){
                        tv.setText("She said " + abc);
                    }else{
                        tv.setText("He said " + abc);
                    }

                }


            }
        });

        tdEnabler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tdEnabler.isChecked() == true){
                    etData.setEnabled(true);
                    etData.setBackgroundColor(Color.TRANSPARENT);
                }else{
                    etData.setEnabled(false);
                    etData.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
}