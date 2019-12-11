package challange.domain;

import java.util.List;

public class Organization extends Entity{
	private List<String> domain_names;
	private String details;
	private String name;
	private boolean shared_tickets;
	
	public List<String> getDomain_names() {
		return domain_names;
	}
	public void setDomain_names(List<String> domain_names) {
		this.domain_names = domain_names;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isShared_tickets() {
		return shared_tickets;
	}
	public void setShared_tickets(boolean shared_tickets) {
		this.shared_tickets = shared_tickets;
	}
}
