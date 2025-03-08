package nl.ba99.narrowcaster.dto;

import nl.ba99.narrowcaster.dto.logic.StartEndTime;
import nl.ba99.narrowcaster.validators.StartEndTimeValidator;
import nl.ba99.narrowcaster.validators.TimeValidator;
import nl.ba99.narrowcaster.validators.WeekdayValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@StartEndTimeValidator
public class ConsultationHourDto implements StartEndTime {
    private Long id;

    @ApiModelProperty(name = "description", value = "Description of the current hour")
    @Size(max = 220)
    private String description;

    @ApiModelProperty(name = "weekDay", required = true, value = "The day this hour falls on")
    @WeekdayValidator
    private String weekDay;

    @ApiModelProperty(name = "startTime", required = true, value = "When the hour starts", example = "10:45")
    @NotEmpty
    @DateTimeFormat(fallbackPatterns = {"hh:mm"})
    @TimeValidator
    private String startTime;


    @ApiModelProperty(name = "endTime", required = true, value = "When the hour ends", example = "11:30")
    @NotEmpty
    @DateTimeFormat(fallbackPatterns = {"hh:mm"})
    @TimeValidator
    private String endTime;
}
