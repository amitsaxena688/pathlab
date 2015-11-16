package base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import retrofit.client.Response;

/**
 * Created by Sumit on 21-09-2015.
 */
public class StringUtil {

    public static String cnageResponseToString(Response response)
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
    public static ArrayList<String> changeStringArrToList(String[] items)
    {
        ArrayList<String> itemsList = new ArrayList<String>();
       for(int i=0;i<items.length;i++)
       {
           itemsList.add(items[i]);
       }
        return itemsList;
    }
    public static HashMap<String,String> getTimeSlot()
    {

        HashMap<String,String> timeMap = new HashMap<>();
        timeMap.put("10am to 12pm","10");
        timeMap.put("12pm to 2pm","12");
        timeMap.put("2pm to 4pm","14");
        timeMap.put("4pm to 6pm","16");
        timeMap.put("6pm to 8pm","18");
       return timeMap;
    }
    public static ArrayList<String> getTimeSlotList()
    {
        HashMap<String,String> map = getTimeSlot();
        ArrayList<String> keyList = new ArrayList<>();
        Iterator iterator = map.keySet().iterator();
        keyList = new ArrayList<>();
        while (iterator.hasNext()) {
            keyList.add((String) iterator.next());
        }
        return keyList;
    }
    public static String getKey(String value,ArrayList<String> keyList)
    {
        HashMap<String,String> timeMap = getTimeSlot();
      for(String key:keyList)
      {
          if(value.equalsIgnoreCase(timeMap.get(key)))
          {
              return key;
          }
      }

       return "";
    }
}
