package com.bangez.analysis.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private String schoolId;
    private String address;
    private String homepage;
    private String schoolName;
    private String schoolType;
}
