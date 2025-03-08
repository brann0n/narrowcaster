package nl.ba99.narrowcaster.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeValidatorImpl implements ConstraintValidator<TimeValidator, String> {
    @Override
    public void initialize(TimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(value, format); // Throws if value cannot be parsed.
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
