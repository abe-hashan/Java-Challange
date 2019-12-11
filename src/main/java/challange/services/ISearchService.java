package challange.services;

import java.util.List;

public interface ISearchService<T> {
	List<T> search(String term, String field);
}
