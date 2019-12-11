package challange.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import challange.constant.TicketEnum;
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
		try {
			TicketEnum ticketField = TicketEnum.valueOf(field);
			switch (ticketField) {
				case _ID:
					return Objects.equals(term, ticket.get_id());
				case URL:
					return Objects.equals(term, ticket.getUrl());
				case CREATED_AT:
					return Objects.equals(term, ticket.getCreated_at());
				case EXTERNAL_ID:
					return Objects.equals(term, ticket.getExternal_id());
				case TYPE:
					return Objects.equals(term, ticket.getType());
				case SUBJECT:
					return Objects.equals(term, ticket.getSubject());
				case DESCRIPTION:
					return Objects.equals(term, ticket.getDescription());
				case PRIORITY:
					return Objects.equals(term, ticket.getPriority());
				case STATUS:
					return Objects.equals(term, ticket.getStatus());
				case SUBMITTER_ID:
					return Objects.equals(term, ticket.getSubmitter_id());
				case ORGANIZATION_ID:
					return Objects.equals(term, ticket.getOrganization_id());
				case ASSIGNEE_ID:
					return Objects.equals(term, ticket.getAssignee_id());
				case HAS_INCIDENTS:
					return Objects.equals(term, Boolean.toString(ticket.isHas_incidents()));
				case DUE_AT:
					return Objects.equals(term, ticket.getDue_at());
				case VIA:
					return Objects.equals(term, ticket.getVia());
				case TAGS:
					return ticket.getTags().contains(term);
				default:
					return false;
				}
		}
		catch(Exception e) {
			return false;
		}
		
	}

}
