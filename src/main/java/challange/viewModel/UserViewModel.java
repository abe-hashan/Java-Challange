package challange.viewModel;

import org.apache.commons.lang3.StringUtils;

import challange.domain.User;

public class UserViewModel {
	private User user;
	private String assignee_ticket_subject;
	private String sumitted_ticket_subject;
	private String organization_name;
	
	public UserViewModel(User user, String assignee_ticket_subject, String sumitted_ticket_subject,
			String organization_name) {
		super();
		this.user = user;
		this.assignee_ticket_subject = assignee_ticket_subject;
		this.sumitted_ticket_subject = sumitted_ticket_subject;
		this.organization_name = organization_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAssignee_ticket_subject() {
		return assignee_ticket_subject;
	}

	public void setAssignee_ticket_subject(String assignee_ticket_subject) {
		this.assignee_ticket_subject = assignee_ticket_subject;
	}

	public String getSumitted_ticket_subject() {
		return sumitted_ticket_subject;
	}

	public void setSumitted_ticket_subject(String sumitted_ticket_subject) {
		this.sumitted_ticket_subject = sumitted_ticket_subject;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String toString() {
		return user.toString() +
				StringUtils.rightPad("assignee_ticket_subject", 40) + assignee_ticket_subject + "\n" +
				StringUtils.rightPad("sumitted_ticket_subject", 40) + sumitted_ticket_subject + "\n" + 
				StringUtils.rightPad("organization_name", 40) + organization_name + "\n";
	}
	
	
	
	
}
