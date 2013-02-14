package com.flosoftware.emileage.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/13/13
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private Long _id;
    private String _name;
    private String _password;
    private String _authkey;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_authkey() {
        return _authkey;
    }

    public void set_authkey(String _authkey) {
        this._authkey = _authkey;
    }



}
