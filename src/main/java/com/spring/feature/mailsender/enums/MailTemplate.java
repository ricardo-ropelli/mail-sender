package com.spring.feature.mailsender.enums;

import com.spring.feature.mailsender.dto.MailTemplateInfoDTO;
import com.spring.feature.mailsender.service.IMailTemplate;

public enum MailTemplate implements IMailTemplate {

    RESET_PASSWORD_MESSAGE {
        private static final String MAIL_SUBJECT = "[JavaMailSender] - Reset password message.";
        private final String mailBodyTemplate =
                "Hey, <strong>%s</strong>.".concat(HTML_LINE_BREAKER) +
                        "We've received a request for password reset, was it you ?".concat(HTML_LINE_BREAKER) +
                        "Here is the original message from original request: %s.".concat(HTML_LINE_BREAKER) +
                        "Best wished.";

        @Override
        public MailTemplateInfoDTO prepareMessage(final String mailTo, final String mailBody) {
            return new MailTemplateInfoDTO(MAIL_SUBJECT, String.format(mailBodyTemplate, mailTo, mailBody));
        }
    },

    OTHER_EXAMPLE_MESSAGE {
        private static final String MAIL_SUBJECT = "[JavaMailSender] - Other example message.";
        private final String mailBodyTemplate =
                "Hey, <strong>%s</strong>.".concat(HTML_LINE_BREAKER) +
                        "I've run out of idea.".concat(HTML_LINE_BREAKER) +
                        "Here is the original message from original request: %s.".concat(HTML_LINE_BREAKER) +
                        "Best wished.";

        @Override
        public MailTemplateInfoDTO prepareMessage(final String mailTo, final String mailBody) {
            return new MailTemplateInfoDTO(MAIL_SUBJECT, String.format(mailBodyTemplate, mailTo, mailBody));
        }
    };

    private static final String HTML_LINE_BREAKER = "<br><br>";
}
