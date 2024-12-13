import org.code.theater.*;
import org.code.media.*;
import java.util.*;

public class DataScene extends Scene {

    // Arrays to store player data
private String[] players;  
private int[] goals;     
private int[] assists;     
private int[] games;  

// Arrays for experienced players and top scorers
private String[] experiencedPlayers;  
private String[] topScorers;  
// Counters for categories
private int expID = 0;
private int topID = 0;

    // Colors and images for visualization
    private String[] colors = {"red", "purple", "orange"}; //possible colors for circle that represents average
    private String[] images = {"messi.jpeg", "ronaldo.jpg", "neymar.jpeg", "mbappe.jpg", "haaland.jpeg", "rashford.jpg", "casemiro.jpg", "son.jpg", "timo-werner.jpg"};

    /**
     * Constructor loads data and initializes arrays for categorization.
     */
    public DataScene() {
        players = FileReader.toStringArray("players.txt");
        goals = FileReader.toIntArray("goals.txt");
        assists = FileReader.toIntArray("assists.txt");
        games = FileReader.toIntArray("games.txt");

        experiencedPlayers = new String[players.length];
        topScorers = new String[players.length];
    }


    /**
     * Calculates the average goals of all players.
     */
    private double calcAverageGoals() {
        double count = 0;
        for (int go : goals) {
            count += go;
        }
        return count / players.length;
    }


  
    /**
     * Checks if a player is a top scorer.
     * Adds player to topScorers if true.
     */
    private boolean findTopScorers(int index) {
        int points = goals[index];
        if (points > 500 || (points > 200 && points > 50)) {
            topScorers[topID] = players[index];
            topID++;
            return true;
        }
        return false;
    }

    /**
     * Checks if a player is experienced.
     * Adds player to experiencedPlayers if true.
     */
    private boolean findExperience(int index) {
        int gamesPlayed = games[index];
        int points = goals[index];
        if (gamesPlayed > 900 || (gamesPlayed > 400 && points > 200)) {
            experiencedPlayers[expID] = players[index];
            expID++;
            return true;
        }
        return false;
    }

    /**
     * Calculates rotation based on games played.
     */
    private int setRotation(int index) {
        int gamesPlayed = (int) (Math.round(Math.pow(games[index], 0.5)) * 10);
        if (gamesPlayed > 290) {
            return 10;
        } else if (gamesPlayed > 250) {
            return 20;
        } else if (gamesPlayed > 200) {
            return 30;
        } else if (gamesPlayed > 100) {
            return 40;
        } else {
            return 45;
        }
    }





      /**
     * Main method to draw the scene.
     * Displays player information, highlights top scorers and experienced players,
     * and adds average goals visualization.
     */
    public void drawScene() {

        for (int i = 0; i < players.length; i++) {
            // Calculate position and size
            int x = (int) (10 * Math.round(Math.sqrt(goals[i])));
            int y = assists[i];
            int size = 40;
            if (findExperience(i)){
             size = 60; 
            }
            int rect_size = size + 20;

            // Set color and play sound based on player type
            setFillColor("yellow");
            if (findTopScorers(i)) {
                setFillColor("green");
                playNoteAndPause(80, 2);
            } else {
                playNoteAndPause(50, 1);
            }

            // Draw player rectangle and image
            drawRectangle(x, y, rect_size, rect_size);
            drawImage(images[i], x, y, size, setRotation(i));
        }

        // Draw average goals circle
        int avg_x = (int) (Math.round(Math.sqrt(calcAverageGoals())) * 10);
        int avg_y = (int) (Math.random() * 300 + 50);
        setFillColor(colors[(int) (Math.random() * 3)]);
        drawEllipse(avg_x, avg_y, 50, 50);
        System.out.println(calcAverageGoals());
        System.out.println(avg_x);
    }




  
}