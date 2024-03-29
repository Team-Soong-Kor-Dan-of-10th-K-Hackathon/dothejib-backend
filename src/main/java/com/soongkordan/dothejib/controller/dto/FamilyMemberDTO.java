package com.soongkordan.dothejib.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FamilyMemberDTO {

    @Getter
    @Setter
    public static class SaveRequest {
        @NotNull
        private Long memberId;
        private String name;
        private String profileImg;
    }

    @Getter
    @Setter
    public static class ModifyInfoRequest{
        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private Long id;
        private String name;
        private String profileImg;
    }
}
