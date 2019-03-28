package com.spring.feature.mailsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfoDTO {

    private String mailTo;
    private String mailBody;

}
