package cn.itcast.actionbardemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity {

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle toggle;
	private MyActionBarDrawerToggle myToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		initActionBar();
	}

	private void initActionBar() {
		ActionBar actionBar = getSupportActionBar();// getActionBar();
		actionBar.setTitle("传智播客");// 设置标题
		actionBar.setDisplayHomeAsUpEnabled(true);// 显示返回箭头
		actionBar.setDisplayShowHomeEnabled(false);// 是否显示logo

		/*
		 * toggle = new ActionBarDrawerToggle(this, drawerLayout,
		 * R.drawable.ic_drawer_am, R.string.open, R.string.close);
		 * toggle.syncState();//同步状态
		 */
		DrawerArrowDrawable drawerImage = new DrawerArrowDrawable(this) {

			@Override
			public boolean isLayoutRtl() {
				return false;
			}
		};

		myToggle = new MyActionBarDrawerToggle(this,
				drawerLayout, drawerImage, R.string.open, R.string.close);
		myToggle.syncState();//同步状态
		
		drawerLayout.setDrawerListener(myToggle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.action_settings) {
			Toast.makeText(this, "设置被点中了", Toast.LENGTH_SHORT).show();
		} else if (itemId == android.R.id.home) {
			// finish();
			myToggle.onOptionsItemSelected(item);
		}
		return super.onOptionsItemSelected(item);
	}

}
