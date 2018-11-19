package zhouxu.site.emailmanager.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhouxu.site.emailmanager.constants.MailConst;
import zhouxu.site.emailmanager.pojo.Mail;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-11-14 13:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;
    @Test
    public void sendSimpleTextMailTest(){
        Mail mail = new Mail("xuriqingyun@163.com","1136112121@qq.com","测试文本邮件发送","this is a text mail",null,null,MailConst.MailType.SIMPLETEXT.getType());
        mailService.sendSimpleTextMail(mail);
    }
}
