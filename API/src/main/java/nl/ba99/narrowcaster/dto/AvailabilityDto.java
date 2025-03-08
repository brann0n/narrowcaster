package nl.ba99.narrowcaster.dto;

import nl.ba99.narrowcaster.dto.logic.StartEndTime;
import nl.ba99.narrowcaster.validators.StartEndTimeValidator;
import nl.ba99.narrowcaster.validators.TimeValidator;
import nl.ba99.narrowcaster.validators.WeekdayValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@StartEndTimeValidator
public class AvailabilityDto implements StartEndTime {
    private Long id;

    @ApiModelProperty(name = "description", value = "The user this data belongs to\nSee [user-controller](#/user-controller) for more info")
    @NotNull
    @Positive
    private Long userId;

    @ApiModelProperty(name = "weekDay", required = true, value = "The day of availability")
    @WeekdayValidator
    private String weekDay;

    @ApiModelProperty(name = "startTime", required = true, value = "When the hour starts", example = "10:45")
    @NotEmpty
    @DateTimeFormat(fallbackPatterns = {"HH:mm"})
    @TimeValidator
    private String startTime;

    @ApiModelProperty(name = "endTime", required = true, value = "When the hour ends", example = "11:30")
    @NotEmpty
    @DateTimeFormat(fallbackPatterns = {"HH:mm"})
    @TimeValidator
    private String endTime;
}
