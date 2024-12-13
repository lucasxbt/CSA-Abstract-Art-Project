# Unit 4 - Abstract Art Project

## Dataset

The dataset was made by ChatGPT

Players (String): Names of soccer players.
Goals (int): Total career goals scored by each player.
Assists (int): Total career assists made by each player.
Games (int): Total career games played by each player.


## UML Diagram
![Screenshot 2024-12-12 at 6 26 52 PM](https://github.com/user-attachments/assets/5a667161-2979-4d15-9d29-9b908c6d3d19)

## Video Demo
![Screenshot 2024-12-12 at 6 25 11 PM](https://github.com/user-attachments/assets/8c4c8ee4-9989-44e7-a7fe-263d0a5ac1a5)

[(youtube-URL-here)
](https://drive.google.com/file/d/19rhEz1l4KOoeOc5CLVoXyCQt3LKy9vNl/view?usp=sharing)
## Description

This project takes data about soccer players and turns it into a fun and creative visualization. The data is stored in lists (1D arrays) for player names, goals, assists, and games. The program uses if-else statements to figure out which players are “Experienced Players” (based on games played) and “Top Scorers” (based on goals scored). These categories affect how the players are shown on the screen.
The main method, drawScene, creates the visualization. Goals decide the x-position, assists decide the height (y-position), and games control the rotation of each player’s rectangle. The project uses math, like Math.sqrt, to calculate these positions and sizes. There’s also a circle to show the average number of goals, and its size and colors are random to make it look interesting.
Sound effects make it more fun—top scorers get high-pitched sounds, and other players get lower ones. The program uses random numbers to choose sounds and colors, keeping everything fresh and exciting.
