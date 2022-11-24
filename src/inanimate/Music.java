package inanimate;

import java.util.Objects;

public class Music {
    private String title;
    private boolean isPlaying;

    public Music(String title){this.title = title;}
    public void play(){isPlaying = true; System.out.println("Музыка "+title+" начинает играть...");}
    public void stop(){isPlaying = false; System.out.println("Музыка "+title+" затухает...");}

    public boolean isPlaying() {
        return isPlaying;
    }
    @Override
    public String toString(){return title;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return title.equals(music.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
