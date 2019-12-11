package challange.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import challange.constant.OrganizationEnum;
import challange.constant.TicketEnum;
import challange.constant.UserEnum;
import challange.repository.OrganizationRepository;
import challange.repository.TicketRepository;
import challange.repository.UserRepository;
import challange.service.OrganizationService;
import challange.service.TicketService;
import challange.service.UserService;
import challange.tests.data.DummyData;
import challange.viewModel.OrganizationViewModel;
import challange.viewModel.TicketViewModel;
import challange.viewModel.UserViewModel;

@RunWith(MockitoJUnitRunner.class)
public class SimpleTest {

	UserRepository userRepo = UserRepository.getRepository(DummyData.userData);
	TicketRepository ticketRepo = TicketRepository.getRepository(DummyData.ticketData);
	OrganizationRepository orgRepo = OrganizationRepository.getRepository(DummyData.orgData);

	UserService userService = new UserService(orgRepo, ticketRepo, userRepo);
	TicketService ticketService = new TicketService(orgRepo, ticketRepo, userRepo);
	OrganizationService orgService = new OrganizationService(orgRepo, ticketRepo, userRepo);

	@Test
	public void testSearchUser() throws Exception {
		List<UserViewModel> users = userService.search("1", UserEnum._ID.toString());
		assertEquals(users.size(), 1);

		assertTrue(!Objects.isNull(users.get(0).getOrganization_name())
				&& users.get(0).getOrganization_name() != "");
		assertTrue(!Objects.isNull(users.get(0).getSumitted_ticket_subject())
				&& users.get(0).getSumitted_ticket_subject() != "");
//		assertTrue(!Objects.isNull(users.get(0).getAssignee_ticket_subject())
//				&& users.get(0).getAssignee_ticket_subject() != "");
	}

	@Test
	public void testSearchTicket() throws Exception {
		List<TicketViewModel> tickets= ticketService.search("1", TicketEnum.SUBMITTER_ID.toString());
		assertNotEquals(0, tickets.size());
		
		assertTrue(!Objects.isNull(tickets.get(0).getAssignee_name())
				&& tickets.get(0).getAssignee_name() != "");
		assertTrue(!Objects.isNull(tickets.get(0).getOrganization_name())
				&& tickets.get(0).getOrganization_name() != "");
		assertTrue(!Objects.isNull(tickets.get(0).getSubmitter_name()) 
				&& tickets.get(0).getSubmitter_name() != "");
	}
	
	@Test
	public void testSearchOrganizations() throws Exception {
		List<OrganizationViewModel> orgs= orgService.search("1", OrganizationEnum._ID.toString());
		assertNotEquals(0, orgs.size());
		
		assertTrue(!Objects.isNull(orgs.get(0).getTicket_subject())
				&& orgs.get(0).getTicket_subject() != "");
		assertTrue(!Objects.isNull(orgs.get(0).getUser_name())
				&& orgs.get(0).getUser_name() != "");
	}
}
