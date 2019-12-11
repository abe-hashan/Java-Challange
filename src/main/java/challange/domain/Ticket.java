package challange.domain;

public class Ticket extends Entity{
	private String type;
	private String subject;
	private String description;
	private String priority;
	private String status;
	private String submitter_id;
	private String assignee_id;
	private String organization_id;
	private boolean has_incidents;
	private String due_at;
	private String via;
	
	public Ticket() {
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubmitter_id() {
		return submitter_id;
	}
	public void setSubmitter_id(String submitter_id) {
		this.submitter_id = submitter_id;
	}
	public String getAssignee_id() {
		return assignee_id;
	}
	public void setAssignee_id(String assignee_id) {
		this.assignee_id = assignee_id;
	}
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}
	public boolean isHas_incidents() {
		return has_incidents;
	}
	public void setHas_incidents(boolean has_incidents) {
		this.has_incidents = has_incidents;
	}
	public String getDue_at() {
		return due_at;
	}
	public void setDue_at(String due_at) {
		this.due_at = due_at;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	
	
}
