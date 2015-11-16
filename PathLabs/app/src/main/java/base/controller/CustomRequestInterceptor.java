package base.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import retrofit.RequestInterceptor;

/**
 * Created by Sumit on 01-09-2015.
 */
public class CustomRequestInterceptor implements RequestInterceptor {
    public HashMap<String,String> headerMap;
    public CustomRequestInterceptor(HashMap<String,String> headerMap)
    {
        this.headerMap = headerMap;
    }
    @Override
    public void intercept(RequestFacade request) {
        if(headerMap!=null&&!headerMap.isEmpty())
        {
          Set<String> keySet =  headerMap.keySet();
            Iterator itr = keySet.iterator();
            while(itr.hasNext())
            {
                String key = (String)itr.next();
                request.addHeader(key,headerMap.get(key));
            }

        }


    }
}
