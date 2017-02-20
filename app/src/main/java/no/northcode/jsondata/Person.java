package no.northcode.jsondata;

import com.google.gson.Gson;

/**
 * Created by andreas on 16/02/17.
 */

public class Person {
    private int u_id;               //Id.
    private String userName;        //Brukernavn
    private String password;        //Passord
    private String firstname;       //Fornavn
    private String lastname;        //Etternavn
    private String phone;           //Telefonnummer (obligatorisk)
    private boolean user_activated; //Aktivert eller ikke. Settes som aktiv av admin/lærer.

    public Person() {
        this.userName = "";
        this.password = "";
        this.firstname = "";
        this.lastname = "";
        this.phone = "";
        this.user_activated = false;
    }

    public Person(int u_id, String userName, String password, String firstname, String lastname, String phone, boolean user_activated) {
        this.u_id = u_id;
        this.userName = userName;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.user_activated = user_activated;
    }

    public Person(String userName, String password, String firstname, String lastname, String phone, boolean user_activated) {
        this.userName = userName;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.user_activated = user_activated;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isUser_activated() {
        return user_activated;
    }

    public void setUser_activated(boolean user_activated) {
        this.user_activated = user_activated;
    }

    public String toJSONString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
