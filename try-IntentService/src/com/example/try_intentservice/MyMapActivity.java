package com.example.try_intentservice;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MyMapActivity extends MapActivity implements LocationListener {
	private static final String tag = MyMapActivity.class.getSimpleName();

	private LocationManager _lm;

	private MapView _mv;

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );

		_lm = (LocationManager)getSystemService( Context.LOCATION_SERVICE );
		_lm.requestSingleUpdate( LocationManager.GPS_PROVIDER, this, getMainLooper() );

		final Handler killLocationSearch = new Handler();
		killLocationSearch.postDelayed( new Runnable() {
			@Override
			public void run() {
				_lm.removeUpdates( MyMapActivity.this );
				Toast.makeText( MyMapActivity.this, "expired.", Toast.LENGTH_SHORT ).show();
			}
		}, 60 * 1000 );

		_mv = new MapView( this, getString( R.string.appid ) );
		final MapController mc = _mv.getMapController();
		mc.setCenter( new GeoPoint( 35665721, 139731006 ) );
		mc.setZoom( 1 );
		setContentView( _mv );
	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLocationChanged( Location l ) {
		Log.i( tag, "location=" + l.toString() );
		final MapController mc = _mv.getMapController();
		mc.setCenter( new GeoPoint( (int)( l.getLatitude() * 1E6 ), (int)( l.getLongitude() * 1E6 ) ) );
	}

	@Override
	public void onProviderDisabled( String provider ) {
		Log.i( tag, provider + " disabled." );
	}

	@Override
	public void onProviderEnabled( String provider ) {
		Log.i( tag, provider + " enabled." );
	}

	@Override
	public void onStatusChanged( String provider, int status, Bundle extras ) {
		Log.i( tag, "provider=" + provider + " status=" + status + " extras=" + extras.toString() );
	}

}
