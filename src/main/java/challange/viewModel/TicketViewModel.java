package challange.viewModel;

import org.apache.commons.lang3.StringUtils;

import challange.domain.Ticket;

public class TicketViewModel {
	private Ticket ticket;
	private String assignee_name;
	private String submitter_name;
	private String organization_name;
	
	public TicketViewModel(Ticket ticket, String assignee_name, String submitter_name, String organization_name) {
		super();
		this.ticket = ticket;
		this.assignee_name = assignee_name;
		this.submitter_name = submitter_name;
		this.organization_name = organization_name;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public String getAssignee_name() {
		return assignee_name;
	}
	public void setAssignee_name(String assignee_name) {
		this.assignee_name = assignee_name;
	}
	public String getSubmitter_name() {
		return submitter_name;
	}
	public void setSubmitter_name(String submitter_name) {
		this.submitter_name = submitter_name;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	
	public String toString() {
		return 	ticket.toString() +
				StringUtils.rightPad("assignee_name", 40) + assignee_name + "\n" +
				StringUtils.rightPad("submitter_name", 40) + submitter_name + "\n" + 
				StringUtils.rightPad("organization_name", 40) + organization_name + "\n";
	}
	
	
}
