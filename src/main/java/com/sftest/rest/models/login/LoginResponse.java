package com.sftest.rest.models.login;

public class LoginResponse {
	@Override
	public String toString() {
		return "LoginResponse [access_token=" + access_token + ", instance_url=" + instance_url + ", id=" + id
				+ ", token_type=" + token_type + ", issued_at=" + issued_at + ", signature=" + signature + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instance_url == null) ? 0 : instance_url.hashCode());
		result = prime * result + ((issued_at == null) ? 0 : issued_at.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
		result = prime * result + ((token_type == null) ? 0 : token_type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginResponse other = (LoginResponse) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instance_url == null) {
			if (other.instance_url != null)
				return false;
		} else if (!instance_url.equals(other.instance_url))
			return false;
		if (issued_at == null) {
			if (other.issued_at != null)
				return false;
		} else if (!issued_at.equals(other.issued_at))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		if (token_type == null) {
			if (other.token_type != null)
				return false;
		} else if (!token_type.equals(other.token_type))
			return false;
		return true;
	}
	private String access_token;
	private String instance_url;
	private String id;
	private String token_type;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getInstance_url() {
		return instance_url;
	}
	public void setInstance_url(String instance_url) {
		this.instance_url = instance_url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(String issued_at) {
		this.issued_at = issued_at;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	private String issued_at;
	private String signature;
}
