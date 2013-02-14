package com.flosoftware.emileage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.flosoftware.emileage.R;
import com.flosoftware.emileage.database.userDataSource;
import com.flosoftware.emileage.domain.User;


public class UserActivity extends Activity {
    private userDataSource datasource;
	private EditText name;
    private EditText password;
    private User user;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		user = (User) i.getParcelableExtra("com.flosoftware.emileage.domain.User");
		setContentView(R.layout.userlayout);
		
		datasource = new userDataSource(this);
		datasource.open();
		
		name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.editPassword);

		if (user != null){
			name.setText(user.get_name());
            password.setText(user.get_password());
			
		} else {
			user = new User();
		}		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
	}

	@Override
	protected void onResume(){
		datasource.open();
		super.onResume();
	}
	
	@Override
	protected void onPause(){
		datasource.close();
		super.onPause();
	}
	
	public void saveUserClick(View v){
		saveUser();		
	}
	
	public void cancelSaveClick(View v){
		finish();
	}

	private void saveUser(){
		if (name.getText().length()>0 && password.getText().length()>0){
			user.set_name(name.getText().toString());
            user.set_password(password.getText().toString());
			
			if (user.get_id() != null || user.get_id() != 0){
				datasource.updateUser(user);
			}else {
				datasource.createUser(user);
			}
			finish();
		}		
	}
	
	
}
