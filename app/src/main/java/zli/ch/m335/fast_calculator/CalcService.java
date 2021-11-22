package zli.ch.m335.fast_calculator;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


public class CalcService extends Service {
    private final IBinder binder = new CalcBinder();


    public CalcService() {
    }

    public int[] getMultiTaskNumbers(int multi_low_value, int multi_high_value) {
        int[] return_list = new int[2];
        int min = multi_low_value;
        int max = multi_high_value;

        int multi_num1 = (int)Math.floor(Math.random()*(max-min+1)+min);
        int multi_num2 = (int)Math.floor(Math.random()*(max-min+1)+min);

        return_list[0] = multi_num1;
        return_list[1] = multi_num2;

        return return_list;
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    public int[] getMultiresult(int[] calc_numbers, int userinput, int userinput_lenght, int points, int high_score, int minus_points) {
        int[] return_list = new int[4];
        return_list[0] = (calc_numbers[0] * calc_numbers[1]);
        int multi_result_lenght = String.valueOf(return_list[0]).length();


        if (userinput_lenght > multi_result_lenght) {
            return_list[1] = (points);
            return_list[2] = (minus_points + 1);
            return_list[3] = (high_score - high_score);
        } else if (return_list[0] == userinput) {
            return_list[1] = (points + 1);
            return_list[2] = (minus_points);
            return_list[3] = (high_score + 1);
        }

        return return_list;
    }

    public int[] getDivTaskNumbers(int multi_low_value) {
        int[] div_list = new int[2]:

        int random_procent = 0;
        random_procent
    }

    public class CalcBinder extends Binder {
        CalcService getService() { return CalcService.this; }
    }
}