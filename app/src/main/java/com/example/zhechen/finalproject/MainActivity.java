package com.example.zhechen.finalproject;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button s;

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23;

    String scho = "";
    String tes = "";
    ArrayList<String> interest = new ArrayList<>();

    ParseObject testObject = new ParseObject("Form");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "m3UxTKWWNJPm6apHiOI2zNl4aflT0S8qE8T1oKHZ", "bHRON85yKVdYCKoFgCV9E2W3NlsrouS9MXZ5xel0");

        setupUI(findViewById(R.id.parent));


        s = (Button)findViewById(R.id.saveButton);

        e1 = (EditText)findViewById(R.id.i1);
        e2 = (EditText)findViewById(R.id.i2);
        e3 = (EditText)findViewById(R.id.i3);
        e4 = (EditText)findViewById(R.id.i4);
        e5 = (EditText)findViewById(R.id.i5);
        e6 = (EditText)findViewById(R.id.i6);
        e7 = (EditText)findViewById(R.id.i7);
        e8 = (EditText)findViewById(R.id.i8);
        e9 = (EditText)findViewById(R.id.i9);
        e10 = (EditText)findViewById(R.id.i10);
        e11 = (EditText)findViewById(R.id.i11);
        e12 = (EditText)findViewById(R.id.i12);
        e13 = (EditText)findViewById(R.id.i13);
        e14 = (EditText)findViewById(R.id.i14);
        e15 = (EditText)findViewById(R.id.i15);
        e16 = (EditText)findViewById(R.id.i16);
        e17 = (EditText)findViewById(R.id.i17);
        e18 = (EditText)findViewById(R.id.i18);
        e19 = (EditText)findViewById(R.id.i19);
        e20 = (EditText)findViewById(R.id.i20);
        e21 = (EditText)findViewById(R.id.i21);
        e22 = (EditText)findViewById(R.id.i22);
        e23 = (EditText)findViewById(R.id.i23);

        s.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){

                String v1 = e1.getText().toString();
                String v2 = e2.getText().toString();
                String v3 = e3.getText().toString();
                String v4 = e4.getText().toString();
                String v5 = e5.getText().toString();
                String v6 = e6.getText().toString();
                String v7 = e7.getText().toString();
                String v8 = e8.getText().toString();
                String v9 = e9.getText().toString();
                String v10 = e10.getText().toString();
                String v11 = e11.getText().toString();
                String v12 = e12.getText().toString();
                String v13 = e13.getText().toString();
                String v14 = e14.getText().toString();
                String v15 = e15.getText().toString();

                String v16 = "";
                String v17 = "";
                String v18 = "";
                String v19 = "";
                if(scho == "Yes") {
                    v16 = e16.getText().toString();
                    v17 = e17.getText().toString();
                    v18 = e18.getText().toString();
                    v19 = e19.getText().toString();
                }

                String v20 = "";
                String v21 = "";
                String v22 = "";
                if(tes == "Yes"){
                    v20 = e20.getText().toString();
                    v21 = e21.getText().toString();
                    v22 = e22.getText().toString();
                }

                String i = "";
                for(String in: interest){
                    i = i + in + ",";
                }

                String v23 = e23.getText().toString();


                testObject.put("Familyname", v1);
                testObject.put("Firstname", v2);
                testObject.put("email", v3);
                testObject.put("phone", v4);

                testObject.put("last", v5);
                testObject.put("lastUni", v6);
                testObject.put("lastRank", v7);
                testObject.put("lastSize", v8);
                testObject.put("lastGPA", v9);

                testObject.put("current", v10);
                testObject.put("currentUni", v11);
                testObject.put("currentComp", v12);
                testObject.put("currentRank", v13);
                testObject.put("currentSize", v14);
                testObject.put("currentGPA", v15);

                testObject.put("ifscholar", scho);
                testObject.put("names1", v16);
                testObject.put("years1", v17);
                testObject.put("names2", v18);
                testObject.put("years2", v19);

                testObject.put("iftest", tes);
                testObject.put("testname", v20);
                testObject.put("testyear", v21);
                testObject.put("testscore", v22);

                testObject.put("interestCourse", i);
                testObject.put("interest", v23);

                testObject.saveInBackground();
                Toast.makeText(MainActivity.this, "Your info has been uploaded!", Toast.LENGTH_LONG).show();
            }
        });

    }




    public void ifScholar(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.sy:
                scho = "Yes";
                break;
            case R.id.sn:
                scho = "No";
                break;
        }
    }


    public void iftest(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.ty:
                tes = "Yes";
                break;
            case R.id.tn:
                tes = "No";
                break;
        }
    }

    public void inter(View view){

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){

            case R.id.phd:
                if(checked){
                    interest.add("PhD");
                }else{
                    interest.remove("PhD");
                }
                break;
            case R.id.jphd:
                if(checked){
                    interest.add("Joint Phd with UoM");
                }else{
                    interest.remove("Joint Phd with UoM");
                }
                break;
            case R.id.mc:
                if(checked){
                    interest.add("Master by Coursework");
                }else{
                    interest.remove("Master by Coursework");
                }
                break;
            case R.id.mr:
                if(checked){
                    interest.add("Master by Research");
                }else{
                    interest.remove("Master by Research");
                }
                break;
            case R.id.other:
                if(checked){
                    interest.add("Ohter");
                }else{
                    interest.remove("Other");
                }
                break;
        }

    }


    public void setupUI(View view) {

        //Set up touch listener for non-text box views to hide keyboard.
        if(!(view instanceof EditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(MainActivity.this);
                    return false;
                }

            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View innerView = ((ViewGroup) view).getChildAt(i);

                setupUI(innerView);
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
