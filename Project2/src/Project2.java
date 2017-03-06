import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * COP 3538: Project 2 - Stacks and Priority Queues
 * <p>
 * Project 2 class to execute the main method for the program.  Creates an input stream and pushes state objects into the
 * state stack.  Input stream is read by BufferedReader which parses states by region.  Calls methods from Stack to print
 * the stack, then Priority method to print priority queues, then prints the stacks once more. 
 * 
 * @author Stephen Hartman
 * @version 2/26/17
 */
public class Project2 
{

    private static Scanner input = new Scanner(System.in);
    private static String filename;                         //readFile() filename string 
    public static Stack stateStack = new Stack();

    
    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        execute();
    }

    /**
     * Kicks off the program by providing a project header and user input call for
     * fileInput method, then executes Stack and Priority methods to print.
     */
    private static void execute()
    {
    	
    	System.out.println("COP3538 Project 2\nInstructor: Xudong Liu\nStudent: "
        		+ "Stephen Hartman\n\nStacks and Priority Queues");
        System.out.print("Enter the filename: ");
        filename = input.next();
        filename = filename.trim();	//discards white space from input
        System.out.println();
        input.nextLine();			//discards \n from input stream
        readFile(filename);
        stateStack.printStack();
        stateStack.statePriority.printQueue();
        stateStack.printStack();
    }
    
    /**
     * Reads the filename from input using a BufferedReader and FileReader object,
     * along with exception handling for incorrect user input.
     * @param fileName fileName from input stream
     */
    private static void readFile(String fileName)
    {
        String line;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileName));) 
        {

            br.readLine();      //skip the header line
            while((line = br.readLine()) != null) 
            {
            	stateStack.push(new State(line.split(",")));  //line.split delimits by comma
            }
            br.close();
            System.out.println("There were " + stateStack.stackElem + " state records read.");
        }
        catch(FileNotFoundException fnfe) 
        {
            System.out.format("The program could not find the file: %s.\n\n", fileName);
            execute();
        }
        catch(IOException ioe) 
        {
            System.out.format("An error occurred while reading the file: %s.\n\n", fileName);
            execute();
        }
        catch(Exception ex) 
        {
            System.out.println("An unexpected error occurred.\n\n");
            execute();
        }
    }
}
