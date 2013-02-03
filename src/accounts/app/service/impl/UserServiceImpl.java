package accounts.app.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

import accounts.app.dao.UserDao;
import accounts.app.service.UserService;
import accounts.model.entity.user.User;


/**
 * 
 * @author syed
 *
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private JavaMailSender javaMailSender;
    
    UserServiceImpl(UserDao userDao,JavaMailSender javaMailSender) {
        this.userDao = userDao;
        this.javaMailSender = javaMailSender;
        if (this.javaMailSender != null) {
            this.sendMailExeService = Executors.newFixedThreadPool(5);
        }
    }

    private ExecutorService sendMailExeService;

    public User getUser(int userId) {
    	
        return userDao.getUser(userId);
    }

    class SendMailRunnable implements Runnable {
        private MimeMessage message;

        private JavaMailSender mailSender;
        
        SendMailRunnable(MimeMessage message  ,JavaMailSender mailSender) {
            this.message = message;
            this.mailSender = mailSender;
        }

        public void run() {
            try {
                if (mailSender != null && message != null) {
                    mailSender.send(message);
                }
            } catch (Throwable zzz) {
                zzz.printStackTrace(); 
            }
        }
    }
}
