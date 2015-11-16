/**
 * 
 */
package base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * @author Ankurgoyal
 * 
 */
public abstract class BaseChildFragment extends Fragment
		{
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// first saving my state, so the bundle wont be empty.
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY",
				"WORKAROUND_FOR_BUG_19917_VALUE");
		super.onSaveInstanceState(outState);
	}

	/**
	 * 
	 */
	public BaseChildFragment() {
		// TODO Auto-generated constructor stub
		
	}


	
/*
	*/
/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onStart()
	 *//*

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		BaseFragment baseFragment = (BaseFragment) getParentFragment();
		if(baseFragment!=null) 
		   baseFragment.setIChildBAckPressed(this);
	}
*/


}
