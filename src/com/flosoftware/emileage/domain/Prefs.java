package com.flosoftware.emileage.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/13/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Prefs {
    private Integer _id;
    private Integer _userId;
    private String _prefVal;
    private String _prefName;

    public Integer get_userId() {
        return _userId;
    }

    public void set_userId(Integer _userId) {
        this._userId = _userId;
    }

    public String get_prefVal() {
        return _prefVal;
    }

    public void set_prefVal(String _prefVal) {
        this._prefVal = _prefVal;
    }

    public String get_prefName() {
        return _prefName;
    }

    public void set_prefName(String _prefName) {
        this._prefName = _prefName;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }


}
