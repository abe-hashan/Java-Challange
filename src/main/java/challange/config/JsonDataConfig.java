package challange.config;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;

public class JsonDataConfig<T> implements IDataConfigs<T> {

	public List<T> getData(Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
        if(clazz == Organization.class) {
        	File file = new File(getClass().getClassLoader().getResource("organizations.json").getFile());
        	return objectMapper.readValue(file, new TypeReference<List<Organization>>() {});
        } else if(clazz == User.class) {
        	File file = new File(getClass().getClassLoader().getResource("users.json").getFile());
        	return objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } else {
        	File file = new File(getClass().getClassLoader().getResource("tickets.json").getFile());
        	return objectMapper.readValue(file, new TypeReference<List<Ticket>>() {});
        }
	}

}
