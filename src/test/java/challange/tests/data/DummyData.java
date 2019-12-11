package challange.tests.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;

public class DummyData {
	public static final int MAX_TAGS = 5;
	public static final int MAX_DOMAINS = 5;
	public static final int ORG_COUNT = 20;
	public static final int USER_COUNT = 200;
	public static final int TICKET_COUNT = 200;

	public static List<Organization> orgData = new ArrayList<Organization>();
	public static List<User> userData = new ArrayList<User>();
	public static List<Ticket> ticketData = new ArrayList<Ticket>();

	static {
		Faker faker = new Faker();
		Locale[] locales = Locale.getAvailableLocales();
		String[] timeZoneIds = TimeZone.getAvailableIDs();
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

		/*
		 * Creating dummy organizations
		 */
		for (int i = 0; i < ORG_COUNT; i++) {
			Organization org = new Organization();
			org.set_id(Integer.toString(i + 1));
			org.setCreated_at(faker.date().past(1, TimeUnit.DAYS).toString());
			org.setDetails(faker.book().title());
			List<String> domainNames = new ArrayList<String>();
			for (int j = 0; j < new Random().nextInt(MAX_DOMAINS - 1) + 1; j++) {
				domainNames.add(faker.superhero().power());
			}
			org.setDomain_names(domainNames);
			org.setExternal_id(UUID.randomUUID().toString());
			org.setName(faker.book().title());
			org.setShared_tickets(faker.bool().bool());
			List<String> tags = new ArrayList<String>();
			for (int j = 0; j < new Random().nextInt(MAX_TAGS -1) + 1; j++) {
				tags.add(faker.lordOfTheRings().character());
			}
			org.setTags(tags);
			org.setUrl(faker.internet().url());
			orgData.add(org);
		}

		/*
		 * Creating dummy users
		 */
		for (int i = 0; i < USER_COUNT; i++) {
			User user = new User();
			df.setTimeZone(tz);
			user.setCreated_at(faker.date().past(5, TimeUnit.DAYS).toString());
			user.set_id(Integer.toString(i));
			user.setActive(faker.bool().bool());
			user.setAlias(faker.pokemon().name());
			user.setEmail(faker.internet().emailAddress());
			user.setExternal_id(UUID.randomUUID().toString());
			user.setLast_login_at(faker.date().between(faker.date().past(5, TimeUnit.DAYS), new Date()).toString());
			user.setLocale(locales[new Random().nextInt(locales.length)].toString());
			user.setName(faker.name().fullName());
			user.setOrganization_id(Integer.toString(i % 5)); //adding 10 users to each organization
			user.setPhone(faker.phoneNumber().phoneNumber().toString());
			user.setRole(faker.superhero().name().toString());
			user.setShared(faker.bool().bool());
			user.setSignature(faker.esports().player().toString());
			user.setSuspended(faker.bool().bool());

			List<String> tags = new ArrayList<String>();
			for (int j = 0; j < new Random().nextInt(MAX_TAGS); j++) {
				tags.add(faker.lordOfTheRings().character());
			}

			user.setTags(tags);
			user.setTimezone(
					TimeZone.getTimeZone(timeZoneIds[new Random().nextInt(timeZoneIds.length - 1)]).toString());
			user.setUrl(faker.internet().url());
			user.setVerified(faker.bool().bool());
			userData.add(user);
		}
		
		/*
		 * Creating dummy tickets
		 */
		for (int i = 0; i < TICKET_COUNT; i++) {
			Ticket ticket = new Ticket();
			ticket.set_id(UUID.randomUUID().toString());
			if(i >=10 || i <=19 ) {
				ticket.setAssignee_id(Integer.toString(1));
				// User ID = 1 will have atleast 10 tickets assigned
			}
			ticket.setAssignee_id(Integer.toString(new Random().nextInt(USER_COUNT - 1)));
			ticket.setCreated_at(faker.date().past(10, TimeUnit.DAYS).toString());
			ticket.setDescription(faker.pokemon().location());
			ticket.setHas_incidents(faker.bool().bool());
			//adding 10 ticket to each organization
			ticket.setOrganization_id(Integer.toString(i % 5));
			ticket.setPriority(faker.esports().league());
			ticket.setStatus(faker.esports().event());
			ticket.setSubject(faker.commerce().department());
			ticket.setSubmitter_id(Integer.toString(i % 5));
			List<String> tags = new ArrayList<String>();
			for (int j = 0; j < new Random().nextInt(MAX_TAGS - 1) + 1; j++) {
				tags.add(faker.lordOfTheRings().character());
			}
			ticket.setTags(tags);
			ticket.setType(faker.cat().breed());
			ticket.setUrl(faker.internet().url());
			ticket.setVia(faker.beer().malt());
			ticketData.add(ticket);
		}
	}
}
