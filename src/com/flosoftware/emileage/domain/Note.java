package com.flosoftware.emileage.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/12/13
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Note {
    private Integer _id;
    private String _note;
    private Integer _tripid;
    private Integer _userid;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _noteid) {
        this._id = _noteid;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public Integer get_tripid() {
        return _tripid;
    }

    public void set_tripid(Integer _tripid) {
        this._tripid = _tripid;
    }

    public Integer get_userid() {
        return _userid;
    }

    public void set_userid(Integer _userid) {
        this._userid = _userid;
    }







}
