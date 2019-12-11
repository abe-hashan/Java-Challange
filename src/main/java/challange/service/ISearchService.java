package challange.service;

import java.util.List;

public interface ISearchService<T> {
	List<T> search(String term, String field);
}
