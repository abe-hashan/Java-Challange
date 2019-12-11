package challange.constants;

import java.util.HashMap;
import java.util.Map;

public class EntityType {
	public static final Map<String, String> MAP= new HashMap<String, String>();
	static {
		MAP.put("1", "Users");
		MAP.put("2", "Tickets");
		MAP.put("3", "Organizations");
	}
}
