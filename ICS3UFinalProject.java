// written by Elorie Bernard-Lacroix September 2021
import java.io.*;

public class ICS3UFinalProject 
{//begin class

		// global variables
		static BufferedReader menu = new BufferedReader(new InputStreamReader(System.in));
		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		static int choice;
		static int numCards;
		static String cueCards[][] = new String[100][3];
		
		public static void main(String[] args) throws IOException
		{//begin main
			
			do
			{ //Begin do/while
					
				//Menu
				System.out.println("\n//======================== Main Menu ==========================\\\\");
				System.out.println("1. Enter Cue Cards / Add Cue Cards");
				System.out.println("2. Modify a Cue Card");
				System.out.println("3. Delete a Cue Card");
				System.out.println("4. Sort or Randomize Cue Cards");
				System.out.println("5. Show all Cue Cards");
				System.out.println("6. Test out Cue Cards");
				System.out.println("7. Save Cue Cards");
				System.out.println("8. Load Cue Cards");
				System.out.println("9. Exit");
				
				System.out.println("\nWhat is your choice?");
				try
				{
					choice = Integer.valueOf(menu.readLine()).intValue();
						
					if(choice == 1)
					{//begin if
						System.out.println("//=============================================================\\\\");
						enterCard();
					}//end if
					
					if(choice == 2)
					{//begin if
						System.out.println("//=============================================================\\\\");
						modifyCard();
					}//end if
					
					if(choice == 3)
					{//begin if
						System.out.println("//=============================================================\\\\");
						deleteCard();
					}//end if
					
					if(choice == 4)
					{//begin if
						System.out.println("//=============================================================\\\\");
						sortCards();
					}//end if
					
					if(choice == 5)
					{//begin if
						System.out.println("//=============================================================\\\\");
						displayCards();
					}//end if
					
					if(choice == 6)
					{//begin if
						System.out.println("//=============================================================\\\\");
						testCards();
					}//end if
					
					if(choice == 7)
					{//begin if
						System.out.println("//=============================================================\\\\");
						saveCards();
					}//end if
					
					if(choice == 8)
					{//begin if
						System.out.println("//=============================================================\\\\");
						loadCards();
					}//end if
					
					if(choice < 1 || choice > 9)
					{//begin else
						System.out.println("Please enter an integer value between 1 and 9 (inclusive).");
					}//end else
	
				}//end try
				
				catch(NumberFormatException e)
				{//start catch
					System.out.println("Please enter an integer value between 1 and 9 (inclusive).");
				}//end catch
			} while (choice != 9); //End do/while
			
		}//end main
		
		
		public static void enterCard() throws IOException
		{//begin enterCard
			do
			{//begin do-while
				System.out.println("Number of Cards: " + numCards);
				
				System.out.print("Term: ");
				cueCards[numCards][0] = (in.readLine()).trim();
				System.out.print("Definition: ");
				cueCards[numCards][1] = in.readLine();
				System.out.print("Category: ");
				cueCards[numCards][2] = in.readLine();
				
				numCards++;
				
				System.out.println("\nTo quit entering information type \"quit\" or enter to continue.");

			} while((in.readLine().compareTo("quit")) != 0); //end do-while
		}//end enterCard
		
		public static void modifyCard() throws IOException
		{//begin modifyCard
			
			//declaring variables
			String search;
			int flag=0, counter;
			boolean found = false;
			
			System.out.println("What term would you like to modify? (Use the term to search.)");
			search = in.readLine();
			
			//searching
			for(counter = 0; counter < numCards; counter++)
			{//begin for
				if(search.compareTo(cueCards[counter][0])==0)
				{//begin if
					flag = counter;
					found = true;
				}//end if
			}//end for
			
			if(found == false)
			{
				System.out.println("Term not Found");
			}//end if
			else
			{//begin else
				System.out.println(search + " found in array position " + flag);
				
				//modifying
				System.out.println("~~~~~~~~~~~~ please enter the new information ~~~~~~~~~~~~");
				System.out.print("Term: ");
				cueCards[flag][0] = in.readLine();
				System.out.print("Definition: ");
				cueCards[flag][1] = in.readLine();
				System.out.print("Category: ");
				cueCards[flag][2] = in.readLine();
			}//end else
			
		}//end modifyCard
		
		public static void deleteCard() throws IOException
		{//begin deleteCard
			
			//declaring variables
			String search;
			int flag=0, counter;
			boolean found = false;
			
			System.out.println("What cue card would you like to delete? (Use the term to search.)");
			search = in.readLine();
			
			//searching
			for(counter = 0; counter < numCards; counter++)
			{//begin for
				if(search.compareTo(cueCards[counter][0])==0)
				{//begin if
					flag = counter;
					found = true;
				}//end if
			}//end for
			
			if(found == false)
			{
				System.out.println("Term not Found");
			}//end if
			else
			{//begin else
				
				for(counter = flag; counter < numCards-1; counter++)
				{//begin for
					cueCards[counter][0] = cueCards[counter+1][0];
					cueCards[counter][1] = cueCards[counter+1][1];
					cueCards[counter][2] = cueCards[counter+1][2];
				}//end for
				
				//updating number of cards
				numCards = numCards-1;
				
				System.out.println("The item has been deleted.");
				
			}//end else
		}//end deleteCard
		
		public static void sortCards() throws IOException
		{//begin sortCards
			
			//declaring variables
			int sort, counter;
			String temp[][] = new String[1][3];
			
			//displaying menu
			System.out.println("Sort by:");
			System.out.println("1. term");
			System.out.println("2. category");
			System.out.println("3. randomize");
			
			try
			{//begin try
				sort = Integer.valueOf(in.readLine()).intValue();
				
				if(sort == 1) 
				{//sorting by term
					for(counter = 0; counter < numCards; counter++)
					{//begin for
						for(int counter2 = 0; counter2 < (numCards - 1) - counter; counter2++)
						{//begin for
							if(cueCards[counter2+1][0].compareTo(cueCards[counter2][0]) < 0)
							{//begin if
								
								temp[0] = cueCards[counter2];
								cueCards[counter2] = cueCards[counter2+1];
								cueCards[counter2+1] = temp[0];
								
							}//end if
						}//end for
					}//end for
				}//end if
				
				if(sort == 2)
				{//sorting by category
					for(counter = 0; counter < numCards; counter++)
					{//begin for
						for(int counter2 = 0; counter2 < (numCards - 1) - counter; counter2++)
						{//begin for
							if(cueCards[counter2+1][2].compareTo(cueCards[counter2][2]) < 0)
							{//begin if
								
								temp[0] = cueCards[counter2];
								cueCards[counter2] = cueCards[counter2+1];
								cueCards[counter2+1] = temp[0];
								
							}//end if
						}//end for
					}//end for
				}//end if
				
				if(sort == 3)
				{//sorting by category
					
					for(counter = 0; counter < numCards; counter++)
					{//begin for
						for(int counter2 = 0; counter2 < (numCards - 1) - counter; counter2++)
						{//begin for
							int random1 =(int) (Math.round(Math.random()*10)+1);
							int random2 =(int) (Math.round(Math.random()*10)+1);
							if(random1 < random2)
							{//begin if
								
								temp[0] = cueCards[counter2];
								cueCards[counter2] = cueCards[counter2+1];
								cueCards[counter2+1] = temp[0];
								
							}//end if
						}//end for
					}//end for
				}//end if
				if(sort < 1 || sort > 3)
				{//catching erroneous input
					System.out.println("Please enter an integer value between 1 and 3 (inclusive).");
				}//end if
				
			}//end try
			
			catch(NumberFormatException e)
			{//start catch
				System.out.println("Please enter an integer value between 1 and 3 (inclusive).");
			}//end catch
	
		}//end sortShow
		
		
		public static void displayCards()
		{//begin displayShow
		int counter;
			for(counter = 0; counter < numCards; counter++)
			{//begin for
				System.out.println(counter+1 + ". " + cueCards[counter][0] + ": " + cueCards[counter][1] + " [ " + cueCards[counter][2] + " ] ");
			}//end for
		}//end displayShow
		
		public static void testCards() throws IOException
		{//begin testCards
			
			//declaring variables
			int counter;
			String answer;
			
			//output variables
			PrintWriter masteredCards = new PrintWriter(new FileWriter("masteredCards.txt"));
			PrintWriter failedCards = new PrintWriter(new FileWriter("failedCards.txt"));
			
			for(counter = 0; counter < numCards; counter++)
			{//begin for
				
				//testing user
				System.out.println("Definition: " + cueCards[counter][1]);
				System.out.println("Corresponding term: ");
				answer = (in.readLine()).trim();
				
				//if correct
				if (answer.equalsIgnoreCase(cueCards[counter][0])) 
				{//begin if
					System.out.println("Correct! This term has been added to your mastered cards.");
					masteredCards.println(cueCards[counter][0]);
					masteredCards.println(cueCards[counter][1]);
					masteredCards.println(cueCards[counter][2]);
				}//end if
				
				//if incorrect
				else
				{//begin else
					System.out.println("That is incorrect. The correct term was: " + cueCards[counter][0]);
					System.out.println("Would you like to override this and say you were correct? (yes/no)");
					String override = in.readLine();
					if(override.compareTo("yes") == 0)
					{//start if
						masteredCards.println(cueCards[counter][0]);
						masteredCards.println(cueCards[counter][1]);
						masteredCards.println(cueCards[counter][2]);
						System.out.println("This term has been saved to your mastered cards.");
					}//end if
					else
					{//begin else
						failedCards.println(cueCards[counter][0]);
						failedCards.println(cueCards[counter][1]);
						failedCards.println(cueCards[counter][2]);
						System.out.println("This term has been saved to your failed cards.");
					}//end else
				}//end else
				
			}//end for
			
			masteredCards.close();
			failedCards.close();
			
		}//end testCards
		
		public static void saveCards() throws IOException
		{//begin saveShow
			
			//declaring variables
			PrintWriter savedCards;
			savedCards = new PrintWriter(new FileWriter("savedCards.txt"));
			int counter;
		
			//writing the file
			savedCards.println(numCards);
			for(counter = 0; counter < numCards; counter ++)
			{//begin for
				savedCards.println(cueCards[counter][0]);
				savedCards.println(cueCards[counter][1]);
				savedCards.println(cueCards[counter][2]);
			}//end for
			System.out.println("All cards have been saved.");
			savedCards.close();	
			
		}//end saveShow
		
		public static void loadCards() throws IOException
		{//begin loadShow

			//declaring variables
			int counter;			
			int inputChoice;
		
			//displaying menu
			System.out.println("Which cards would you like to load?");
			System.out.println("1. saved cards");
			System.out.println("2. mastered cards");
			System.out.println("3. failed cards");
			
			try
			{//begin try
				inputChoice = Integer.valueOf(in.readLine()).intValue();
				
				if(inputChoice == 1) //input from saved cards
				{//begin if
					
					//input variables
					BufferedReader input;
					input = new BufferedReader(new FileReader("savedCards.txt"));
					
					//starts reading
					numCards = Integer.valueOf(input.readLine()).intValue();
					System.out.println("Loading " + numCards + " cards");
					
					for(counter = 0; counter <= (numCards-1); counter++)
					{//begin for
						//reading in the data
						cueCards[counter][0] = input.readLine();
						cueCards[counter][1] = input.readLine();
						cueCards[counter][2] = input.readLine();
					}//end for
					input.close();
					System.out.println("Your saved cards have been loaded.");
					
				}//end if
				
				if(inputChoice == 2) //input from mastered cards
				{//begin if
					
					//input variables
					BufferedReader input;
					input = new BufferedReader(new FileReader("masteredCards.txt"));
					
					numCards = 0;
					
					//starts reading
					String line = input.readLine();
					
					while(line != null)
					{//begin while
						//reading & storing the data
						cueCards[numCards][0] = line;
						cueCards[numCards][1] = input.readLine();
						cueCards[numCards][2] = input.readLine();
						numCards++;
						line = input.readLine();
					}//end while
					input.close();
					System.out.println("Your mastered cards have been loaded.");
				}//end if
				
				if(inputChoice == 3) //input from failed cards
				{//begin if
					
					//input variables
					BufferedReader input;
					input = new BufferedReader(new FileReader("failedCards.txt"));
					
					numCards = 0;
					
					//starts reading
					String line = input.readLine();
					
					while(line != null)
					{//begin while
						//reading & storing the data
						cueCards[numCards][0] = line;
						cueCards[numCards][1] = input.readLine();
						cueCards[numCards][2] = input.readLine();
						numCards++;
						line = input.readLine();
					}//end while
					input.close();
					System.out.println("Your failed cards have been loaded.");
					
				}//end if
				
				if(inputChoice < 0 || inputChoice > 3)
				{//begin else
					System.out.println("Please enter an integer value between 1 and 3 (inclusive).");
				}//end else
			}//end try
			
			catch(NumberFormatException e)
			{//start catch
				System.out.println("Please enter an integer value between 1 and 3 (inclusive).");
			}//end catch
			
		}//end loadShow
	
}//end class