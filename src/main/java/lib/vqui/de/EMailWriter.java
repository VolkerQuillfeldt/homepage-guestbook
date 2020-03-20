package lib.vqui.de;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMailWriter {

	private EMailWriter() {

	}

	public static void sendEmail(Session session, String content, String userName) {

		try {

			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no-reply@vquillfeldt.de", "no-reply"));
			msg.setReplyTo(InternetAddress.parse("no-reply@vquillfeldt.de", false));
			msg.setSubject("Neuer GuestBook Entry: " + userName, "UTF-8");

			String mailText = content;
			msg.setContent(mailText, "text/html");

			String toEmail = "admin@vquillfeldt.de";
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
