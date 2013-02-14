package com.flosoftware.emileage.domain;

import android.location.Location;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/13/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class TripPoint {
    private Integer _id;
    private Integer _userID;
    private Integer _tripID;
    private double _latitude;
    private double _longitude;
    private Integer _timestamp;

    public double get_latitude() {
        return _latitude;
    }

    public void set_latitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double get_longitude() {
        return _longitude;
    }

    public void set_longitude(double _longitude) {
        this._longitude = _longitude;
    }

    public Integer get_timestamp() {
        return _timestamp;
    }

    public void set_timestamp(Integer _timestamp) {
        this._timestamp = _timestamp;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer get_userID() {
        return _userID;
    }

    public void set_userID(Integer _userID) {
        this._userID = _userID;
    }

    public Integer get_tripID() {
        return _tripID;
    }

    public void set_tripID(Integer _tripID) {
        this._tripID = _tripID;
    }

}
