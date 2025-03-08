package nl.ba99.narrowcaster.exception;

public class ForbiddenActionException extends RuntimeException {

    public ForbiddenActionException(){
        super("You're not allowed in here.");
    }
}
