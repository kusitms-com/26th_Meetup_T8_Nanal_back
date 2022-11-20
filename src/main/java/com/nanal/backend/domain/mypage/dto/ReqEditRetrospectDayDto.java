package com.nanal.backend.domain.mypage.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;

@Data
public class ReqEditRetrospectDayDto {

    @NotBlank(message = "retrospectDay 는 비어있을 수 없습니다.")
    @Schema(description = "회고일" , example = "TUESDAY")
    private DayOfWeek retrospectDay;
}
