package nl.ba99.narrowcaster.validators;

import nl.ba99.narrowcaster.dto.logic.StartEndTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class StartEndTimeValidatorImpl implements ConstraintValidator<StartEndTimeValidator, StartEndTime> {
    @Override
    public void initialize(StartEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(StartEndTime value, ConstraintValidatorContext context) {
        try{
            LocalTime startTime = LocalTime.parse(value.getStartTime());
            LocalTime endTime = LocalTime.parse(value.getEndTime());
            return startTime.isBefore(endTime);
        }catch(Exception ex){
            return true;
        }
    }
}
