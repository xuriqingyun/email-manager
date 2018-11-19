package zhouxu.site.emailmanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhouxu.site.emailmanager.constants.MailConst;
import zhouxu.site.emailmanager.pojo.Mail;
import zhouxu.site.emailmanager.service.MailService;
import zhouxu.site.emailmanager.utils.RestResult;

import javax.mail.MessagingException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-11-14 14:20
 */
@RestController
@RequestMapping("api/v1/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public RestResult sendMail(@RequestBody Mail mail) throws MessagingException {
        return RestResult.Success(mailService.sendEmail(mail));
    }

    @GetMapping("/sendDemo")
    public RestResult sendDemoMail() throws MessagingException {
        Mail mail = new Mail("xuriqingyun@163.com","1136112121@qq.com","Demo",
                "<html><head></head><body><h1>Demo!</h1>"+ "<img src=\"cid:everynote\"/>\"<img src=\"cid:everynote1\"/></body></html>",
                Arrays.asList(new String[]{"test.txt"}),
                Arrays.asList(new String[]{"everynote","everynote1"}),
                MailConst.MailType.MIME.getType());
        return RestResult.Success(mailService.sendEmail(mail));
    }
}
