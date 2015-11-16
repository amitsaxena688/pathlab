package base.util;

import java.util.HashMap;



/**
 * Created by Sumit on 21-09-2015.
 */
public class MapUtil {
    static HashMap<Enum,Integer> iconMap;
    public static enum customerType{AGENT,CUSTOMER_VARIFIED,CUSTOMER_UNVARIFIED};
   public static void setIcon()
   {
       if(iconMap==null) {
           iconMap = new HashMap<>();
//           iconMap.put(customerType.AGENT, R.drawable.icon_agent_location);
//           iconMap.put(customerType.CUSTOMER_VARIFIED, R.drawable.visited_location);
//           iconMap.put(customerType.CUSTOMER_UNVARIFIED, R.drawable.icon_cust_detail_loc);
       }
   }

   public static int getIcon(customerType customerType)
   {
       setIcon();
       return iconMap.get(customerType);
   }
}
