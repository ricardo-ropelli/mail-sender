package com.spring.feature.mailsender.service;

import com.spring.feature.mailsender.dto.MailTemplateInfoDTO;

public interface IMailTemplate {

    MailTemplateInfoDTO prepareMessage(final String mailTo, final String mailBody);

}
