package model.dtos;

/**
 * Created by Deniel on 28.01.2015.
 */
public class Result<T> {

    public boolean hasError;
    public T returnValue;

    public Result(){
        hasError = false;
    }
}
