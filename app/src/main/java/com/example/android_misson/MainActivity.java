package com.example.android_misson;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText idText;
    EditText pwText;

    public static final int REQUEST_CODE_MENU=101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText=findViewById(R.id.usernameInput);
        pwText=findViewById(R.id.passwordInput);

        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=idText.getText().toString();
                String pw=pwText.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("username",id);
                intent.putExtra("password",pw);

                startActivityForResult(intent,REQUEST_CODE_MENU);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);


        if(requestCode==REQUEST_CODE_MENU){
            if(intent!=null){
                String menu=intent.getStringExtra("menu");
                String message=intent.getStringExtra("message");

                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

}

