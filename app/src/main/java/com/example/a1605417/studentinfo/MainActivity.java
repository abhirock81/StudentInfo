package com.example.a1605417.studentinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view) {
        EditText editText1 = (EditText) findViewById(R.id.et1);
        EditText editText2 = (EditText) findViewById(R.id.et2);
        EditText editText3 = (EditText) findViewById(R.id.et3);
        EditText editText4 = (EditText) findViewById(R.id.et4);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        int rid = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(rid);
        Spinner spinner = (Spinner) findViewById(R.id.sp1);
        TextView textView = (TextView) findViewById(R.id.d_tv);
//values
        String name = editText1.getText().toString();
        String email = editText2.getText().toString();
        String password = editText3.getText().toString();
        String contact = editText4.getText().toString();
        String gender = radioButton.getText().toString();
        String dob = textView.getText().toString();
        String city = (String) spinner.getSelectedItem();

        if (email.length() == 0) {
            editText2.setError("Required");

        } else {
            if (password.length() == 0) {
                editText3.setError("Required");
            } else {
                MyDbHelper myDbHelper = new MyDbHelper(getApplicationContext());
                long aa = myDbHelper.insertData(name, email, password, contact, gender, dob, city);
                if (aa > 0) {
                    Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, Login.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Sign Up unSuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void pickDOB(View view) {

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.dob_popup, null);
        final PopupWindow popupWindow = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        final DatePicker datePicker = view1.findViewById(R.id.dp);
        Button button = view1.findViewById(R.id.b1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                TextView textView = (TextView) findViewById(R.id.d_tv);
                textView.setText(date);
                popupWindow.dismiss();
            }
        });

    }
}
