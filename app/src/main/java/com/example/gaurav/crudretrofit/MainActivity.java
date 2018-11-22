package com.example.gaurav.crudretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.gaurav.crudretrofit.model.User;
import com.example.gaurav.crudretrofit.remote.APIUtils;
import com.example.gaurav.crudretrofit.remote.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnAddUser;
    Button btnGetUsersList;
    ListView listView;

    UserService userService;
    List<User> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           btnAddUser = (Button) findViewById(R.id.btnAddUser);
           btnGetUsersList = (Button) findViewById(R.id.btnGetUsersList);
           listView = (ListView) findViewById(R.id.listView);

            userService = APIUtils.getUserService();

            btnGetUsersList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get Users List
                    getUsersList();
                }
            });

            btnAddUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this, UserActivity.class);
                    intent.putExtra("user_name","");
                    startActivity(intent);
                }
            });


    }

    public  void getUsersList(){
        Call<List<User>> call=userService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    list=response.body();
                    listView.setAdapter(new UserAdapter(MainActivity.this,R.layout.list_user,list));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR:",t.getMessage());

            }
        });
    }
}
