
package zli.ch.m335.fast_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.EditText;
import android.widget.TextView;

public class Calc_Div_Activity extends AppCompatActivity {
    CalcService mService;
    boolean mBound = false;


    private TextView points_string;
    private TextView minus_points_string;
    private TextView highscore_string;
    private TextView calculation_string;
    private EditText userinput_string;


    private int div_value = 0;


    private ServiceConnection connection = new ServiceConnection() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CalcService.CalcBinder binder = (CalcService.CalcBinder) service;
            mService = binder.getService();
            mBound = true;
            if (mBound) {

                int points = Integer.parseInt(points_string.getText().toString());
                int minus_points = Integer.parseInt(minus_points_string.getText().toString());
                int high_score = Integer.parseInt(highscore_string.getText().toString());
                int userinput = Integer.parseInt(userinput_string.getText().toString());
                int userinput_lenght = userinput_string.getText().length();


                calculation_string.setText(div_per + " % of " + div_num + " = ");
                int[] calc_results = mService.getMultiresult(calc_numbers, userinput, userinput_lenght,
                        points, high_score, minus_points);

                userinput_string.setText(String.valueOf(calc_results[0]));
                points_string.setText(String.valueOf(calc_results[1]));
                minus_points_string.setText(String.valueOf(calc_results[2]));
                highscore_string.setText(String.valueOf(calc_results[3]));


            }
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) { mBound = false; }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_div);

        points_string = (TextView) findViewById(R.id.correct_txt);
        minus_points_string = (TextView) findViewById(R.id.wrong_txt);
        highscore_string = (TextView) findViewById(R.id.highscore_txt);
        calculation_string = (TextView) findViewById(R.id.calculation_text);
        userinput_string = (EditText) findViewById(R.id.result_edt);


        Intent intent = getIntent();
        div_value = intent.getIntExtra(MainActivity.DIV_INTER, 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, CalcService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
}