package base.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sumit on 23-09-2015.
 */
public class PreferenceUtil {
    public static final String PREFERENCE_NAME = "fos_pref";
    public static final String PREF_USER_NAME = "user_name";
    public static final String PREF_USER_PASSWORD = "user_password";
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_LOGIN_STATUS = "login_status";
    public static final String PREF_ROLE_TYPE = "role_type";
    public static final String PREF_USER_STATUS_TYPE = "user_status_type";
    public static final String PREF_USER_ROLE_TYPE = "user_role_type";
    public static final String PREF_IS_TARGET_COMPLETED = "is_target_completed";
    public static final String PREF_LAST_DATE = "last_date";
    public static final String PREF_TODAY_APPOINTMENT = "today_appointment";
    /***
     * Clear preference data
     */
    public static void clearData(Context pContext) {
        getSharedPrefs(pContext).edit().clear().commit();
    }
    //get preference
    private static SharedPreferences getSharedPrefs(Context pContext) {
        return pContext.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);

    }

    //user name
    public static void setUserName(Context context,String userName)
    {
        getSharedPrefs(context).edit().putString(PREF_USER_NAME, userName).commit();
    }
    public static String getUserName(Context context)
    {
        return getSharedPrefs(context).getString(PREF_USER_NAME, "");
    }

    //user password
    public static void setUserPassword(Context context,String password)
    {
        getSharedPrefs(context).edit().putString(PREF_USER_PASSWORD,password).commit();
    }
    public static String getUserPassword(Context context)
    {
        return getSharedPrefs(context).getString(PREF_USER_PASSWORD,"");
    }

    //user ID
    public static void setUserId(Context context,String userId)
    {
        getSharedPrefs(context).edit().putString(PREF_USER_ID,userId).commit();
    }
    public static String getUserId(Context context)
    {
        return getSharedPrefs(context).getString(PREF_USER_ID,"");
    }

    //user ID
    public static void setLoginStatus(Context context,boolean loginStatus)
    {
        getSharedPrefs(context).edit().putBoolean(PREF_LOGIN_STATUS, loginStatus).commit();
    }
    public static boolean getLoginStatus(Context context)
    {
        return getSharedPrefs(context).getBoolean(PREF_LOGIN_STATUS, false);
    }

    //Role type
    public static void setRoleType(Context context, String roleType)
    {
        getSharedPrefs(context).edit().putString(PREF_ROLE_TYPE, roleType).commit();
    }
    public static String getRoleType(Context context)
    {
        return getSharedPrefs(context).getString(PREF_ROLE_TYPE, "");
    }

    //user role type
    public static void setUserRoleType(Context context,String userRoleType)
    {
        getSharedPrefs(context).edit().putString(PREF_USER_ROLE_TYPE, userRoleType).commit();
    }
    public static String getUserRoleType(Context context)
    {
        return getSharedPrefs(context).getString(PREF_USER_ROLE_TYPE, "");
    }

    //user status id
    public static void setUserStatusType(Context context,String userStatusId)
    {
        getSharedPrefs(context).edit().putString(PREF_USER_STATUS_TYPE, userStatusId).commit();
    }
    public static String getUserStatusType(Context context)
    {
        return getSharedPrefs(context).getString(PREF_USER_STATUS_TYPE, "");

    }
    //get target complete field
    public static void setTargetCompleted(Context context,boolean value)
    {
        getSharedPrefs(context).edit().putBoolean(PREF_IS_TARGET_COMPLETED, value).commit();
    }
    public static boolean getTargetCompleted(Context context)
    {
        return getSharedPrefs(context).getBoolean(PREF_IS_TARGET_COMPLETED, true);
    }

    //get today appointment list

    public static void setAppointmentList(Context context,String appointmentList)
    {
        getSharedPrefs(context).edit().putString(PREF_TODAY_APPOINTMENT, appointmentList).commit();
    }
    public static String getAppointmentList(Context context)
    {
        return getSharedPrefs(context).getString(PREF_TODAY_APPOINTMENT, "");
    }
    //get common boolean fields

    public static void setBoolean(Context context,String key,boolean value)
    {
        getSharedPrefs(context).edit().putBoolean(key, value).commit();
    }
    public static boolean getBoolean(Context context,String key)
    {
        return getSharedPrefs(context).getBoolean(key, false);
    }
//get common string fields

    public static void setString(Context context,String key,String value)
    {
        getSharedPrefs(context).edit().putString(key, value).commit();
    }
    public static String getString(Context context,String key)
    {
        return getSharedPrefs(context).getString(key, "");
    }
}
