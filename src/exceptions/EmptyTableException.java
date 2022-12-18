package exceptions;

public class EmptyTableException extends RuntimeException{
    public EmptyTableException(){
        super("Стол пуст!");
    }
}
