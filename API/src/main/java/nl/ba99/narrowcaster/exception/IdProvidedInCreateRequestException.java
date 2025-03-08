package nl.ba99.narrowcaster.exception;

import lombok.Getter;

@Getter
public class IdProvidedInCreateRequestException extends RuntimeException {
    private final long id;
    public IdProvidedInCreateRequestException(String message, long id){
        super(message);
        this.id = id;
    }
}
