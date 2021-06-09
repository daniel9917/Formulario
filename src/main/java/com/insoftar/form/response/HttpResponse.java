package com.insoftar.form.response;

public class HttpResponse {
		
	private int status;
	private String message;
	private Object body;
	
	public HttpResponse() {
		// TODO Auto-generated constructor stub
	}

	public HttpResponse(int status, String message, Object body) {		
		this.status = status;
		this.message = message;
		this.body = body;
	}
	
	public HttpResponse(int status, String message) {		
		this.status = status;
		this.message = message;		
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
	
	
	

}
