package com.example.scholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin_Login extends AppCompatActivity {
    EditText email,password;
    Button btn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.mail);
        password=findViewById(R.id.pass);
        btn=findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String mail,pass;
                mail=String.valueOf(email.getText());
                pass=String.valueOf(password.getText());
                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(Admin_Login.this,"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(Admin_Login.this,"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(mail, pass)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),"Login Successful..",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Admin.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Admin_Login.this,"Login Failed..",Toast.LENGTH_SHORT).show();

                            }
                        });

            }
        });

    }
}