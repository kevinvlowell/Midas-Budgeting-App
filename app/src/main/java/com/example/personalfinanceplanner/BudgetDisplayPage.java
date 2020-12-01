package com.example.personalfinanceplanner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BudgetDisplayPage extends AppCompatActivity implements View.OnClickListener {


    //VARIABLES
    //debug tag for log
    private static final String TAG_DEBUG = BudgetDisplayPage.class.getName();

    //dropdown with currencies
    private Spinner addCurrency;        //displays async retrieved names from online currency base

    private Spinner currCurrency;
    /* TODO implement this spinner/equivalent by retrieving users currency names from database*/

    //containers to interact with FetchCurrency and hold currency data
    public static ArrayList<String> names = new ArrayList<String>();        //array of currency names to select from
    public static ArrayList<ArrayList<String>> namesRates = new ArrayList<ArrayList<String>>();     //array of name-currency arrays
    public static ArrayAdapter<String> aa;      //array adapter for spinner addCurrency

    //INDEX constants that correspond to currency name/rate fields of namesRates array, for easier indexing
    final int CURRENCYNAME = 0;     //fx. firstCurrencyName = namesRates[0][CURRENCYNAME]
    final int CURRENCYRATE = 1;     //fx. firstCurrencyRATE = namesRates[0][CURRENCYRATE]


    //ACTIONS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_display);

        //msg to log
        Log.d(TAG_DEBUG, "Loading budget page!");

        //<--------------CURRENCY FEATURE STARS HERE-------------->
        //connecting the spinner
        addCurrency = (Spinner) findViewById(R.id.currencyMenu);

        //Start async activity to fetch data
        FetchCurrencyData fetch = new FetchCurrencyData();
        fetch.execute();

        //Setting the ArrayAdapter data on the add-currency spinner
        aa = new ArrayAdapter<String>(BudgetDisplayPage.this, android.R.layout.simple_spinner_item,names);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addCurrency.setAdapter(aa);

        //setting on click for currency to be added to database based on select
        addCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /* TODO Implement  FUNCTION THAT ADDS SELECTED CURRENCY TO USER IN DATABASE */

                if(position != 0){
                    Toast.makeText(BudgetDisplayPage.this, "Currency added to your profile!", Toast.LENGTH_SHORT).show();
                }
                addCurrency.setSelection(0);
                Log.d(TAG_DEBUG, "Currency selected");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //<--------------CURRENCY FEATURE ENDS HERE-------------->

        /*TODO ADD REST OF FUNCTIONALITY TO THE PAGE*/
    }


    //if we want to click something
    @Override
    public void onClick(View v) {

    }
}