package com.agan.book.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISendService {
	
	@Output("agan-exchange")
	SubscribableChannel send();
}
