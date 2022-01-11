package com.danubetech.didcomm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jwt.JWTClaimsSet;

import java.text.ParseException;
import java.util.Map;

public class DIDCommMessage extends JwtObject {

	private String typ;
	private String id;
	private String type;
	private String from;
	private String to;
	private Long created_time;
	private Long expires_time;
	private Map<String, Object> body;

	public DIDCommMessage() {
		super(new JWTClaimsSet.Builder().build(), null, null);
	}

	@JsonIgnore
	public JWTClaimsSet getPayload() {
		try {
			return JWTClaimsSet.parse(this.toMap());
		} catch (ParseException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	@JsonIgnore
	public boolean isComplete() {
		return this.getId() != null && this.getType() != null && this.getBody() != null;
	}

	/*
	 * (De-)serialization
	 */

	private static final ObjectMapper objectMapper = new ObjectMapper();

	private static DIDCommMessage fromJson(String json) throws JsonProcessingException {
		return objectMapper.readValue(json, DIDCommMessage.class);
	}

	public Map<String, Object> toMap() {
		return objectMapper.convertValue(this, Map.class);
	}

	public String toJson() throws JsonProcessingException {
		return objectMapper.writeValueAsString(this);
	}

	/*
	 * Getters and setters
	 */

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Long getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Long created_time) {
		this.created_time = created_time;
	}

	public Long getExpires_time() {
		return expires_time;
	}

	public void setExpires_time(Long expires_time) {
		this.expires_time = expires_time;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}
}
