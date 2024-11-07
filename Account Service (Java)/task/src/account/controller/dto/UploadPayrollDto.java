package account.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.YearMonth;

public record UploadPayrollDto(
        @NotBlank
        String employee,
        @NotNull
        @JsonDeserialize(using = YearMonthDeserializer.class)
        YearMonth period,
        @NotNull
        Long salary) {
}

