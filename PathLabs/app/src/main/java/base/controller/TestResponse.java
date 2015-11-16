package base.controller;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import base.ui.ProgressHUD;
import base.util.LogUtil;
import base.util.ToastUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sumit on 24-09-2015.
 */
public class TestResponse<T> implements Callback<T> {
    Context context;
    IScreen iScreen;
    String type;
  public TestResponse(Context context,IScreen iScreen, String type)
  {
      this.context = context;
      this.iScreen = iScreen;
      this.type = type;
  }


    @Override
    public void success(T t, Response response) {
        ToastUtil.showToastLong(context, cnageResponseToString(response));
        LogUtil.showVerboseLog("TestResponse", cnageResponseToString(response));
        ProgressHUD.dismissDialog();
    }

    @Override
    public void failure(RetrofitError error) {
        ToastUtil.showToastLong(context, error.getMessage());
    }
    public String cnageResponseToString(Response response)
    {
        //Try to get response body
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {

            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String result = sb.toString();
        return result;
    }
}
