package nl.ba99.narrowcaster.exception;

public class EntityIdRequirementNotMetException extends RuntimeException {
    public EntityIdRequirementNotMetException(){
        super("Entity requires an id field in the dto");
    }
}
