import java.util.Set;

public class Album {

    private Set<Song> songCollection;
    private String name;

    public Album(String name, Set<Song> songCollection) {
        this.name = name;
        this.songCollection = songCollection;
    }

    public Set<Song> getSongCollection() {
        return songCollection;
    }
}
