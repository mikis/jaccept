package org.jaccept;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public abstract class ClientLoader {

    private static final Logger log = Logger.getLogger(ClientLoader.class);

	public static void loadClients(String clients) {
		StringTokenizer st = new StringTokenizer(clients,",");
		while (st.hasMoreElements()) {
			String clientClass = (String)st.nextElement();
			try {
				log.info("Adding JAccept client "+clientClass);
				TestEventListener client = (TestEventListener)Class.forName(clientClass).newInstance();
				TestEventManager.addTestListener(client);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
