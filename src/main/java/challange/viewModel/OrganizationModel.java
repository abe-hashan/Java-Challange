package challange.viewModel;

import org.apache.commons.lang3.StringUtils;

import challange.domain.Organization;

public class OrganizationModel{
	private Organization organization;
	private String	ticket_subject;
	private String user_name;
	
	public OrganizationModel(Organization organization, String ticket_subject, String user_name) {
		super();
		this.organization = organization;
		this.ticket_subject = ticket_subject;
		this.user_name = user_name;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public String getTicket_subject() {
		return ticket_subject;
	}
	public void setTicket_subject(String ticket_subject) {
		this.ticket_subject = ticket_subject;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String toString() {
		return 	organization.toString() + "\n" + 
				StringUtils.rightPad("ticket_subject", 40) + ticket_subject + "\n" +
				StringUtils.rightPad("user_name", 40) + user_name + "\n";
	}
	
	
}
