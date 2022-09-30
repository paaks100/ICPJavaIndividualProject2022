
public class Airports {
	
	//instance variables
	private final int airportID;
	private final String airportName;
	private final String city;
	private final String country;
	private final String iataCode;
	private final double latitude;
	private final double longitude;
	private final double altitude;
	private final double timezone;
	private final String dst;
	private final String tz;
	private final String type;
	private final String sourceOfData;
	
	
	/**
	 * constructor
	 * build and initialize objects of this class
	 * @param airportID refers to the ID of the airport
	 * @param airportName refers to the name of the airport
	 * @param city refers to the city of the airport
	 * @param country refers to the country of the airport
	 * @param iataCode refers to the IATA code of the airport
	 * @param latitude refers to the latitude of the airport
	 * @param longitude refers to the longitude of the airport
	 * @param altitude refers to the altitude of the airport
	 * @param timezone refers to the time zone of the airport
	 * @param dst refers to the daylight savings time of the airport
	 * @param tz refers to the Tz database timezone of the airport
	 * @param type refers to the type of airport
	 * @param sourceOfData refers to the source of the data
	 */
	public Airports(int airportID, String airportName, String city, String country, String iataCode,
			double latitude, double longitude, double altitude, double timezone, String dst, String tz, String type,
			String sourceOfData) {
		super();
		this.airportID = airportID;
		this.airportName = airportName;
		this.city = city;
		this.country = country;
		this.iataCode = iataCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.timezone = timezone;
		this.dst = dst;
		this.tz = tz;
		this.type = type;
		this.sourceOfData = sourceOfData;
	}
	
	public Airports() {
		this.airportID = 0;
		this.airportName = "";
		this.city = "";
		this.country = "";
		this.iataCode = "";
		this.latitude = 0;
		this.longitude = 0;
		this.altitude = 0;
		this.timezone = 0;
		this.dst = "";
		this.tz = "";
		this.type = "";
		this.sourceOfData = "";}
	
	/**
	 * returns the ID of the airport
	 * @return airportID
	 */
	public int getAirportID() {
		return airportID;
	}


	/**
	 * returns the name of the airport
	 * @return airportName
	 */
	public String getAirportName() {
		return airportName;
	}


	/**
	 * returns the city of the airport
	 * @return city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * returns the country of the airport
	 * @return country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * returns the IATA code of the airport
	 * @return iataCode
	 */
	public String getIATACode() {
		return iataCode;
	}

	/**
	 * returns the latitude of the airport
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}


	/**
	 * returns the longitude of the airport
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}


	/**
	 * returns the altitude of the airport
	 * @return altitude
	 */
	public double getAltitude() {
		return altitude;
	}


	/**
	 * returns the time zone of the airport
	 * @return timezone
	 */
	public double getTimezone() {
		return timezone;
	}


	/**
	 * returns the daylight savings time of the airport
	 * @return dst
	 */
	public String getDST() {
		return dst;
	}


	/**
	 * returns the Tz database timezone of the airport
	 * @return tz
	 */
	public String getTZ() {
		return tz;
	}


	/**
	 * returns the type of airport
	 * @return type
	 */
	public String getType() {
		return type;
	}


	/**
	 * returns the source of the data
	 * @return sourceOfData
	 */
	public String getSourceOfData() {
		return sourceOfData;
	}

	@Override
	public String toString() {
		return "Airports [airportID=" + airportID + ", airportName=" + airportName + ", city=" + city + ", country="
				+ country + ", iataCode=" + iataCode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", altitude=" + altitude + ", timezone=" + timezone + ", dst=" + dst
				+ ", tz=" + tz + ", type=" + type + ", sourceOfData=" + sourceOfData + "]";
	}

}
