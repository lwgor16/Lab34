package my.edu.taruc.lab34;

import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Date;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public int age = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day)
    {
        TextView textViewAge = findViewById(R.id.textViewAge);
        Button buttonDOB = findViewById(R.id.buttonDOB);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DATE);

        if(currentYear > year)
        {
            age = currentYear - year;
            if(currentMonth < month)
            {
                age--;
            }
            else if (currentMonth == month)
            {
                if(currentDay < day)
                {
                    age--;
                }
            }
        }

        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);

        buttonDOB.setText(dateMessage);

        textViewAge.setText("Age: " + age);
    }

    public void calculateEligibleAmount(View view)
    {
        EditText editTextBalance = findViewById(R.id.editTextAccaountBalance);
        TextView textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        double currentBalance = Double.parseDouble(editTextBalance.getText().toString());
        double eligibleAmount = 0;
        if(age > 50)
        {
            if(currentBalance > 228000.00)
            {
                eligibleAmount = (currentBalance - 228000.00) * 30 / 100;
            }
        }
        else if (age > 45)
        {
            if(currentBalance > 165000.00)
            {
                eligibleAmount = (currentBalance - 165000.00) * 30 / 100;
            }
        }
        else if (age > 40)
        {
            if(currentBalance > 116000.00)
            {
                eligibleAmount = (currentBalance - 116000.00) * 30 / 100;
            }
        }
        else if (age > 35)
        {
            if(currentBalance > 78000.00)
            {
                eligibleAmount = (currentBalance - 78000.00) * 30 / 100;
            }
        }
        else if (age > 30)
        {
            if(currentBalance > 50000.00)
            {
                eligibleAmount = (currentBalance - 50000.00) * 30 / 100;
            }
        }
        else if (age > 25)
        {
            if(currentBalance > 29000.00)
            {
                eligibleAmount = (currentBalance - 29000.00) * 30 / 100;
            }
        }
        else if (age > 20)
        {
            if(currentBalance > 14000.00)
            {
                eligibleAmount = (currentBalance - 14000.00) * 30 / 100;
            }
        }
        else if (age > 15)
        {
            if(currentBalance > 5000.00)
            {
                eligibleAmount = (currentBalance - 5000.00) * 30 / 100;
            }
        }

        textViewEligibleAmount.setText("Eligible Amount: " + eligibleAmount);
    }

    public void Reset (View view)
    {
        EditText editTextBalance = findViewById(R.id.editTextAccaountBalance);
        TextView textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
        TextView textViewAge = findViewById(R.id.textViewAge);
        Button buttonDOB = findViewById(R.id.buttonDOB);

        editTextBalance.setText("");
        textViewEligibleAmount.setText(R.string.eligible_amount);
        textViewAge.setText(R.string.age);
        buttonDOB.setText(R.string.select_date_of_birth);
    }
}
