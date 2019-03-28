package com.spring.feature.mailsender.controller;

import com.spring.feature.mailsender.dto.MailInfoDTO;
import com.spring.feature.mailsender.enums.MailTemplate;
import com.spring.feature.mailsender.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mail")
public class MailSenderController {

    @Autowired
    private MailService mailService;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestParam(value = "messageType") MailTemplate messageType,
                                          @RequestBody MailInfoDTO mailInfoDTO) {

        mailService.sendSimpleMessage(messageType, mailInfoDTO.getMailTo(), mailInfoDTO.getMailBody());
        return ResponseEntity.ok().build();
    }
}
