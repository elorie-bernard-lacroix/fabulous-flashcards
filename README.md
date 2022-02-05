# fabulous-flashcards


### Dates & Times (including what functionalities I got to work and what I couldn't achieve on each day)
August 26th @ 5:00 pm - 6:30 pm
- Problem Definition

August 26th @ 9:00 pm - 10:00 pm 
- Data Flow Diagram

August 28th @ 10:00 pm - 10:30 pm 
- Editing & Reviewing Data Flow Diagram

August 30th @ 12:00 pm - 1:00 pm 
- pseudo code and methods (analysis)

August 30th @ 8:30 pm - 9:30 pm
- The user can now enter or add data `enterCard()`.
- The user can now modify data `modifyCard()`.
- The user can now delete cards from the array `deleteCard()`.
- The user can sort the cards by term or by category `sortCards()`. 
- I tried to randomize them but the current algorithm I used doesn't seem to work.

August 31st @ 10:00 pm - 12:00 am
- The user can display all of the cards in the current array (in their current order) `displayCards()`.
- The user can test themselves on their definitions however this can only be done one way: by typing in the corresponding term (not the definition)
	The correct terms and incorrect terms can be loaded after, so that the user can target certain terms in particular `testCards()`.
- The user can save their cards at any time, so they can access the same cards later `saveCards()`.
- The user can load cards from the saved card file, the master cards or the failed cards, giving them the ability to choose exactly what terms they would like to practice `loadCards()`.
- main method is complete

August 31st @ 6:30 pm - 7:30 pm
- Testing the program. 
- I fixed some format with the output and some wordring in a few places.
- I had some trouble with loading the failed cards and mastered cards because they didn't have the number of cards at the beginning of the file, but after trying a couple different lines of code, I found one that works.
- Took screenshots of the program working.

------------------------------------------------------------------------

### Functionalities of the program:
- The user can enter or add data.
- The user can modify data.
- The user can delete cards from the array.
- The user can sort the cards by term, by category, or randomize them.
- The user can display all of the cards in the current array (in their current order).
- The user can test themselves on their definitions however this can only be done one way: by typing in the corresponding term (not the definition)
	The correct terms and incorrect terms can be loaded after, so that the user can target certain terms in particular.
- The user can save their cards at any time, so they can access the same cards later.
- The user can load cards from the saved card file, the master cards or the failed cards, giving them the ability to choose exactly what terms they would like to practice.

-------------------------------------------------------------------------

### Testing & Possible Additions:
- menu options (added an else statement to catch as many user inputs as possible)
	- same thing for the sorting and loading options
- give the user an option to override?
- give the user the option to only test a certain category?
- trimmed the input and testing parts, ignores lower case during testing
