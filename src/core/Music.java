package core;

public class Music {
    private String title;
    private boolean isPlaying;

    public Music(String title){this.title = title;}
    public String toString(){return title;}
    public void play(){isPlaying = true; System.out.println("Музыка "+title+" начинает играть...");}
    public void stop(){isPlaying = false; System.out.println("Музыка "+title+" затухает...");}

    public boolean isPlaying() {
        return isPlaying;
    }
}
