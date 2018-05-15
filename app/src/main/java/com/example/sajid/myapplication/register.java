package com.example.sajid.myapplication;

import android.widget.EditText;

/**
 * Created by anees on 5/5/2018.
 */

public class register {

    String username;
    String useremail;
    String usernumber;
    String userphone;

    public register(String username, String useremail, String usernumber, String userphone) {
        this.username = username;
        this.useremail = useremail;
        this.usernumber = usernumber;
        this.userphone = userphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }


}
