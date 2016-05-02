package com.example.philipbutler.oopfinalandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import java.text.NumberFormat;

import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat integerFormat =
            NumberFormat.getIntegerInstance();

    Random randGen = new Random();
    int x = randGen.nextInt(11);
    int y = randGen.nextInt(11);

    int addAns;
    int subAns;
    int multAns;

    int addTry;
    int subTry;
    int multTry;

    int correctCount = 0;

    private TextView addTextView;
    private TextView subTextView;
    private TextView multTextView;
    private TextView resultsTextView;

    private EditText addEditText;
    private EditText subEditText;
    private EditText multEditText;

    private Button submitButton;
    private Button resetButton;

    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addTextView = (TextView) findViewById(R.id.addTextView);
        subTextView = (TextView) findViewById(R.id.subTextView);
        multTextView = (TextView) findViewById(R.id.multTextView);

        textView2 = (TextView) findViewById(R.id.textView2);

        addEditText = (EditText) findViewById(R.id.addEditText);
        subEditText = (EditText) findViewById(R.id.subEditText);
        multEditText = (EditText) findViewById(R.id.multEditText);

        submitButton = (Button) findViewById(R.id.submitButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        addEditText.addTextChangedListener(addEditTextWatcher);
        subEditText.addTextChangedListener(subEditTextWatcher);
        multEditText.addTextChangedListener(multEditTextWatcher);

        x = randGen.nextInt(11);
        y = randGen.nextInt(11);

        addAns = x + y;
        subAns = x - y;
        multAns = x * y;

        addTextView.setText(x + " + " + y + " = ");
        subTextView.setText(x + " - " + y + " = ");
        multTextView.setText(x + " * " + y + " = ");
    }

    public void updateFields(View view)
    {
        x = randGen.nextInt(11);
        y = randGen.nextInt(11);

        addAns = x + y;
        subAns = x - y;
        multAns = x * y;

        addTextView.setText(x + " + " + y + " = ");
        subTextView.setText(x + " - " + y + " = ");
        multTextView.setText(x + " * " + y + " = ");
    }

    public void submitFields(View view)
    {
        correctCount = 0;

        if(addAns == addTry){
            correctCount++;
        }
        if(subAns == subTry){
            correctCount++;
        }
        if(multAns == multTry){
            correctCount++;
        }
        textView2.setText(correctCount + " / " + "3 Correct");

    }

    /*
    private View.OnClickListener submitOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView2.setText("working");
        }
    };
    */

    private TextWatcher addEditTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try
            {
                addTry = Integer.parseInt(s.toString());
            }
            catch (NumberFormatException e)
            {
                addTry = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher subEditTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try
            {
                subTry = Integer.parseInt(s.toString());
            }
            catch (NumberFormatException e)
            {
                subTry = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher multEditTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try
            {
                multTry = Integer.parseInt(s.toString());
            }
            catch (NumberFormatException e)
            {
                multTry = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
