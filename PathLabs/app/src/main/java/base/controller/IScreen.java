package base.controller;
/***
 * 
 * @author Ankurgoyal
 *
 */
public interface IScreen {

    void handleResponse(String responseStr, String status, String msg, String type);
    void handleErrorMessage(Object response);

}
