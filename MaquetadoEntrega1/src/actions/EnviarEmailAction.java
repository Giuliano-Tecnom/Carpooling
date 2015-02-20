package actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import utils.SendSMTPMail;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EnviarEmailAction extends ActionSupport {
	
	private String from;
	private String to;
	private String subject;
	private String content;
	private String pass;
	
	
	public EnviarEmailAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String enviar() throws IOException{
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		if((this.getFrom() == null || this.getTo() == null ||this.getPass() == null || this.getContent() == null || this.getSubject() == null) && request.getSession().getAttribute("usuarioAdministrador") == null){
			return INPUT;
		}else{
			SendSMTPMail mail = new SendSMTPMail();
			mail.sendEmail(this.getFrom(), this.getTo(),this.getSubject(), this.getContent(),this.getPass());
			return SUCCESS;
		}
		
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
}
