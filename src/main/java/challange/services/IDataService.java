package challange.services;

import java.util.List;

public interface IDataService<T> {
	List<T> getData(Class<T> clazz) throws Exception;
}
