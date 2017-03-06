import java.text.NumberFormat;

/**
 * Stores State information from input .csv file.  Gets and sets stateData fed 
 * in from Project1 class.  Includes proper String formatting and String to 
 * integer conversion from stateData.  Add method for adding State objects to State[].
 * Print method for printing individual state data from search algorithm, along with a 
 * comparison method for comparing state names from Project1.
 * 
 * @author Stephen Hartman
 * @version 2/26/17
 */
public class State
{
    private final String ROW = "%-16s%-16s%-12s%-12s%-17s%-16s";     //Row format for printing

    private String state;
    private String city;
    private String stateAbbreviation;
    private String population;
    private String region;
    private String houseSeats;
    
    /**
     * Constructor to set the data for state array
     * @param stateData State element from array
     */
    public State(String[] stateData)
    {
        state = stateData[0];
        city = stateData[1];
        stateAbbreviation = stateData[2];
        population = stateData[3];
        region = stateData[4];
        houseSeats = stateData[5];
    }

    /**
     * Header format for output
     * @return the proper string format for the header
     */
    public static String getHeader() 
    {
        return String.format("\n%-16s%-16s%-12s%-12s%-17s%-16s\n%-16s%-16s%-12s%-12s%-17s%-16s",
                "    State", "    Capital", "State Abbr", "Population", "     Region", "US House Seats",
                "--------------", "--------------", "----------", "-----------", "---------------", "--------------");
    }
    
    /**
     * State name get method
     * @return name of the state from State object
     */
    public String getState() 
    {
        return state;
    }

     /**
     * Capital city get method
     * @return name of the capital city from State object
     */
    public String getCity() 
    {
        return city;
    }

    /**
     * State Abbreviation get method
     * @return state abbreviation from State object
     */
    public String getStateAbbreviation() 
    {
        return stateAbbreviation;
    }

    /**
     * State population get method, converts String to int
     * @return state population integer from State object
     */
    public int getPopulation() 
    {
        
        int popToInt = Integer.parseInt(population);
        return popToInt;
    }
    
    /**
     * Region get method
     * @return corresponding region from State object
     */
    public String getRegion() 
    {
        return region;
    }

    /**
     * Number of House seats get method, converts String to int
     * @return house seats integer from State object
     */
    public int getHouseSeats()
    {
    	int houseToInt = Integer.parseInt(houseSeats);
        return houseToInt;
    }
  
    /**
     * Overrides the Object.toString() method to conform with integers in population and houseSeats
     * Includes ROW constant formatting
     * @return formatted string from ArrayList
     */
    @Override
    public String toString() 
    {
        return String.format(ROW, state, city, stateAbbreviation, NumberFormat.getInstance().format(getPopulation()), region, getHouseSeats());
    }
}
