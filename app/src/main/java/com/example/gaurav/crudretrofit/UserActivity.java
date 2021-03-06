package com.example.gaurav.crudretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaurav.crudretrofit.model.User;
import com.example.gaurav.crudretrofit.remote.APIUtils;
import com.example.gaurav.crudretrofit.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    UserService userService;
    EditText edtUId;
    EditText edtUsername;
    Button btnBack;
    Button btnSave;
    Button btnDel;
    TextView txtUId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        txtUId =(TextView)findViewById(R.id.tUId);
        edtUId =(EditText) findViewById(R.id.edtUId);
        edtUsername =(EditText) findViewById(R.id.edtUsername);
        btnBack =(Button) findViewById(R.id.btnBack);
        btnSave =(Button) findViewById(R.id.btmSave);
        btnDel =(Button) findViewById(R.id.btnDelete);


        userService= APIUtils.getUserService();

        Bundle extras=getIntent().getExtras();
        final String userId=extras.getString("user_id");
        String userName=extras.getString("user_name");


        edtUId.setText(userId);
        edtUsername.setText(userName);

        if(userId!=null&&userId.trim().length()>0){
                edtUId.setFocusable(false);
        }else{
            txtUId.setVisibility(View.INVISIBLE);
            edtUId.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);

        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u =new User();
                u.setName(edtUsername.getText().toString());
                if(userId!=null&&userId.trim().length()>0){
                    //Update User
                    updateUser(Integer.parseInt(userId),u);
                }else{
                    // add User
                    addUser(u);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser(Integer.parseInt(userId));

                Intent intent=new Intent(UserActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });



    }

    public  void addUser(User u){
        Call<User> call=userService.addUser(u);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UserActivity.this,"User Updated Successfully",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ",t.getMessage());

            }
        });

    }


    public  void updateUser(int id, User u){
        Call<User> call=userService.UpdateUser(id,u);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UserActivity.this,"User Created Successfully",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ",t.getMessage());

            }
        });

    }


    public  void deleteUser(int id){
        Call<User> call=userService.deleteUser(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UserActivity.this,"User deleted Successfully",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ",t.getMessage());

            }
        });

    }


}
