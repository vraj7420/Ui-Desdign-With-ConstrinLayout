package com.example.uidesingn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etFirstName;
    private EditText etLastname;
    private EditText etEMail;
    private EditText etPassword;
    private EditText etRetypePassword;
    private Button btnSingUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirstName=(EditText)findViewById(R.id.etFirstName);
        etLastname=(EditText)findViewById(R.id.etLastName);
        etEMail=(EditText) findViewById(R.id.etEmail);
        etPassword=(EditText) findViewById(R.id.etPassword);
        etRetypePassword= (EditText) findViewById(R.id.etRetypePassword);
        btnSingUp= findViewById(R.id.btnSingup);
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              allValidate();
            }
        });
    }
    public  void  allValidate() {

         String password=etPassword.getText().toString();
         String retypePassword=etRetypePassword.getText().toString();
        if (etFirstName.getText().toString().isEmpty() || etFirstName.getText().toString().matches("\\s+")) {
                etFirstName.setError("Please Enter First Name");
        } else if (etLastname.getText().toString().isEmpty() || etLastname.getText().toString().matches("\\s+")) {
                   etLastname.setError("Please Enter Last Name");
        } else if (!(!etEMail.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(etEMail.getText().toString()).matches())) {
            etEMail.setError("Please  Enter  Valid Email Id");
        } else if (etPassword.getText().toString().isEmpty()) {
            etPassword.setError("Please Enter Password");
        } else if (etRetypePassword.getText().toString().isEmpty()) {
            etRetypePassword.setError("Please Enter Password agin");
        }else if(!password.equals(retypePassword)){
               etRetypePassword.setError("Password dosen't Match");
        }
        else {
            return;
        }
    }
}