#!/bin/bash
cd src/kanban
javac -cp ../ Board.java
javac -cp ../ Menu.java
cd ..
java kanban/Board
cd ../../
