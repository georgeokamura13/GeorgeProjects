import java.util.Collections;
import java.util.Set;

public class MusicApp {

    private Set<Album> albumCollection;
    private Playlist currentPlaylist;

    public MusicApp() {
        this.albumCollection = Collections.emptySet();
        this.currentPlaylist = new Playlist();
    }

    public void addAlbum(Album album) {
        albumCollection.add(album);
    }

    public void playSong() {
        Song nextSong = currentPlaylist.getNextSongToPlay();
        nextSong.play();
    }

}
