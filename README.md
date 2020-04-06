# cse237-project

Group: Kanban Board
Haewon Shin, Raeka Attari, Elijah Olasunkanmi, Shruthi Ramalingam

What user stories were completed this iteration?

A developer/student should be able to create a blank kanban board with labels for each of the columns.
A developer/student should be able to add a task to the board so that they can keep track of what stage a task currently is at.
A developer/student should be able to remove a task from the board so that its absence is an indicator that the task has moved in progress from that position (either promoted or demoted).
A developer/student should be able to add/delete tasks to the board with labels so that they can visualize the number of tasks in a given column at a given time.

What user stories do you intend to complete next iteration?

A developer/student should be able to add comments to each task so they can update their tasks with useful information 
A developer/student should be able to view the timestamps of when a task was created/deleted so they can keep track of a the life cycle of each task
A developer/student should be able to assign users for each task when they add/delete so that they can keep track of which tasks belong to which person or team

Is there anything that you implemented but doesn't currently work?

There are certain variables that currently need to be closed (a few memory leaks) that we need to either SuppressWarnings to or fix in a different way
The display method could be improved upon to show the tasks and the columns in a more traditional format

What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)

Currently our code can be run directly from the command line, and we plan to make our program more user friendly in a later iteration. 
javac Board.java //compile
java Board
The program should prompt the user for adding and deleting tasks.
