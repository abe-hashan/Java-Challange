package challange.service;

import java.util.ArrayList;
import java.util.List;

import challange.constant.TicketEnum;
import challange.constant.UserEnum;
import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;
import challange.repository.IRepository;
import challange.viewModel.OrganizationViewModel;

public class OrganizationService implements ISearchService<OrganizationViewModel> {

	private IRepository<Organization> orgRepo;
	private IRepository<Ticket> ticketRepo;
	private IRepository<User> userRepo;

	public OrganizationService(IRepository<Organization> orgRepo, IRepository<Ticket> ticketRepo,
			IRepository<User> userRepo) {
		this.orgRepo = orgRepo;
		this.ticketRepo = ticketRepo;
		this.userRepo = userRepo;
	}

	public List<OrganizationViewModel> search(String term, String field) {
		List<Organization> organizations = orgRepo.search(term, field);
		List<OrganizationViewModel> orgModels = new ArrayList<OrganizationViewModel>();

		organizations.forEach((org) -> {
			List<Ticket> tickets = ticketRepo.search(org.get_id(), TicketEnum.ORGANIZATION_ID.toString());
			String ticket_subject = tickets.isEmpty() ? "" : tickets.get(0).getSubject();

			List<User> users = userRepo.search(org.get_id(), UserEnum.ORGANIZATION_ID.toString());
			String user_name = users.isEmpty() ? "" : users.get(0).getName();

			OrganizationViewModel orgModel = new OrganizationViewModel(org, ticket_subject, user_name);
			orgModels.add(orgModel);
		});
		return orgModels;
	}

}
