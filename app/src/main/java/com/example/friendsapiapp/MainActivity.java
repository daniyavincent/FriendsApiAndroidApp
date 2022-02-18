package com.example.friendsapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2, edt3, edt4;
    AppCompatButton btn1,btn2;
    String getName, getFriendName, getNickName, getDes;
    String apiUrl = "https://dummyapifriends.herokuapp.com/adddata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        edt3=(EditText) findViewById(R.id.edt3);
        edt4=(EditText) findViewById(R.id.edt4);
        btn1=(AppCompatButton) findViewById(R.id.btn1);
        btn2=(AppCompatButton) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=edt1.getText().toString();
                getFriendName=edt2.getText().toString();
                getNickName=edt3.getText().toString();
                getDes=edt4.getText().toString();

                StringRequest sr=new StringRequest(Request.Method.POST, apiUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                edt1.setText("");
                                edt2.setText("");
                                edt3.setText("");
                                edt4.setText("");
                                Toast.makeText(getApplicationContext(),response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> params=new HashMap<>();
                        params.put("name",getName);
                        params.put("friendName",getFriendName);
                        params.put("friendNickName",getNickName);
                        params.put("DescribeYourFriend",getDes);
                        return params;
                    }
                };
                RequestQueue rq= Volley.newRequestQueue(getApplicationContext());
                rq.add(sr);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(i);
            }
        });
    }
}