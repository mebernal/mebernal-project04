package queues;

import cs1c.SongEntry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Class Jukebox manages three objects of type Queue String. The constructor reads the file
 * with the users request for what song to add to which playlist.
 *
 * @author Foothill College, Michael Bernal
 */
public class Jukebox
{
    /**
     * class attributes
     */
    private Queue<SongEntry> favoritePL = new Queue<SongEntry>("favorites");
    private Queue<SongEntry> roadTripPL = new Queue<SongEntry>("road trip");
    private Queue<SongEntry> loungePL = new Queue<SongEntry>("lounge");

    /**
     * A method called fillPlaylists() reads the test file and then adds songs to one of the three queues.
     * @param requestFile The name of the test file to read from.
     * @param allSongs The array of songs read from the JSON file.
     */
    public void fillPlaylists(String requestFile, SongEntry allSongs[])
    {
        File inputFile = new File(requestFile);
        try
        {
            String line = "";
            Scanner input = new Scanner(inputFile);

            while(input.hasNext())
            {
                line = input.nextLine();
                String[] tokens = line.split(",");
                String songName = tokens[1];

                for(int i = 0; i < allSongs.length; i++)
                {
                    if(allSongs[i].getTitle().equals(songName))
                    {
                        if(tokens[0].equals("favorites"))
                        {
                            favoritePL.enqueue(allSongs[i]);
                            break;
                        }
                        else if(tokens[0].equals("road trip"))
                        {
                            roadTripPL.enqueue(allSongs[i]);
                            break;
                        }
                        else if(tokens[0].equals("lounge"))
                        {
                            loungePL.enqueue(allSongs[i]);
                            break;
                        }
                    }
                }
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Accessor methods for each of the three queue structures.
     * @return favoritePL, roadTripPL, and loungePL queue structures.
     */
    public Queue<SongEntry> getFavoritePL() {
        return favoritePL;
    }

    public Queue<SongEntry> getRoadTripPL() {
        return roadTripPL;
    }

    public Queue<SongEntry> getLoungePL() {
        return loungePL;
    }
}
