package su22b1_it16304_sof3021.beans;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data

public class MailModel {
	String from = "TD SHOP";
	String to;
	String subject;
	String body;
	List<String> cc = new ArrayList<>();
	List<String> bcc = new ArrayList<>();
	List<File> files = new ArrayList<>();
	
	public MailModel(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
	
}
