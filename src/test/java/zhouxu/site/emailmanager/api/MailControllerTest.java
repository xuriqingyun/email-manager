package zhouxu.site.emailmanager.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhouxu.site.emailmanager.constants.MailConst;
import zhouxu.site.emailmanager.pojo.Mail;

import javax.mail.MessagingException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-11-14 15:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailControllerTest {
    @Autowired
    private MailController mailController;

    @Test
    public void sendMailTest(){
        Mail mail = new Mail("devoperation@163.com","1136112121@qq.com","测试文本邮件发送",
                "<html><head></head><body><h1>hello!</h1>"+ "<img src=\"cid:everynote\"/>\"<img src=\"cid:everynote1\"/></body></html>",
                Arrays.asList(new String[]{"test.txt"}),
                Arrays.asList(new String[]{"everynote","everynote1"}),
                MailConst.MailType.SIMPLETEXT.getType());
        try {
            mailController.sendMail(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
