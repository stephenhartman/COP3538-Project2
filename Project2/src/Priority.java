
/**
 * Implements priority queues of state objects using arrays for each individual region.  Has methods to check if full or empty
 * and to remove, insert, or display elements from each individual priority queue.
 * 
 * @author S Hartman
 * @version 2/26/17
 */
public class Priority {

	private State[] southQueue;
	private int southElem;
    private int southFront;
    private int southRear;
	
	private State[] westQueue;
	private int westElem;
    private int westFront;
    private int westRear;
	
	private State[] midwestQueue;
	private int midwestElem;
    private int midwestFront;
    private int midwestRear;
	
	private int maxSize = 50;
	
	/**
	 * Constructor method.  Builds the individual region queues and assigns front, element, and rear variables for counting.
	 */
	public Priority()
	{
		southQueue = new State[50];
		southElem = 0;
        southFront = 0;         
        southRear = -1;
		
		westQueue = new State[50];
		westElem = 0;
        westFront = 0;
        westRear = -1;
		
		midwestQueue = new State[50];
		midwestElem = 0;
        midwestFront = 0;
        midwestRear = -1;
    }
	
	/**
	 * Method to determine if the queue is empty.
	 * @return true if no elements in the queue
	 */
	private boolean isEmptySouth()
	{
		return (southElem == 0);
	}

	/**
	 * Method to determine if the queue is empty.
	 * @return true if no elements in the queue
	 */
	private boolean isEmptyWest()
	{
		return (westElem == 0);
	}
	
	/**
	 * Method to determine if the queue is empty.
	 * @return true if no elements in the queue
	 */
	private boolean isEmptyMidwest()
	{
		return (midwestElem == 0);
	}
	
	/**
	 * Method to determine if the queue is full.
	 * @return true if the number of elements = maximum size of array
	 */
	private boolean isFullSouth()
	{
		return (southElem == maxSize);
	}

	/**
	 * Method to determine if the queue is full.
	 * @return true if the number of elements = maximum size of array
	 */
	private boolean isFullWest()
	{
		return (westElem == maxSize);
	}

	/**
	 * Method to determine if the queue is full.
	 * @return true if the number of elements = maximum size of array
	 */
	private boolean isFullMidwest()
	{
		return (midwestElem == maxSize);
	}
	
	/**
	 * Insert method which checks if each individual queue is full and calls individual insert methods for each region's
	 * priority queue while keeping track of the rear of the queue.
	 * @param state object to insert into the queue from state stack
	 */
	public void insert(State state)
	{
		String region = state.getRegion();
		
		switch (region)
		{
		case "South":
			if (isFullSouth())
			{
				System.out.println("Priority Queue " + region + " is full.");
				break;
			}
			else
			{
				insertSouth(state);
                southRear++;
				break;
			}
		case "West":
			if (isFullWest())
			{
				System.out.println("Priority Queue " + region + " is full.");
				break;
			}
			else
			{
				insertWest(state);
                westRear++;
				break;
			}
		case "Midwest":
			if (isFullMidwest())
			{
				System.out.println("Priority Queue " + region + " is full.");
				break;
			}
			else
			{
				insertMidwest(state);
                midwestRear++;
				break;
			}
		}
	}

	/**
	 * Uses an insertion algorithm similar to insertion sort to prioritize the queue.  Comparison by population from the 
	 * state array getter.
	 * @param state from state stack array
	 */
	private void insertSouth(State state)
	{
		if (southElem == 0)
		{
			southQueue[southElem++] = state;
		}
		else
		{
			int i;	
            for (i = southElem - 1; i >= 0; i--)
			{
				if (state.getPopulation() > southQueue[i].getPopulation())
					southQueue[i+1] = southQueue[i];
				else
					break;
			}
			southQueue[i+1] = state;
            southElem++;
		}
	}
	
	/**
	 * Uses an insertion algorithm similar to insertion sort to prioritize the queue.  Comparison by population from the 
	 * state array getter.
	 * @param state from state stack array
	 */
	private void insertWest(State state)
	{
		if (westElem == 0)
		{
			westQueue[westElem++] = state;
		}
		else
		{
            int i;
			for (i = westElem - 1; i >= 0; i--)
			{
				if (state.getPopulation() > westQueue[i].getPopulation())
					westQueue[i+1] = westQueue[i];
				else
					break;
			}
			westQueue[i+1] = state;
            westElem++;
		}
	}
	
	/**
	 * Uses an insertion algorithm similar to insertion sort to prioritize the queue.  Comparison by population from the 
	 * state array getter.
	 * @param state from state stack array
	 */
	private void insertMidwest(State state)
	{
		if (midwestElem == 0)
		{
			midwestQueue[midwestElem++] = state;
		}
		else
		{
            int i;
			for (i = midwestElem - 1; i >= 0; i--)
			{
				if (state.getPopulation() > midwestQueue[i].getPopulation())
					midwestQueue[i+1] = midwestQueue[i];
				else
					break;
			}
			midwestQueue[i+1] = state;
            midwestElem++;
		}
	}
	
	/**
	 * Prints each priority queue after prioritization from insertion.  Gets each priority queue header and prints the
	 * state header from State class, then displays the state objects in the queues.
	 */
	protected void printQueue()
	{
		int south = 1;
		int west = 2;
		int midwest = 3;
		
		getPriorityHeader(south);
		System.out.println(State.getHeader());
		displaySouth();
		
		getPriorityHeader(west);
		System.out.println(State.getHeader());
		displayWest();
		
		getPriorityHeader(midwest);
		System.out.println(State.getHeader());
		displayMidwest();
	}
	
	/**
	 * Uses a switch statement to determine which priority queue header to print by region.
	 * @param type is the region code from printQueue()
	 */
	private void getPriorityHeader(int type)
	{
		switch (type)
		{
		case 1:
			System.out.println("\nSouth Priority Queue Contents:");
			break;
		case 2:
			System.out.println("\nWest Priority Queue Contents:");
			break;
		case 3:
			System.out.println("\nMidwest Priority Queue Contents:");
			break;
		}
	}
	
	/**
	 * Displays the south priority queue using a for loop and removes each state object during iteration
	 * by calling the remove() method.
	 */
	private void displaySouth()
	{
		for	(int i = 0; i < southElem; i++)
		{
			System.out.println(southQueue[i].toString());
			removeSouth();
		}
	}

	/**
	 * Displays the south priority queue using a for loop and removes each state object during iteration
	 * by calling the remove() method.
	 */
	private void displayWest()
	{
		for	(int i = 0; i < westElem; i++)
		{
			System.out.println(westQueue[i].toString());
			removeWest();
		}
	}

	/**
	 * Displays the south priority queue using a for loop and removes each state object during iteration
	 * by calling the remove() method.
	 */
	private void displayMidwest()
	{
		for	(int i = 0; i < midwestElem; i++)
		{
			System.out.println(midwestQueue[i].toString());
			removeMidwest();
		}
	}
	
	/**
	 * Pushes each state object from priority queue back onto the state stack.  Keeps track of the priority queue 
	 * using the Front counter.
	 * @return state object from priority queue array
	 */
	private State removeSouth() 
	{
		Project2.stateStack.push(southQueue[southFront++]);
		return southQueue[southElem];
	}

	/**
	 * Pushes each state object from priority queue back onto the state stack.  Keeps track of the priority queue 
	 * using the Front counter.
	 * @return state object from priority queue array
	 */
	private State removeWest() 
	{
		Project2.stateStack.push(westQueue[westFront++]);
		return westQueue[westElem];
	}

	/**
	 * Pushes each state object from priority queue back onto the state stack.  Keeps track of the priority queue 
	 * using the Front counter.
	 * @return state object from priority queue array
	 */
	private State removeMidwest() 
	{
		Project2.stateStack.push(midwestQueue[midwestFront++]);
		return midwestQueue[midwestElem];
	}
	
}
