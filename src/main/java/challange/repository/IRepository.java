package challange.repository;

import java.util.List;

public interface IRepository<T> {
	List<T> search(String term, String field);
}
