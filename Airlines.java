
public class Airlines {
	
	//instance variables
	private final int airlineID;
	private final String airlineName;
	private final String alias;
	private final String iataCode;
	private final String icaoCode;
	private final String callSign;
	private final String country;
	private final String active;
	
	
	/**
	 * constructor
	 * build and initialize objects of this class
	 * @param airlineID refers to the ID of the airline
	 * @param airlineName refers to the name of the airline
	 * @param alias refers to the alias of the airline
	 * @param iataCode refers to the IATA code of the airline
	 * @param icaoCode refers to the ICAO code of the airline
	 * @param callSign refers to the call sign of the airline
	 * @param country refers to the country of the airline
	 * @param active refers to whether the airline is still active
	 */
	public Airlines(int airlineID, String airlineName, String alias, String iataCode, String icaoCode, String callSign,
			String country, String active) {
		super();
		this.airlineID = airlineID;
		this.airlineName = airlineName;
		this.alias = alias;
		this.iataCode = iataCode;
		this.icaoCode = icaoCode;
		this.callSign = callSign;
		this.country = country;
		this.active = active;
	}

	/**
	 * returns the ID of the airline
	 * @return airlineID
	 */
	public int getAirlineID() {
		return airlineID;
	}

	/**
	 * returns the name of the airline
	 * @return airlineName
	 */
	public String getAirlineName() {
		return airlineName;
	}

	/**
	 * returns the alias of the airline
	 * @return alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * returns the IATA code of the airline
	 * @return iataCode
	 */
	public String getIataCode() {
		return iataCode;
	}

	/**
	 * returns the ICAO code of the airline
	 * @return icaoCode
	 */
	public String getIcaoCode() {
		return icaoCode;
	}

	/**
	 * returns the call sign of the airline
	 * @return callSign
	 */
	public String getCallSign() {
		return callSign;
	}

	/**
	 * returns the country of the airline
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * returns whether the airline is still active
	 * @return active
	 */
	public String getActive() {
		return active;
	}
	
	@Override
	public String toString() {
		return "Airlines [airlineID=" + airlineID + ", airlineName=" + airlineName + ", alias=" + alias + ", iataCode="
				+ iataCode + ", icaoCode=" + icaoCode + ", callSign=" + callSign + ", country=" + country + ", active="
				+ active + "]";
	}
}
