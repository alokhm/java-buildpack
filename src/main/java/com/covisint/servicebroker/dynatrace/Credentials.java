package com.covisint.servicebroker.dynatrace;

/**
 * Class: Credentials.java
 * Description: A holder for credential information such as the dynatrace server and profile name for the agent
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public final class Credentials {

    private final String server;
    private final String profile;

    
	/**
     * Creates a new instance with a given server and profile
     *
     * @param server  server to end point of collector and port
     * @param profile profile name for the agent
     */
    public Credentials(String server , String profile) {
        this.server = server;
        this.profile = profile;
    }

  

    /**
     * Returns the server 
     *
     * @return the server with hostip:port
     */
    public String getServer() {
		return server;
	}

    /**
     * Returns the profile 
     *
     * @return the profile name
     */
	public String getProfile() {
		return profile;
	}

}
