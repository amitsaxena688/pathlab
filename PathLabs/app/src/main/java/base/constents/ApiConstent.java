package base.constents;

/**
 * Created by sumit on 22-09-2015.
 */
public interface ApiConstent {
    public String TEST_URL = "http://crm.paisabazaar.com/api";
    public String BASE_URL = TEST_URL;

    //Response type
    public String SUCCESS = "1";
    public String FAILURE = "0";
    public String HOST_ID = "6";

    //Request type
    public String LOGIN_USER = "login_user";
    public String LOG_USER_DATA = "log_user_data";
    public String USER_DETAIL = "user_detail";
    public String GET_APPOINTMENT_LIST = "get_appointment_list";
    public String LOGOUT = "logout";
    public String GET_STATUS = "get_status";
    public String UPDATE_STATUS = "update_status";
}
