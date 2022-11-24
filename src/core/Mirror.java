package core;

import utils.ReflectionType;

import java.util.Objects;
import java.util.Random;


public class Mirror {
    ReflectionType[] reflections = new ReflectionType[]{ReflectionType.WIDE, ReflectionType.CROOKED, ReflectionType.NORMAL, ReflectionType.FLATTENED};
    protected ReflectionType reflect() {
        Random generator = new Random();
        return reflections[generator.nextInt(4)];
    }

    @Override
    public String toString() {
        return "Зеркало";
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash("Mirror");
    }
}
