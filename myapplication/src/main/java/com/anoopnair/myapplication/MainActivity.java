package com.anoopnair.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.anoopnair.httpzoid.Http;
import com.anoopnair.httpzoid.HttpFactory;
import com.anoopnair.httpzoid.HttpResponse;
import com.anoopnair.httpzoid.ResponseHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Http http = HttpFactory.create(this);
        http.get("http://anoopnair.com/employee.json").handler(new ResponseHandler<Employee>(){
            @Override
            public void success(Employee e, HttpResponse response) {
                super.success(e, response);
                Log.d("hurrey", e.name);
            }
        }).send();
    }
}

class Employee{
    public String name ;
    public int age ;
}
