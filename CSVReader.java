import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Double;

public class CSVReader {
	//array lists for Airports, Airlines, and Routes
	private static ArrayList<Airports> airportlist = new ArrayList<Airports>();
	private static ArrayList<Airlines> airlinelist = new ArrayList<Airlines>();
	private static ArrayList<Routes> routelist = new ArrayList<Routes>();
		
	//create array of airports
	public static void createAirport() {
		//instance variables
		String airportID;
		String airportName;
		String city;
		String country;
		String iataCode;
		String latitude;
		String longitude;
		String altitude;
		String timezone;
		String dst;
		String tz;
		String type;
		String sourceOfData;
		
		try {
			
	      File myAirport = new File("C:\\Users\\Paa Kwasi Kodua\\Documents\\eclipse_work\\ICPJavaIndividualProject2022\\src\\airports.csv");
	      Scanner myReader = new Scanner(myAirport);
	      int i = 0;
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] airport = data.split(",");
	        
	        airportID = airport[0];
			airportName = airport[1];
			city = airport[2];
			country = airport[3];
			iataCode = airport[4];
			latitude = airport[6];
			longitude = airport[7];
			altitude = airport[8];
			timezone = airport[9];
			dst = airport[10];
			tz = airport[11];
			type = airport[12];
			sourceOfData = airport[13];
			
	        try {
	        	Integer.parseInt(airportID);
	        	Double.parseDouble(latitude);
	        	Double.parseDouble(longitude);
	        	Double.parseDouble(altitude);
	        	Double.parseDouble(timezone);
	        }
	        //if there are extra commas
	        catch (NumberFormatException e) {
		      continue;
			}
			
			if (!iataCode.equals("\\N")) {
		        Airports airport1 = new Airports(Integer.parseInt(airportID), airportName, city, country, iataCode, Double.parseDouble(latitude),
		        		Double.parseDouble(longitude), Double.parseDouble(altitude), Double.parseDouble(timezone), dst, tz, type, sourceOfData);
				
		        //store each airport object in airportlist
		        airportlist.add(airport1);
		        //System.out.println(airport1.toString());
			}
	        //System.out.println(airportlist.toString());
	        i++;
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("File airports.csv not found in specified path.");
	      e.printStackTrace();
	    }
	}
	
	//create array of airlines
	public static void createAirline() {
		//instance variables
		String airlineID;
		String airlineName;
		String alias;
		String iataCode;
		String icaoCode;
		String callSign;
		String country;
		String active;
		
		try {
	      File myAirline = new File("C:\\Users\\Paa Kwasi Kodua\\Documents\\eclipse_work\\ICPJavaIndividualProject2022\\src\\airlines.csv");
	      Scanner myReader = new Scanner(myAirline);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] airline = data.split(",");
	        //Array airport = Arrays.toString(data.split(","));
	        
	        airlineID = airline[0];
			airlineName = airline[1];
			alias = airline[2];
			iataCode = airline[3];
			icaoCode = airline[4];
			callSign = airline[5];
			country = airline[6];
			active = airline[7];
	        
			//create airline object
	        Airlines airline1 = new Airlines(Integer.parseInt(airlineID), airlineName, alias, iataCode, icaoCode, callSign, country, active);
	        
	        //store each airline object in airlinelist
	        airlinelist.add(airline1);
	        System.out.println(airlinelist.toString());
	        //System.out.println(airline1.toString());
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("File airlines.csv not found in specified path.");
	      e.printStackTrace();
	    }

	}

	/**
	 * create array of routes
	 */
	public static void createRoute() {
		//instance variables
        String airlineCode;
        String airlineID;
    	String sourceAirportCode;
    	String sourceAirportID;
    	String destinationAirportCode;
    	String destinationAirportID;
    	String stops;
		
		try {
	      File myRoute = new File("C:\\Users\\Paa Kwasi Kodua\\Documents\\eclipse_work\\ICPJavaIndividualProject2022\\src\\routes.csv");
	      Scanner myReader = new Scanner(myRoute);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] route = data.split(",");
	        //Array airport = Arrays.toString(data.split(","));
	        
	        airlineCode = route[0];
	        airlineID = route[1];      
	    	sourceAirportCode = route[2];
	    	sourceAirportID = route[3];
	    	destinationAirportCode = route[4];
	    	destinationAirportID = route[5];
	    	stops = route[7];
	    	
	        try {
	        	Integer.parseInt(airlineID);
	        	Integer.parseInt(sourceAirportID);
	        	Integer.parseInt(destinationAirportID);
	        	Integer.parseInt(stops);
	        }
	        //if any ID is "\N"
	        catch (NumberFormatException e) {
			      //System.out.println("A non-number has been found.");
			      continue;
			}

	        //create route object
	        Routes route1 = new Routes(airlineCode, Integer.parseInt(airlineID), sourceAirportCode, Integer.parseInt(sourceAirportID), destinationAirportCode,
	        		Integer.parseInt(destinationAirportID), Integer.parseInt(stops));
	        
	        //store each route object in routelist
	        routelist.add(route1);
	        //System.out.println(routelist.toString());
	        //System.out.println(route1.toString());
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("File routes.csv not found in specified path.");
	      e.printStackTrace();
	    }
	}
	
	/**
	 * returns a route given sourceCity, sourceCountry, destinationCity, and destinationCountry
	 * @param sourceCity refers to the start city of the flight
	 * @param sourceCountry refers to the start country of the flight
	 * @param destinationCity refers to the destination city of the flight
	 * @param destinationCountry refers to the destination country of the flight
	 * @return finalRoute
	 */
	public static Routes createPathv1(String sourceCity, String sourceCountry, String destinationCity, String destinationCountry){
		Routes finalRoute = new Routes();
		
		for (Routes object1: routelist) {
			if (getAirportByCityCountry(sourceCity, sourceCountry).getAirportID() == object1.getSourceAirportID()
				&& getAirportByCityCountry(destinationCity, destinationCountry).getAirportID() == object1.getDestinationAirportID()){
				finalRoute = object1;
			}
		}
	
		return finalRoute;
	}

	
	/**
	 * returns an airport object given its city and country
	 * @param city refers to the city of the airport
	 * @param country refers to the country of the airport
	 * @return airportObject
	 */
	public static Airports getAirportByCityCountry(String city, String country) {
		Airports airportObject = new Airports();
		for (Airports object: airportlist) {
			if (city.equals(object.getCity()) && country.equals(object.getCountry())){
				airportObject = object;
			}
		}
		return airportObject;
	}
		
	/**
	 * returns a single Airports object given the airportID
	 * @param id refers to the ID of the airport
	 * @return airportObject
	 */
	public static Airports getAirportByID(int id) {
		Airports airportObject = new Airports();
		for (Airports object: airportlist) {
			if (id == object.getAirportID()){
				airportObject = object;
			}
		}
		return airportObject;
	}

	public static void main(String[] args) {
		createAirport();
		//createAirline();
		createRoute();
	
		//array list of String arrays of the file
		ArrayList<String[]> sourceDestination = new ArrayList<String[]>();
		
		try {
	      File startEnd = new File("C:\\Users\\Paa Kwasi Kodua\\Documents\\eclipse_work\\ICPJavaIndividualProject2022\\src\\accra-ouagadougou.txt");
	      Scanner myReader = new Scanner(startEnd);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] cityCountry = data.split(",");
	        sourceDestination.add(cityCountry);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("File not found in specified path.");
	      e.printStackTrace();
	    }
		
		//save source city and source country in startCityCountry
		String[] startCityCountry = sourceDestination.get(0);
		String startCity = startCityCountry[0].trim();
		String startCountry = startCityCountry[1].trim();
		
		//save destination city and destination country in destinationCityCountry
		String[] destinationCityCountry = sourceDestination.get(1);
		String destinationCity = destinationCityCountry[0].trim();
		String destinationCountry = destinationCityCountry[1].trim();
		
		Routes finalRoute = createPathv1(startCity,startCountry,destinationCity,destinationCountry);
		
		try {
	      FileWriter myWriter = new FileWriter("C:\\Users\\Paa Kwasi Kodua\\Documents\\eclipse_work\\ICPJavaIndividualProject2022\\src\\accra-ouagadougou_output.txt");
	      myWriter.write("1. " + finalRoute.getAirlineCode() + " from " + finalRoute.getSourceAirportCode() + " to " + finalRoute.getDestinationAirportCode() + "\n");
	      myWriter.write("Total flights: 1\n");
	      myWriter.write("Total additional stops: " + finalRoute.getStops() + "\n");
	      myWriter.write("Total distance: " + (int)finalRoute.getDistance() + "km" + "\n");
	      myWriter.write("Optimality criteria: flights");
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}

}
