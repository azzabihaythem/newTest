package com.haythem.integration;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.integration.ip.tcp.serializer.ByteArrayLfSerializer;
import org.springframework.integration.ip.tcp.serializer.SoftEndOfStreamException;

public class deser extends ByteArrayLfSerializer {

	// public deser(byte delimiter) {
	// super(delimiter);
	// // TODO Auto-generated constructor stub
	// }

	@Override
	public byte[] deserialize(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[this.maxMessageSize];
		int n = 0;
		int bite;
		if (logger.isDebugEnabled()) {
			logger.debug("Available to read:" + inputStream.available());
		}
		while (true) {
			bite = inputStream.read();
			// logger.debug("Read:" + (char) bite);
			if (bite < 0 && n == 0) {
				throw new SoftEndOfStreamException(
						"Stream closed between payloads");
			}
			checkClosure(bite);
			if (n == 11) {  // longeur fixe du trame tcp 
				break;
			}
			buffer[n++] = (byte) bite;
			if (n >= this.maxMessageSize) {
				throw new IOException(
						"LF not found before max message length: "
								+ this.maxMessageSize);
			}
		}
		;
		byte[] assembledData = new byte[n];
		System.arraycopy(buffer, 0, assembledData, 0, n);
		return assembledData;
	}

}
