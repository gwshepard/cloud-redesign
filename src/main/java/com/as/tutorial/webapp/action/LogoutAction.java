package com.as.tutorial.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LogoutAction
 * 
 * This source code is included for convenience with tutorial 
 * distributions in PDF form, from which it is more difficult 
 * to accurately copy text than from other document formats.
 * 
 * This source code is included as-is, without warranty or conditions 
 * of any kind, either expressed or implied. We make no guarantee of 
 * the fitness of the source code for any use to which it may be put. 
 * Neither the author(s), nor ArcTech Software LLC, nor any of its agents, 
 * will be held liable for damages, caused or alleged, directly 
 * or indirectly, by any use of this source code.
 * 
 * Terms and Conditions: http://www.arctechsoftware.com/tutorial/termsPage.do
 */
public class LogoutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3310218058082703690L;
	private Map session;
	
	/**
	 * Creates an instance of LogoutAction.
	 */
	public LogoutAction() {
		super();
	}

	/**
	 * Handles a user's logout request.
	 * 
	 * @return result String
	 */
	@Override
	public String execute() {
		this.getSession().remove("registration");
		return SUCCESS;
	}

	public Map getSession() {
		return session;
	}

	/**
	 * The ServletConfigInterceptor calls this method with a Map of the session attributes.
	 */
	public void setSession(Map session) {
		this.session = session;
	}

}
