/**
 * 
 */
package athan.web;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Saad BENBOUZID
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public class Location {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	protected String cityName;

	@Persistent
	protected String regionName;

	@Persistent
	protected String countryName;

	@PersistenceCapable
	@EmbeddedOnly
	public static class Coordinate {

		@Persistent
		private double lat;

		@Persistent
		private double lng;

		public Coordinate() {}

		public Coordinate(double lat, double lng) {
			this.lat = lat;
			this.lng = lng;
		}

		public String toString() {
			String retour = "";

			retour += "Lat=[" + lat + "] - ";
			retour += "Long=[" + lng + "]";

			return retour;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLng() {
			return lng;
		}

		public void setLng(double lng) {
			this.lng = lng;
		}
	}

	/**
	 * Returns the gap of hour(s) for France Timezone / GMT, includin saving lights or not.
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static int getJdoHourGap(Date date) {
		return TimeZone.getTimeZone("France").inDaylightTime(date) ? 2 : 1;
	}

	@Persistent
	@Embedded
	protected Coordinate coordinates;

	public Location() {}

	public Location(String pCityName, String pRegionName, String pCountryName, Coordinate pCoordinates) {
		cityName = pCityName;
		regionName = pRegionName;
		countryName = pCountryName;
		coordinates = pCoordinates;
	}

	public Key getKey() {
		return key;
	}

	public String toString() {
		String retour = "\n";

		retour += "CityName=[" + cityName + "]\n";
		retour += "RegionName=[" + regionName + "]\n";
		retour += "CountryName=[" + countryName + "]\n";
		retour += "Coordinates=[" + coordinates.toString() + "]";

		return retour;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}

}
