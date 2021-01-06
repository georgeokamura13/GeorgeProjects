public class Song {

    private String name;
    private String artist;
    private String album;
    private String length;
    private String numOfPlays;

    public void play() {

        System.out.println(String.format("Playing %s", this.name));

        return;
    }
}