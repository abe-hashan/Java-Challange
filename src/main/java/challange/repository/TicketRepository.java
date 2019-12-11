package challange.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import challange.domain.Ticket;

public class TicketRepository implements IRepository<Ticket> {

	private static TicketRepository instance = null;
	private List<Ticket> data = new ArrayList<Ticket>();

	private TicketRepository(List<Ticket> tickets) {
		data = tickets;
	}

	public static TicketRepository getRepository(List<Ticket> tickets) {
		if (instance == null) {
			instance = new TicketRepository(tickets);
		}
		return instance;
	}

	public List<Ticket> search(String term, String field) {
		List<Ticket> tickets = this.data.stream()
				.filter(ticket -> isMatch(term, field, ticket))
				.collect(Collectors.toList());
		return tickets;
	}
	
	private boolean isMatch(String term, String field, Ticket ticket) {
		switch (field) {
		case "_ID":
			return term.equals(ticket.get_id());
		case "URL":
			return term.equals(ticket.getUrl());
		case "CREATED_AT":
			return term.equals(ticket.getCreated_at());
		case "EXTERNAL_ID":
			return term.equals(ticket.getExternal_id());
		case "TYPE":
			return term.equals(ticket.getType());
		case "SUBJECT":
			return term.equals(ticket.getSubject());
		case "DESCRIPTION":
			return term.equals(ticket.getDescription());
		case "PRIORITY":
			return term.equals(ticket.getPriority());
		case "STATUS":
			return term.equals(ticket.getStatus());
		case "SUBMITTER_ID":
			return term.equals(ticket.getSubmitter_id());
		case "ORGANIZATION_ID":
			return term.equals(ticket.getOrganization_id());
		case "ASSIGNEE_ID":
			return term.equals(ticket.getAssignee_id());
		case "HAS_INCIDENTS":
			return term.equals(Boolean.toString(ticket.isHas_incidents()));
		case "DUE_AT":
			return term.equals(ticket.getDue_at());
		case "VIA":
			return term.equals(ticket.getVia());
		case "TAGS":
			return ticket.getTags().contains(term);
		default:
			return false;
		}
	}

}
