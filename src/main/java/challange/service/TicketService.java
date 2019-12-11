package challange.service;

import java.util.ArrayList;
import java.util.List;

import challange.constant.OrganizationEnum;
import challange.constant.UserEnum;
import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;
import challange.repository.IRepository;
import challange.viewModel.TicketViewModel;

public class TicketService implements ISearchService<TicketViewModel>{

	private IRepository<Organization> orgRepo;
	private IRepository<Ticket> ticketRepo;
	private IRepository<User> userRepo;
	
	
	public TicketService(
			IRepository<Organization> orgRepo,
			IRepository<Ticket> ticketRepo,
			IRepository<User> userRepo) {
		this.orgRepo = orgRepo;
		this.ticketRepo = ticketRepo;
		this.userRepo = userRepo;
	}


	public List<TicketViewModel> search(String term, String field) {
		List<Ticket> tickets = ticketRepo.search(term, field);
		List<TicketViewModel> ticketModels =new ArrayList<TicketViewModel>();
		tickets.forEach((t) -> {
			List<User> assigneeSearch = userRepo.search(t.getAssignee_id(), UserEnum._ID.toString());
			String assignee_name = assigneeSearch.isEmpty()? "" : assigneeSearch.get(0).getName();
			
			List<User> submitterSearch = userRepo.search(t.getSubmitter_id(), UserEnum._ID.toString());
			String submitter_name = submitterSearch.isEmpty()? "" : submitterSearch.get(0).getName();

			List<Organization> orgSearch = orgRepo.search(t.getOrganization_id(), OrganizationEnum._ID.toString());
			String organization_name = orgSearch.isEmpty()? "" : orgSearch.get(0).getName();
			
			ticketModels.add(new TicketViewModel(t, assignee_name, submitter_name, organization_name));
		});
		return ticketModels;
	}

}
