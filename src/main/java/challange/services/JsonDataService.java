package challange.services;

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

public class JsonDataService<T> implements IDataService<T> {

	public List<T> getData(String jsonName, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(getClass().getClassLoader().getResource(jsonName).getFile());
		
        if(clazz == Organization.class) {
        	return objectMapper.readValue(file, new TypeReference<List<Organization>>() {});
        } else if(clazz == User.class) {
        	return objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } else {
        	return objectMapper.readValue(file, new TypeReference<List<Ticket>>() {});
        }
	}

}
