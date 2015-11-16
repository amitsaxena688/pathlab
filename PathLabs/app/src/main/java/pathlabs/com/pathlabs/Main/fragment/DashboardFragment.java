package pathlabs.com.pathlabs.Main.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pathlabs.R;

import base.controller.IScreen;
import base.fragment.BaseFragment;
import base.ui.ProgressHUD;
import base.util.ToastUtil;
import retrofit.RetrofitError;


/**
 * Created by Sumit on 18-09-2015.
 */
public class DashboardFragment extends BaseFragment implements IScreen {
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment_layout, container, false);
        initializeView(view);

        return view;
    }


    private void setDataToView() {

    }

    private void initializeView(View view) {


    }


    @Override
    public void handleResponse(String responseStr, String status, String msg, String type)
    {

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void handleErrorMessage(Object response) {
        RetrofitError error = (RetrofitError) response;
        ProgressHUD.dismissDialog();
        ToastUtil.showToastShort(getActivity(), error.getMessage());
        getActivity().finish();
    }
}
