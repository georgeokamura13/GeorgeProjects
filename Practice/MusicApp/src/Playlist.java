import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Playlist {

    private Queue<Song> playlist;

    public Playlist() {
        this.playlist = new LinkedList<>();
    }

    public Song getNextSongToPlay() {
        return playlist.peek();
    }

    public void queueUpSong(Song s) {
        playlist.add(s);
    }

    public void shuffle() {
        ArrayList<Song> songList = new ArrayList<Song>(playlist);
        Collections.shuffle(songList);
        playlist = new LinkedList<>(songList);
    }
}
