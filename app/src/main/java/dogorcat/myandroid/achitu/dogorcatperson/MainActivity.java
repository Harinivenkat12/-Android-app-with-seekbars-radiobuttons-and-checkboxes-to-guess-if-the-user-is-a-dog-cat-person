package dogorcat.myandroid.achitu.dogorcatperson;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.myandroid.dogorcat.ResultActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup caninesRadioGroup;
    private RadioButton caninesRadioButton;
    private SeekBar felineSeekBar;
    private TextView seekBarTextView;
    private CheckBox cutenessDogChk, cutenessCatChk;
    private RadioGroup drollRadioGroup;
    private RadioButton drollRadioButton;
    private TextView showResult;

    int dogCounter = 0;
    int catCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
        processCuteness(cutenessDogChk, cutenessCatChk);
        processDrooling(drollRadioGroup);
        processCanines(caninesRadioGroup);
        processSeekBar(felineSeekBar);
    }


    public void setUp() {

        caninesRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCaninesId);
        felineSeekBar=(SeekBar)findViewById(R.id.felineSeekBarId);
        seekBarTextView = (TextView) findViewById(R.id.seekBarTextViewId);
        cutenessCatChk = (CheckBox) findViewById(R.id.cuteCatId);
        cutenessDogChk = (CheckBox) findViewById(R.id.cuteDogId);
        drollRadioGroup = (RadioGroup) findViewById(R.id.radioGrpDrollId);
        showResult = (TextView) findViewById(R.id.resultButtonId);

        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("catCounter", catCounter);
                intent.putExtra("dogCounter", dogCounter);
                startActivity(intent);

            }
        });


    }

    public void processCuteness(CheckBox dog , CheckBox cat) {

        if (dog.isChecked() && !cat.isChecked()) {
            dogCounter += 1;
        } else if (!dog.isChecked() && cat.isChecked()) {
            catCounter += 1;
        } else {

        }

    }

    public void processDrooling(final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedOption= radioGroup.getCheckedRadioButtonId();
                drollRadioButton=(RadioButton)findViewById(selectedOption);

                if(drollRadioButton.getText().equals("Yes")){

                    catCounter+=1;
                }else{
                    dogCounter+=1;
                }
            }
        });

    }

    public void processCanines(final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedOptionCanine= radioGroup.getCheckedRadioButtonId();
                caninesRadioButton=(RadioButton) findViewById(selectedOptionCanine);
                if(caninesRadioButton.getText().equals("Yes")){
                    catCounter+=1;
                }else{
                    dogCounter+=1;
                }
            }
        });
    }

    public void processSeekBar(SeekBar seekBar){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTextView.setText("Comfortableness: "+progress+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

