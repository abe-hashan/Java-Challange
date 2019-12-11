package challange.domain;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public abstract class Entity {
	protected String _id;
	protected String url;
	protected String external_id;
	protected List<String> tags;
	protected String created_at;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getExternal_id() {
		return external_id;
	}
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String toString() {
		return 	StringUtils.rightPad("_id", 40)+ _id + "\n" + 
				StringUtils.rightPad("url", 40)+ url + "\n" + 
				StringUtils.rightPad("external_id", 40)+ external_id + "\n" + 
				StringUtils.rightPad("created_at", 40)+ created_at + "\n" + 
				StringUtils.rightPad("tags", 40)+ tags;
	}
}
