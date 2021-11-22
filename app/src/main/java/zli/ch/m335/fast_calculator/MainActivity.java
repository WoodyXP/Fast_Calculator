package zli.ch.m335.fast_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public final static  String MULTI_INTER_LOW = "multi_low";
    public final static String MULTI_INTER_HIGH = "multi_high";

    public final static String DIV_INTER = "div_inter";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton btn_multi_calc = (ImageButton) findViewById(R.id.btn_mutli);
        final ImageButton btn_div_calc = (ImageButton) findViewById(R.id.btn_div);

        btn_multi_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText multi_inter_low_edt = (EditText) findViewById(R.id.multi_inter_low_edt);
                EditText multi_inter_high_edt = (EditText) findViewById(R.id.multi_inter_high_edt);

                int multi_inter_low = Integer.parseInt(multi_inter_low_edt.getText().toString());
                int multi_inter_high = Integer.parseInt(multi_inter_high_edt.getText().toString());

                Intent intent = new Intent(getApplicationContext(), Calc_Activity.class);
                intent.putExtra(MULTI_INTER_LOW, multi_inter_low);
                intent.putExtra(MULTI_INTER_HIGH, multi_inter_high);
                startActivity(intent);
            }
        });

        btn_div_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText div_inter_edt = (EditText) findViewById(R.id.div_inter_edt);

                int div_inter = Integer.parseInt(div_inter_edt.getText().toString());

                Intent intent = new Intent(getApplicationContext(), Calc_Div_Activity.class);
                intent.putExtra(DIV_INTER, div_inter);
                startActivity(intent);
            }
        });
    }
}
