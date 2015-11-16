package base.Activity;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.pathlabs.R;

import base.fragment.BaseFragment;


/***
 * 
 * @author Ankurgoyal
 * 
 */
public abstract class BaseActivity extends ActionBarActivity implements
		OnBackStackChangedListener,BaseFragment.BackHandlerInterface {
	final static private long ONE_SECOND = 1000;
	final static private long TWENTY_MIN = ONE_SECOND * 1200;
	PendingIntent pi;
	BroadcastReceiver br;
	AlarmManager am;
	boolean isVisible = true;
	public BaseFragment baseFragment;

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.right_in, R.anim.left_out);
//		getSupportActionBar().setHomeButtonEnabled(true);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportFragmentManager().addOnBackStackChangedListener(this);
		// set color to action bar
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			try {
				Window window = this.getWindow();
				window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				window.setStatusBarColor(this.getResources().getColor(
						R.color.nliveo_blue_colorPrimaryDark));
			} catch (Exception e) {
				e.getMessage();
			}
		}

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
//			overridePendingTransition(R.anim.left_in, R.anim.right_out);
//			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/** Apply code */
	public void setFragment(Fragment fragment, String tag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		 fragmentTransaction.setCustomAnimations(R.anim.right_in, R.anim.left_out);
		fragmentTransaction
				.setCustomAnimations(R.anim.zoom_out, R.anim.zoom_in);
		fragmentTransaction.add(R.id.container_id, fragment, tag);
		fragmentTransaction.addToBackStack(tag);
		fragmentTransaction.commit();
	}
	/** calculator code */
	public void setFragmentleftAnimation(Fragment fragment, String tag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.setCustomAnimations(
				R.anim.right_in,
				R.anim.left_out,
				R.anim.left_in,
				R.anim.right_out);
		fragmentTransaction.add(R.id.container_id, fragment, tag);
		fragmentTransaction.addToBackStack(tag);
		fragmentTransaction.commit();
	}
	public void setFragmentWithoutAnim(Fragment fragment, String tag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.add(R.id.container_id, fragment, tag);
		fragmentTransaction.addToBackStack(tag);
		fragmentTransaction.commit();
	}

	@Override
	public void onBackStackChanged() {

		BaseFragment baseFragment = getFragment();
		if (baseFragment != null) {
			setSelectedFragment(baseFragment);
			baseFragment.updateTilte();

		}
	}

	private BaseFragment getFragment() {
		BaseFragment fragment = (BaseFragment) getSupportFragmentManager()
				.findFragmentById(R.id.container_id);
		return fragment;
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		try {

			if (br != null) {
				if (am != null) {
					am.cancel(pi);
					unregisterReceiver(br);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setSelectedFragment(BaseFragment backHandledFragment) {
		System.out.println("<<<< in this block selected fragment");
		this.baseFragment = backHandledFragment;
	}




	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();


	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		overridePendingTransition(R.anim.left_in, R.anim.right_out);
		super.onPause();


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v7.app.ActionBarActivity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {

		super.onBackPressed();
		finish();
		overridePendingTransition(R.anim.left_in, R.anim.right_out);

	}



	@SuppressLint("NewApi")
	public void setStatsBarcolor(int themecolor) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			try {
				Window window = this.getWindow();
				window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				window.setStatusBarColor(this.getResources().getColor(
						themecolor));
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	public abstract void init();
	public abstract void setDateToView();
}
