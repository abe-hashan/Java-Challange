package challange.domain;

import org.apache.commons.lang3.StringUtils;

public class User extends Entity{
	private String name;
	private String alias;
	private boolean active;
	private boolean verified;
	private boolean shared;
	private String locale;
	private String timezone;
	private String last_login_at;
	private String email;
	private String phone;
	private String signature;
	private String organization_id;
	private boolean suspended;
	private String role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public boolean isShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getLast_login_at() {
		return last_login_at;
	}
	public void setLast_login_at(String last_login_at) {
		this.last_login_at = last_login_at;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return	super.toString() + "\n" + 
				StringUtils.rightPad("name", 40) + name + "\n" +
				StringUtils.rightPad("alias", 40) + alias + "\n" +
				StringUtils.rightPad("active", 40) + active + "\n" +
				StringUtils.rightPad("verified", 40) + verified + "\n" +
				StringUtils.rightPad("shared", 40) + shared + "\n" +
				StringUtils.rightPad("locale", 40) + locale + "\n" +
				StringUtils.rightPad("timezone", 40) + timezone + "\n" +
				StringUtils.rightPad("last_login_at", 40) + last_login_at + "\n" +
				StringUtils.rightPad("email", 40) + email + "\n" +
				StringUtils.rightPad("phone", 40) + phone + "\n" +
				StringUtils.rightPad("signature", 40) + signature + "\n" +
				StringUtils.rightPad("organization_id", 40) + organization_id + "\n" +
				StringUtils.rightPad("suspended", 40) + suspended + "\n" +
				StringUtils.rightPad("role", 40) + role + "\n" ;
	}
	
	
}
