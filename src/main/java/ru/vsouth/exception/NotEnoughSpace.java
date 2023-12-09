package ru.vsouth.exception;

public class NotEnoughSpace extends Exception {
    public NotEnoughSpace(String errorMessage){
        super(errorMessage);
    }
}
