package com.randomnoun.common.log4j;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/** An outputstream that writes to a log4j Logger. 
 * 
 * Log lines are separated by CRs (\r), LFs (\n), or CRLFs (\r\n)
 *
 * @author knoxg
 */
public class LoggingOutputStream extends OutputStream {
	Logger logger;
	StringBuffer line = new StringBuffer();
	PipedOutputStream pos;
	PipedInputStream pis;
	InputStreamReader isr;
	boolean startCrLf = false; // set to true after receiving a CR
	
	public LoggingOutputStream(Logger logger, Charset charset) throws IOException {
		this.logger = logger;
		this.pos = new PipedOutputStream();
		this.pis = new PipedInputStream(pos);
		this.isr = new InputStreamReader(pis, charset);
	}
	public LoggingOutputStream(Logger logger, String charsetName) throws IOException {
		this(logger, Charset.forName(charsetName));
	}
	public LoggingOutputStream(Logger logger) throws IOException {
		this(logger, Charset.defaultCharset());
	}
	
	@Override
	public void write(int b) throws IOException {
		
		pos.write(b);
		int ch = isr.read();
		if (ch == -1) {
			// not a full character
		} else if (ch == 13) {
			logger.info(line); line.setLength(0);
			startCrLf = true;
		} else if (ch == 10) {
			if (!startCrLf) {
				logger.info(line); line.setLength(0);
			}
			startCrLf = false;
		} else { 
			line.append((char) b);
			startCrLf = false;
		}
	}
}