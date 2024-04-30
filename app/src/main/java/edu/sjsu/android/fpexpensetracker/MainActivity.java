package edu.sjsu.android.fpexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.sjsu.android.fpexpensetracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private Button btnLogin;
    private TextView mForgetPassword;
    private TextView mSignupHere;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loginDetails();
    }
    private void loginDetails(){
        mEmail = findViewById(R.id.email_login);
        mPass = findViewById(R.id.password_login);
        btnLogin = findViewById(R.id.btn_login);
        mForgetPassword = findViewById(R.id.forget_password);
        mSignupHere = findViewById(R.id.signup_reg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =mEmail.getText().toString().trim();
                String pass =mPass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email Required");
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    mPass.setError("Password Required");
                    return;
                }
            }
        });
        // Sends User to the Register Screen
        mSignupHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });
        //Sends User to the Reset the Password
        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ResetActivity.class));
            }
        });


    }
}