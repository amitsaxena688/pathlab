package base.fragment;/*
package base.application.fragment;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import fos.com.fosmanager.ui.R;


public class AboutFragment extends BaseFragment implements OnClickListener{
	TextView goToLegalInfo ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_about, container, false);
		initView(view);
		return view;
	}
	
	private void initView(View view) {
		goToLegalInfo = (TextView) view.findViewById(R.id.tv_goToLegalInfo);
		goToLegalInfo.setOnClickListener(this);
		TextView versionCode = (TextView) view.findViewById(R.id.tv_version);
		PackageInfo pInfo = null;
		try {
			pInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String version = pInfo.versionName;
		versionCode.setText(getActivity().getResources().getString(R.string.app_version)+" "+version);
	}


	@Override
	public void onResume() {
		super.onResume();
		ActionBar actionBar = ((ActionBarActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle(R.string.about);
	}

	@Override
	public void updateTilte() {
		ActionBar actionBar = ((ActionBarActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle(R.string.about);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.home_menu, menu);
		menu.clear();
	}

	@Override
	public void onClick(View v) {
		Fragment legalInfo = new LegalInformationFragment();
		setFragment(legalInfo,AppConstants.ABOUT_FRAGMENT,AppConstants.ABOUT);
	}

	@Override
	public void handleErrorMessage(Object response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleErrorMessage(Object response, String type) {
		// TODO Auto-generated method stub
		
	}

}
*/
