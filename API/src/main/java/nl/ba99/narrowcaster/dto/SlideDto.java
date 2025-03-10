package nl.ba99.narrowcaster.dto;

import nl.ba99.narrowcaster.dto.logic.StartEndDate;
import nl.ba99.narrowcaster.dto.logic.StartEndTime;
import nl.ba99.narrowcaster.validators.StartEndDateValidator;
import nl.ba99.narrowcaster.validators.StartEndTimeValidator;
import nl.ba99.narrowcaster.validators.DateValidator;
import nl.ba99.narrowcaster.validators.TimeValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Generated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@StartEndTimeValidator
@StartEndDateValidator
public abstract class SlideDto implements StartEndTime, StartEndDate {
    private Long id;

    @Positive
    @NotNull
    private Long slideshowId;

    @NotNull
    private Boolean isActive;

    @NotNull
    @Positive
    private Integer duration;

    @ApiModelProperty(name = "startDate", value = "When the slide is visible", example = "2022-01-21")
    @DateTimeFormat(fallbackPatterns = {"yyyy-MM-dd"})
    @DateValidator
    private String startDate;

    @ApiModelProperty(name = "endDate", value = "When the slide is visible", example = "2022-02-21")
    @DateTimeFormat(fallbackPatterns = {"yyyy-MM-dd"})
    @DateValidator
    private String endDate;

    @ApiModelProperty(name = "startTime", value = "When the slide is visible", example = "10:45")
    @DateTimeFormat(fallbackPatterns = {"hh:mm"})
    @TimeValidator
    private String startTime;

    @ApiModelProperty(name = "endTime", value = "When the slide is visible", example = "11:30")
    @DateTimeFormat(fallbackPatterns = {"hh:mm"})
    @TimeValidator
    private String endTime;
}
