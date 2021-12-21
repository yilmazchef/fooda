package be.fooda.bridge.twilio.controllers;

import be.fooda.bridge.twilio.service.TokenValidator;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author yilmazchef
 */
@RestController
public class MessageController {

    @Autowired
    private TokenValidator tokenValidator;

    @Value("${TWILIO_PHONE_NUMBER}")
    private String sender;

    @Autowired
    public MessageController(@Value("${TWILIO_ACCOUNT_SID}") String sid, @Value("${TWILIO_AUTH_TOKEN}") String token) {
        Twilio.init(sid, token);
    }

    @PostMapping("/send-sms")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sendMessage(@RequestBody MessageDetails message, HttpServletRequest request) {

        if (tokenValidator.isValid(request)) {
            final Message sent = Message.creator(
                    new PhoneNumber(message.number),
                    new PhoneNumber(sender),
                    message.message
            ).create();

            return "Message sent: " + sent.getBody();
        }

        return "Message could NOT sent.. ";
    }

    @PostMapping("/send-voice")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sendVoiceCall(@RequestBody MessageDetails message) throws URISyntaxException {
        Message.creator(new PhoneNumber(message.number), new PhoneNumber(sender), message.message).create();
        final Call called = Call.creator(
                new PhoneNumber(message.number),
                new PhoneNumber(sender),
                new URI("http://demo.twilio.com/docs/voice.xml")
        ).create();

        return "Called: " + called.getCallerName();
    }

    @NoArgsConstructor
    @Data
    public static class MessageDetails {
        public String number;
        public String message;
    }
}