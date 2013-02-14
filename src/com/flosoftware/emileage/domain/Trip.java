package com.flosoftware.emileage.domain;


import android.location.Location;
import java.sql.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Doug Miller
 * Date: 2/13/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Trip {

    private Integer _id;
    private Integer _userId;
    private Double _startLat;
    private Double _startLong;
    private Double _endLat;
    private Double _endLong;
    private Double _distance;
    private String _startName;
    private String _endName;
    private Date _tripDate;
    private Set<TripPoint> tripData;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer get_userId() {
        return _userId;
    }

    public void set_userId(Integer _userId) {
        this._userId = _userId;
    }

    public Double get_startLat() {
        return _startLat;
    }

    public void set_startLat(Double _startLat) {
        this._startLat = _startLat;
    }

    public Double get_startLong() {
        return _startLong;
    }

    public void set_startLong(Double _startLong) {
        this._startLong = _startLong;
    }

    public Double get_endLat() {
        return _endLat;
    }

    public void set_endLat(Double _endLat) {
        this._endLat = _endLat;
    }

    public Double get_endLong() {
        return _endLong;
    }

    public void set_endLong(Double _endLong) {
        this._endLong = _endLong;
    }

    public Double get_distance() {
        return _distance;
    }

    public void set_distance(Double _distance) {
        this._distance = _distance;
    }

    public String get_startName() {
        return _startName;
    }

    public void set_startName(String _startName) {
        this._startName = _startName;
    }

    public String get_endName() {
        return _endName;
    }

    public void set_endName(String _endName) {
        this._endName = _endName;
    }

    public Date get_tripDate() {
        return _tripDate;
    }

    public void set_tripDate(Date _tripDate) {
        this._tripDate = _tripDate;
    }

    public Set<TripPoint> getTripData() {
        return tripData;
    }

    public void setTripData(Set<TripPoint> tripData) {
        this.tripData = tripData;
    }




}
