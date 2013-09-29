package com.example.try_intentservice;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import android.os.Bundle;

public class MyMapActivity extends MapActivity {

	private MapView _mv = null;

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );

		_mv = new MapView( this, getString( R.string.appid ) );
		final MapController mc = _mv.getMapController();
		mc.setCenter( new GeoPoint( 35665721, 139731006 ) );
		mc.setZoom( 1 );
		setContentView( _mv );
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
