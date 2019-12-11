package challange.services;

import java.util.ArrayList;
import java.util.List;

import challange.constants.TicketEnum;
import challange.constants.UserEnum;
import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;
import challange.repository.IRepository;
import challange.viewModel.OrganizationModel;

public class OrganizationService implements ISearchService<OrganizationModel> {

	private IRepository<Organization> orgRepo;
	private IRepository<Ticket> ticketRepo;
	private IRepository<User> userRepo;

	public OrganizationService(
			IRepository<Organization> orgRepo,
			IRepository<Ticket> ticketRepo,
			IRepository<User> userRepo
	) {
		this.orgRepo = orgRepo;
		this.ticketRepo = ticketRepo;
		this.userRepo = userRepo;
	}

	public List<OrganizationModel> search(String term, String field) {
		List<Organization> organizations =  orgRepo.search(term, field);
		List<OrganizationModel> orgModels = new ArrayList<OrganizationModel>();
		
		organizations.forEach((org) -> {
			String ticket_subject = ticketRepo.search(org.get_id(),TicketEnum.ORGANIZATION_ID.toString()).get(0).getSubject();
			String user_name = userRepo.search(org.get_id(), UserEnum.ORGANIZATION_ID.toString()).get(0).getName();
			OrganizationModel orgModel = new OrganizationModel(org, ticket_subject, user_name);
			orgModels.add(orgModel);
		});
		return orgModels;
	}

}
