package com.example.sachinpc.restshoecommerce;

/**
 * Created by SachinPC on 3/6/2018.
 */


        import com.google.gson.annotations.SerializedName;

        import java.io.Serializable;



public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
@SerializedName("user_id")
    int user_id;

    @SerializedName("f_name")
    String f_name;

    @SerializedName("l_name")
    String l_name;
    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;


    String Password2;

    /**
     * @return the password2
     */
    public String getPassword2() {
        return Password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        Password2 = password2;
    }

    public User(String f_name2, String l_name2, String email2, String password2) {
        // TODO Auto-generated constructor stub

    }

    public User(int id, String f_name2, String l_name2, String email2, String password2) {
        user_id = id;
        // TODO Auto-generated constructor stub
        f_name = f_name2;
        l_name = l_name2;
        email = email2;
        password = password2;
    }

    public User() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the f_name
     */
    public String getF_name() {
        return f_name;
    }

    /**
     * @param f_name the f_name to set
     */
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    /**
     * @return the l_name
     */
    public String getL_name() {
        return l_name;
    }

    /**
     * @param l_name the l_name to set
     */
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }



}
