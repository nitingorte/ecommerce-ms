package com.ecommerce.notification.email;

import com.ecommerce.notification.kakfa.order.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ecommerce.notification.email.EmailTemplate.ORDER_CONFIRMATION;
import static com.ecommerce.notification.email.EmailTemplate.PAYMENT_CONFIRMATION;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class EmailService {

    private JavaMailSender javaMailSender;
    private SpringTemplateEngine springTemplateEngine;

    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper =
                new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
        mimeMessageHelper.setFrom("nitin.gorte005@gmail.com");
        final String templateName = PAYMENT_CONFIRMATION.getTemplate();
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", customerName);
        variables.put("amount", amount);
        variables.put("orderReference", orderReference);

        Context context = new Context();
        context.setVariables(variables);
        mimeMessageHelper.setSubject(templateName);
        mimeMessageHelper.setSubject(PAYMENT_CONFIRMATION.getSubject());
        try {
            String htmlTemplate = springTemplateEngine.process(templateName, context);
            mimeMessageHelper.setText(htmlTemplate, true);
            mimeMessageHelper.setTo(destinationEmail);
            javaMailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s,", destinationEmail, templateName));

        } catch (MessagingException e) {
            log.warn("WARNING - cannot send email to {}", destinationEmail);
        }


    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<Product> productList
    ) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper =
                new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
        mimeMessageHelper.setFrom("nitin.gorte005@gmail.com");
        final String templateName = ORDER_CONFIRMATION.getTemplate();
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", customerName);
        variables.put("total amount", amount);
        variables.put("orderReference", orderReference);
        variables.put("products", productList);

        Context context = new Context();
        context.setVariables(variables);
        mimeMessageHelper.setSubject(templateName);
        mimeMessageHelper.setSubject(ORDER_CONFIRMATION.getSubject());
        try {
            String htmlTemplate = springTemplateEngine.process(templateName, context);
            mimeMessageHelper.setText(htmlTemplate, true);
            mimeMessageHelper.setTo(destinationEmail);
            javaMailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s,", destinationEmail, templateName));

        } catch (MessagingException e) {
            log.warn("WARNING - cannot send email to {}", destinationEmail);
        }


    }


}
