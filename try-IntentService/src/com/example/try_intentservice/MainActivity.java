package com.example.try_intentservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView( R.layout.activity_main );

		final Button btn = (Button)findViewById( R.id.button1 );
		btn.setOnClickListener( launchView );

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private final OnClickListener launchView = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			MainActivity.this.startActivity( new Intent( MainActivity.this, MyMapActivity.class ) );
		}

	};

}
