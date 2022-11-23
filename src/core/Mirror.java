package core;

import utils.ReflectionType;

import java.util.Random;


public class Mirror {
    ReflectionType[] reflections = new ReflectionType[]{ReflectionType.WIDE, ReflectionType.CROOKED, ReflectionType.NORMAL, ReflectionType.FLATTENED};
    protected ReflectionType reflect() {
        Random generator = new Random();
        return reflections[generator.nextInt(4)];
    }
}
