package base.controller;


import org.json.JSONException;
import org.json.JSONObject;

import base.util.LogUtil;
import base.util.StringUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sumit on 01-09-2015.
 */
public class ServiceResponse<T> implements Callback<T>{
public IScreen iScreen;
    String type;
    final String TAG = "ServiceResponse";
    public ServiceResponse(IScreen iScreen, String type)
    {
        this.iScreen = iScreen;
        this.type  = type;
    }
    @Override
    public void success(T t, Response response) {
        String responseStr = StringUtil.cnageResponseToString(response);
        String msg="",status="";
       LogUtil.showVerboseLog(TAG, responseStr);
        try {
            JSONObject jsonObject = new JSONObject(responseStr);
           try {
               msg = jsonObject.getString("msg");
           }
           catch (Exception e)
           {
               msg="msg not found";
           }
            status = jsonObject.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        iScreen.handleResponse(responseStr,status,msg,type);
    }

    @Override
    public void failure(RetrofitError error) {
        iScreen.handleErrorMessage(error);
    }




}
