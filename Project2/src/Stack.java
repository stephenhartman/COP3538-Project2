
/**
 * Implements a stack of state objects with an array.  Provides methods for push (insert) onto State stack, pop (remove) from
 * State stack, printStack to display the stack of State objects, and boolean methods isEmpty and isFull to indicate whether
 * or not the stack is full or empty.
 *   
 * @author Stephen Hartman
 * @version 2/26/17
 *
 */
public class Stack 
{
	protected State[] stateStack;
	protected Priority statePriority = new Priority();
	protected int stackElem;
	private int top;
	private int maxSize = 50;
    private int popped = 0;
	
	/**
	 * Constructor to create new array of state objects and set top and the number of elements for the stack.
	 */
	public Stack()
	{
		stateStack = new State[50];
		top = -1;
		stackElem = 0;
                
	}
	
	/**
	 * Push method to insert state objects into the stack.  Compares region by calling getRegion() from State class
	 * in order to determine proper state objects to add.  Keeps track of the number of elements and the top of the stack.
	 * @param state object from input file or priority queues
	 */
	public void push(State state)
	{
		if(isFull())
            System.out.println("Stack is full. " + state + " not inserted.");
		else if (state.getRegion().compareTo("South") == 0 || state.getRegion().compareTo("West") == 0 || state.getRegion().compareTo("Midwest") == 0 )
		{
			stateStack[stackElem++] = state;
			++top;
		}
	}
	
	/**
	 * Pop method to remove state objects from stack.  Checks if the array is empty while popping state objects.
	 * @return null value if the stack is empty or state objects if there are states in the stack
	 */
	public State pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
			return null;
		}
		else
		{
			stackElem--;
			return stateStack[top--];
                        
		}
	}
	
	/**
	 * Checks if the stack is empty by comparison of the number of elements in the stack array
	 * @return true if the stack array is empty
	 */
	public boolean isEmpty()
	{
		return (stackElem == 0);
	}
	
	/**
	 * Checks if the stack is full by comparison of the number of elements and the maximum size of stack array
	 * @return true if the stack has the maximum number of elements for stack array declared
	 */
	public boolean isFull()
	{
		return (stackElem == maxSize);
	}
	
	/**
	 * Prints the state header and the the stack array using a while loop.  Simultaneously prints each state object 
	 * and inserts onto the Priority object while popping from the state stack.  popped integer keeps track
         * of whether or not stack was popped in order to determine whether or not to add
         * elements to the priority queues.
	 */
	public void printStack()
	{
		System.out.println("\nStack Contents:");
		System.out.println(State.getHeader());
		
        if (popped == 0)
        {
        	while (top >= 0)
        	{
        		System.out.println(stateStack[top].toString());
        		statePriority.insert(pop());
        	}
            popped = 1;
        }
        while (top >= 0)
        {
        	System.out.println(pop());
        }
	}
}
