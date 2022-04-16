package com.interview.notable.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AppointmentRequestDto {

    private Long doctorId;

    private String patientFirstName;

    private String patientLastName;

    private String date;

    private String time;

    private String kind;

}
