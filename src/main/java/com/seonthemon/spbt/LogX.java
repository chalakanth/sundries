package com.seonthemon.spbt;

import org.slf4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public final class LogX {

	
	private LogX() {
		
	}
	
	private static XStream xstream = new XStream(new StaxDriver());
	
	public static void debug(Logger log, String msg, Object obj) {
		if (log.isDebugEnabled()) {
			log.debug(msg + "\n" + xstream.toXML(obj));
		}
	}
	
}
