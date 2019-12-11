package com.example.carrentalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class booking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView dateText;
    private TextView dateText2;
    private EditText mRoom,mAdult,mKids,mName,mNumber,mEmail;
    private Button mUpload;

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mReference = mDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        dateText = findViewById(R.id.textView2);
        dateText2 = findViewById(R.id.textView3);

        mRoom = findViewById(R.id.editText);
        mAdult = findViewById(R.id.editText2);
        mKids = findViewById(R.id.editText3);
        mName = findViewById(R.id.editText4);
        mNumber = findViewById(R.id.editText5);
        mEmail = findViewById(R.id.editText6);

        mUpload = findViewById(R.id.button3);

        mUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myRoom=mRoom.getText().toString().trim();
                String myAdult=mAdult.getText().toString().trim();
                String myKids=mKids.getText().toString().trim();
                String myName=mName.getText().toString().trim();
                String myNumber=mNumber.getText().toString().trim();
                String myEmail=mEmail.getText().toString().trim();
                String myArrival=dateText.getText().toString().trim();

                Map<String,String> nameMap = new HashMap<String,String>();
                nameMap.put("Departure Date",myArrival);
                nameMap.put("Car Name",myRoom);
                nameMap.put("Pickup Or Delivery",myAdult);
                nameMap.put("Address",myKids);
                nameMap.put("Name of Customer",myName);
                nameMap.put("Phone Number of Customer",myNumber);
                nameMap.put("Email of Customer",myEmail);

                mReference.push().setValue(nameMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(booking.this, "BOOKING SUCCESSFUL!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                showDatePickerDialog();
            }
        });
    }
    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = i2+"/"+i1+"/"+i;
        dateText.setText(date);

    }
}
