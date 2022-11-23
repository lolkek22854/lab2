package utils;

public enum ReflectionType{
    CROOKED("скрюченное"),
    NORMAL("обыкновенное"),
    FLATTENED("сплющенное"),
    WIDE("растянутое");

    private String name;
    private ReflectionType(String name){
        this.name=name;
    }

    public String toString(){
        return name;
    }
}