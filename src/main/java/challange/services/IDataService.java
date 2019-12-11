package challange.services;

import java.util.List;

public interface IDataService<T> {
	List<T> getData(String jsonName, Class<T> clazz) throws Exception;
}
