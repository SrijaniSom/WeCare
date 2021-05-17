package com.example.healthcarefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.healthcarefinal.LoginAct;
import com.example.healthcarefinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUpActivity extends AppCompatActivity
{
    FirebaseAuth fauth;
    ProgressBar pbr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        CheckBox spass1=(CheckBox)findViewById(R.id.show_password);
        EditText mUserName=(EditText)findViewById(R.id.username);
        EditText mEmail=(EditText)findViewById(R.id.email);
        EditText mPassword=(EditText)findViewById(R.id.password);
        EditText mPhone=(EditText)findViewById(R.id.phone);
        Button mSignUp=(Button)findViewById(R.id.signUp_btn);
        Button login=(Button)findViewById(R.id.login_button);
        fauth=FirebaseAuth.getInstance();
        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar);
        spass1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        if(fauth.getCurrentUser()!=null)
        {
            startActivity(new Intent(signUpActivity.this,LoginAct.class));

        }

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String mail=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(mail))
                {
                    mEmail.setError("Email is necessary!!!");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mPassword.setError("Password is necessary!!!");
                    return;
                }
                if(password.length()<6)
                {
                    mPassword.setError("Password must be more than 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                fauth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(signUpActivity.this, purpActivity.class));
                            Toast.makeText(signUpActivity.this,"You registered successfully!",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(signUpActivity.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signUpActivity.this, LoginAct.class));
            }
        });




    }


}