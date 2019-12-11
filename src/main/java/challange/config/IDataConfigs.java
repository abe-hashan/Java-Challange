package challange.config;

import java.util.List;

public interface IDataConfigs<T> {
	List<T> getData(Class<T> clazz) throws Exception;
}
