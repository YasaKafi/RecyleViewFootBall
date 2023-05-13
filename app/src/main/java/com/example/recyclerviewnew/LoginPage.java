package com.example.recyclerviewnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {

    EditText username, password;

    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        buttonLogin = findViewById(R.id.button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameKu = username.getText().toString();
                String passwordKu = password.getText().toString();
                AndroidNetworking.post("https://mediadwi.com/api/latihan/login")
                        .addBodyParameter("username", usernameKu)
                        .addBodyParameter("password", passwordKu)
                        .setTag("login")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    boolean status = response.getBoolean("status");
                                    String message = response.getString("message");
                                    if (status){

                                        if (TextUtils.isEmpty(usernameKu) || TextUtils.isEmpty(usernameKu)) {
                                            // menampilkan Toast error
                                            Toast.makeText(getApplicationContext(), "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                                            return;
                                        }else{
                                            Toast.makeText(LoginPage.this, message, Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(LoginPage.this,MainActivity.class);
                                            startActivity(intent);
                                        }


                                    }else{
                                        Toast.makeText(LoginPage.this, "Login Gagal", Toast.LENGTH_LONG).show();
//
                                    }
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            }

                            @Override
                            public void onError(ANError error) {
                                // Handle error
                                Toast.makeText(LoginPage.this, "Login gagal. Error: " + error.getErrorBody(), Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });
    }
}