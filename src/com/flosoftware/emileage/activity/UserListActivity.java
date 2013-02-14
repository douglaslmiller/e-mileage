package com.flosoftware.emileage.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.flosoftware.emileage.R;
import com.flosoftware.emileage.database.userDataSource;
import com.flosoftware.emileage.domain.User;


import java.util.List;


public class UserListActivity extends ListActivity {
	private userDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userlistlayout);

		datasource = new userDataSource(this);
		datasource.open();

		List<User> values = datasource.getAllUsers();

		// Use the SimpleCursorAdapter to show the
		// elements in a ListView
		ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		
		
	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    Intent intent = new Intent(UserListActivity.this, UserActivity.class);
		User item = (User) getListAdapter().getItem(position);
				
		//intent.putExtra("com.emileage.domain.User", item);
		startActivity(intent);
		finish();
				
	}
	
	@Override
	protected void onPause(){
		datasource.close();
		super.onPause();
	}
}
