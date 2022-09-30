
public class Routes {
	//instance variables
	private final String airlineCode;
	private final int airlineID;
	private final String sourceAirportCode;
	private final int sourceAirportID;
	private final String destinationAirportCode;
	private final int destinationAirportID;
	private final int stops;
	private double distance;
	
	/**
	 * constructor
	 * build and initialize objects of this class
	 * @param airlineCode refers to the code of the airline
	 * @param airlineID refers to the ID of the airline
	 * @param sourceAirportCode refers to the code of the source airport
	 * @param sourceAirportID refers to the ID of the source airport
	 * @param destinationAirportCode refers to the code of the destination airport
	 * @param destinationAirportID refers to the ID of the destination airport
	 * @param stops refers to the number of stops
	 */
	public Routes(String airlineCode, int airlineID, String sourceAirportCode, int sourceAirportID,
			String destinationAirportCode, int destinationAirportID, int stops) {
		super();
		this.airlineCode = airlineCode;
		this.airlineID = airlineID;
		this.sourceAirportCode = sourceAirportCode;
		this.sourceAirportID = sourceAirportID;
		this.destinationAirportCode = destinationAirportCode;
		this.destinationAirportID = destinationAirportID;
		this.stops = stops;
		this.distance = generateDistance(CSVReader.getAirportByID(sourceAirportID).getLatitude(), CSVReader.getAirportByID(sourceAirportID).getLongitude(),
				CSVReader.getAirportByID(destinationAirportID).getLatitude(), CSVReader.getAirportByID(destinationAirportID).getLongitude());;
	}
	
	public Routes() {
		this.airlineCode = "";
		this.airlineID = 0;
		this.sourceAirportCode = "";
		this.sourceAirportID = 0;
		this.destinationAirportCode = "";
		this.destinationAirportID = 0;
		this.stops = 0;
	}

	/**
	 * returns the code of the airline
	 * @return airlineCode
	 */
	public String getAirlineCode() {
		return airlineCode;
	}

	/**
	 * returns the ID of the airline
	 * @return airlineID
	 */
	public int getAirlineID() {
		return airlineID;
	}

	/**
	 * returns the code of the source airport
	 * @return sourceAirportCode
	 */
	public String getSourceAirportCode() {
		return sourceAirportCode;
	}

	/**
	 * returns the ID of the source airport
	 * @return sourceAirportID
	 */
	public int getSourceAirportID() {
		return sourceAirportID;
	}

	/**
	 * returns the code of the destination airport
	 * @return destinationAirportCode
	 */
	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	/**
	 * returns the ID of the destination airport
	 * @return destinationAirportID
	 */
	public int getDestinationAirportID() {
		return destinationAirportID;
	}

	/**
	 * returns the number of stops
	 * @return stops
	 */
	public int getStops() {
		return stops;
	}
	
	/**
	 * haversine formula
	 * returns the distance using latitude and longitude
	 */
	public double generateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		// distance between latitudes and longitudes
        double dLat = Math.toRadians(latitude2 - latitude1);
        double dLon = Math.toRadians(longitude2 - longitude1);
 
        // convert to radians
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);
 
        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(latitude1) *
                   Math.cos(latitude2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
	}

	/**
	 * returns the distance between source airport and destination airport
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}
	
	@Override
	public String toString() {
		return "Routes [airlineCode=" + airlineCode + ", airlineID=" + airlineID + ", sourceAirportCode="
				+ sourceAirportCode + ", sourceAirportID=" + sourceAirportID + ", destinationAirportCode="
				+ destinationAirportCode + ", destinationAirportID=" + destinationAirportID
				+ ", stops=" + stops + ", haversine=" + distance + "]";
	}
}
