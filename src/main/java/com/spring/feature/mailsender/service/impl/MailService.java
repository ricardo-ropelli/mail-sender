package com.spring.feature.mailsender.service.impl;

import com.spring.feature.mailsender.dto.MailTemplateInfoDTO;
import com.spring.feature.mailsender.enums.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendSimpleMessage(final MailTemplate messageType,
                                  final String mailTo,
                                  final String mailBody) {
        try {
            javaMailSender.send(prepareMimeMessage(messageType, mailTo, mailBody));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage prepareMimeMessage(MailTemplate messageType, String mailTo, String mailBody) throws MessagingException {
        MailTemplateInfoDTO email = messageType.prepareMessage(mailTo, mailBody);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setSubject(email.getSubject(), StandardCharsets.UTF_8.name());
        mimeMessage.setContent(email.getContent(), "text/html");
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, StandardCharsets.UTF_8.name());
        mimeMessageHelper.setTo(mailTo);
        return mimeMessage;
    }
}
