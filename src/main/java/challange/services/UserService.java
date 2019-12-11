package challange.services;

import java.util.ArrayList;
import java.util.List;

import challange.constants.OrganizationEnum;
import challange.constants.TicketEnum;
import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;
import challange.repository.IRepository;
import challange.viewModel.UserViewModel;

public class UserService implements ISearchService<UserViewModel>{
	
	private IRepository<Organization> orgRepo;
	private IRepository<Ticket> ticketRepo;
	private IRepository<User> userRepo;

	public UserService(IRepository<Organization> orgRepo, IRepository<Ticket> ticketRepo, IRepository<User> userRepo) {
		this.orgRepo = orgRepo;
		this.ticketRepo = ticketRepo;
		this.userRepo = userRepo;
	}

	public List<UserViewModel> search(String term, String field) {
		List<User> users = userRepo.search(term, field);
		List<UserViewModel> userModels =new ArrayList<UserViewModel>();
		users.forEach((u) -> {
			List<Ticket> ticketAssigneeSearch = ticketRepo.search(u.get_id(), TicketEnum.ASSIGNEE_ID.toString());
			String assignee_ticket_subject = ticketAssigneeSearch.isEmpty()? "" : ticketAssigneeSearch.get(0).getSubject();
			
			List<Ticket> ticketSubmitterSearch = ticketRepo.search(u.get_id(), TicketEnum.SUBMITTER_ID.toString());
			String submitted_ticket_subject = ticketSubmitterSearch.isEmpty()? "" : ticketSubmitterSearch.get(0).getSubject();

			List<Organization> orgSearch = orgRepo.search(u.getOrganization_id(), OrganizationEnum._ID.toString());
			String organization_name = orgSearch.isEmpty()? "" : orgSearch.get(0).getName();
			
			userModels.add(new UserViewModel(u, assignee_ticket_subject, submitted_ticket_subject, organization_name));
		});
		return userModels;
	}

}
