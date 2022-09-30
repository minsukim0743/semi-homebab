package com.homebab.smtp;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public boolean senderSmtp(Map<String, Object> hm) {
		
		Boolean result = false;
		
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.naver.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.ssl.trust","smtp.naver.com");
		p.put("mail.smtp.ssl.protocols","TLSv1.2");
		
		Authenticator auth = new MyAuthentication();
		// session 생성 및 MimeMessage생성
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);
		session.setDebug(true);
		
		String body = "<h1 align='center'>홈밥</h1><br><br><p align='center'>안녕하세요 회원님, 회원님의 인증번호는 <span style='color:blue'>[" + hm.get("authNum") + "]</span> 입니다.</p>";
		String recipient = (String) hm.get("pfEmail");
		try {
			// 편지보낸시간
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();
			from = new InternetAddress("hopemantest@naver.com", "홈밥"); // 발신자 아이디
			// 이메일 발신자
			msg.setFrom(from);
			// 이메일 수신자
			InternetAddress to = new InternetAddress(recipient);
			msg.setRecipient(Message.RecipientType.TO, to);
			// 이메일 제목
			msg.setSubject("[홈밥] 비밀번호 찾기 인증번호입니다.", "UTF-8");
			// 이메일 내용
			msg.setText(body, "UTF-8");
			// 이메일 헤더
			msg.setHeader("content-Type", "text/html");
			// 메일보내기
			javax.mail.Transport.send(msg, msg.getAllRecipients());
			
			result = true;
			
		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
			result = false;
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
			result = false;
		} catch (Exception msg_e) {
			msg_e.printStackTrace();
			result = false;
		}
		
		return result;
	}
}

class MyAuthentication extends Authenticator {

	PasswordAuthentication pa;

	public MyAuthentication() {

		String id = "hopemantest@naver.com"; // 네이버 이메일 아이디
		String pw = "Test1234!!"; // 네이버 비밀번호

		// ID와 비밀번호를 입력한다.
		pa = new PasswordAuthentication(id, pw);
	}

	// 시스템에서 사용하는 인증정보
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}