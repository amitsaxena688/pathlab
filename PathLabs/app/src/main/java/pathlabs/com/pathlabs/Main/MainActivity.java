package pathlabs.com.pathlabs.Main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.pathlabs.R;

import base.Activity.BaseActivity;
import base.constents.AppConstent;
import base.util.NetworkUtil;
import base.util.PreferenceUtil;
import base.util.ToastUtil;
import pathlabs.com.pathlabs.Main.fragment.DashboardFragment;

public class MainActivity extends BaseActivity {
  private DrawerLayout mDrawerLayout;
    private TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        //set up tool bar to show actoin items
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set home menu button
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
        tvUserName = (TextView)navigationView.findViewById(R.id.tv_user_name);
        tvUserName.setText(PreferenceUtil.getUserName(this));
        DashboardFragment appointmentListFragment = new DashboardFragment();
        setFragment(appointmentListFragment, AppConstent.APPOINTMENT_LIST);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.nav_logout:
                                if (NetworkUtil.checkInternetConnection(MainActivity.this)) {
                                  //  new RequestController().logOut(MainActivity.this, MainActivity.this, PreferenceUtil.getUserId(MainActivity.this), ApiConstent.HOST_ID, ApiConstent.LOGOUT);
                                } else {
                                    ToastUtil.showToastShort(MainActivity.this, getResources().getString(R.string.no_internet_connection));
                                }
                                break;
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.action_map:
                switchActivity();
                break;*/
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void init() {

    }

    @Override
    public void setDateToView() {

    }
}
