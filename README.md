# cse237-project

Group: Kanban Board
Haewon Shin, Raeka Attari, Elijah Olasunkanmi, Shruthi Ramalingam

What user stories were completed this iteration?<br/>
A developer/student should be able to optionally sort tasks by alphabetical order when viewing the board.<br/>
A developer/student should be able to view a notification on the console for successful:<br/>
	addition,<br/>
	deletion, and<br/>
	moving<br/>
	of a task.

Besides the nominal user stories completed this iteration, we have drastically changed the appearance and the cleanliness of the methods and classes.<br/>
	We have added another class to avoid the usage of static methods, and the methods have been shortened such that each method generally only accomplishes a single task.<br/>
	We have also separated the Scanner for user input and isolated it away from the methods.<br/>
	Additionally, we have added tests to ensure a fuller coverage than the previous iteration.<br/>


Is there anything that you implemented but doesn't currently work?<br/>
No functionality is completely hindered, but the current Kanban board is unable to distinguish between tasks with exactly the same name, in the context of deletion.<br/>
	The board will delete both tasks if they have the same name in the same board, for example.<br/>
The user input system we used (a Scanner) also demonstrates a memory leak, although we have greatly reduced incidences of leaks by using only one Scanner per class and separating them from the methods.

What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)<br/>
There is a script called boardScript.sh in the main project folder (project-kanban_237project). Running the script in the terminal (./boardScript.sh) should allow the user to access the program from the terminal from the master branch.

