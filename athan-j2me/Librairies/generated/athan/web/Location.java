package athan.web;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class Location extends SoapObject {
    private java.lang.String cityName;

    private athan.web.Coordinate coordinates;

    private java.lang.String countryName;

    private java.lang.String regionName;

    public Location() {
        super("", "");
    }
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }

    public java.lang.String getCityName(java.lang.String cityName) {
        return this.cityName;
    }

    public void setCoordinates(athan.web.Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public athan.web.Coordinate getCoordinates(athan.web.Coordinate coordinates) {
        return this.coordinates;
    }

    public void setCountryName(java.lang.String countryName) {
        this.countryName = countryName;
    }

    public java.lang.String getCountryName(java.lang.String countryName) {
        return this.countryName;
    }

    public void setRegionName(java.lang.String regionName) {
        this.regionName = regionName;
    }

    public java.lang.String getRegionName(java.lang.String regionName) {
        return this.regionName;
    }

    public int getPropertyCount() {
        return 4;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return cityName;
        case 1: return coordinates;
        case 2: return countryName;
        case 3: return regionName;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: cityName = (java.lang.String) __obj; break;
        case 1: coordinates = (athan.web.Coordinate) __obj; break;
        case 2: countryName = (java.lang.String) __obj; break;
        case 3: regionName = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "cityName";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "coordinates";
            __info.type = athan.web.Coordinate.class; break;
        case 2:
            __info.name = "countryName";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "regionName";
            __info.type = java.lang.String.class; break;
        }
    }

}
