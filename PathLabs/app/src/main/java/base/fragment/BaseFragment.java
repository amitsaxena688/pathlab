package base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.pathlabs.R;


/***
 * Base fragment class for all fragment
 * 
 * @author Ankurgoyal
 * 
 */
public abstract class BaseFragment extends Fragment {
	protected BackHandlerInterface backHandlerInterface;
	/***
	 * handle in case of viewpager
	 */
	protected boolean fragmentResume = false;
	protected boolean fragmentVisible = false;
	protected boolean fragmentOnCreated = false;
	private BaseChildFragment baseChildFragment;
	private String TAG = "BaseFragment";

	/** end this */
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// first saving my state, so the bundle wont be empty.
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY",
				"WORKAROUND_FOR_BUG_19917_VALUE");
		super.onSaveInstanceState(outState);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (!(getActivity() instanceof BackHandlerInterface)) {
			throw new ClassCastException(
					"Hosting activity must implement BackHandlerInterface");
		} else {
			backHandlerInterface = (BackHandlerInterface) getActivity();
		}
	}

	public BaseFragment() {
		// TODO Auto-generated constructor stub
	}

	/***
	 * update title on page chnage
	 */
	public  void updateTilte(){
		if(updateChild!=null) {
			updateChild.updateChild();
		}
	}

	public boolean onBackPressed() {
		if (ichildBackPressed != null) {
			return ichildBackPressed.onChildBackPressed();
		} else {
			return false;
		}
	}


	/***
	 * for other fragment
	 * 
	 * @param fragment
	 * @param tag
	 */
	public void setFragment(Fragment fragment, String tag) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.right_in,
				R.anim.left_out, R.anim.left_in, R.anim.right_out);

		fragmentTransaction.add(R.id.container_id, fragment, tag);
		fragmentTransaction.addToBackStack(tag);
		fragmentTransaction.commit();
	}

	/***
	 * for other fragment
	 * 
	 * @param fragment
	 * @param tag
	 */
	public void setChildFragment(Fragment fragment, String tag) {
		FragmentManager fragmentManager = getChildFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.right_in,
				R.anim.left_out, R.anim.left_in, R.anim.right_out);

		fragmentTransaction.add(R.id.container_id, fragment, tag);
		fragmentTransaction.addToBackStack(tag);
		fragmentTransaction.commit();
		setShowingChild(true);
		if(fragment instanceof BaseChildFragment) {
		this.baseChildFragment = (BaseChildFragment) fragment;
		}
	}


	@Override
	public void onStart() {
		super.onStart();
		// if (backHandlerInterface != null)
		// backHandlerInterface.setSelectedFragment(this);
	}

	public interface BackHandlerInterface {
		public void setSelectedFragment(BaseFragment backHandledFragment);
	}

	private IchildBackPressed ichildBackPressed;

	public void setIChildBAckPressed(IchildBackPressed ichildBackPressed) {
		this.ichildBackPressed = ichildBackPressed;
	}

	public interface IchildBackPressed {
		boolean onChildBackPressed();
	}

	/** clear fragment stack */
	public void clearAllStack() {
		if (isShowingChild()) {
			final FragmentManager fragmentManager = getChildFragmentManager();
			while (fragmentManager.getBackStackEntryCount() != 0) {
				fragmentManager.popBackStackImmediate();
			}
		}

	}

	/***
	 * update ui when fragment is visisble in case of view pager
	 */
	public void updateUi() {
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO Auto-generated method stub
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser && isResumed()) { // only at fragment screen is
												// resumed
			fragmentResume = true;
			fragmentVisible = false;
			fragmentOnCreated = true;
			updateUi();
		} else if (isVisibleToUser) { // only at fragment onCreated
			fragmentResume = false;
			fragmentVisible = true;
			fragmentOnCreated = true;
		} else if (!isVisibleToUser && fragmentOnCreated) {// only when you go
															// out of fragment
															// screen
			fragmentVisible = false;
			fragmentResume = false;
		}
	}

	private boolean mShowingChild;

	protected boolean isShowingChild() {
		return mShowingChild;
	}

	protected void setShowingChild(boolean showingChild) {
		mShowingChild = showingChild;
	}

	public UpdateChild updateChild;

	public void setUpdateChild(UpdateChild updateChild) {
		this.updateChild = updateChild;
	}

	public interface UpdateChild {
		void updateChild();
	}
}
