package inanimate;

import java.util.Objects;

public class Amusement {
    private String name;
    private boolean makesHappy;

    public Amusement(String name, boolean makesHappy){
        this.name = name;
        this.makesHappy = makesHappy;
    }

    public boolean makesHappy(){
        return makesHappy;
    }

    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amusement amusement = (Amusement) o;
        return makesHappy == amusement.makesHappy && Objects.equals(name, amusement.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, makesHappy);
    }
}
