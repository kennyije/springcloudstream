package com.buxiaoxia;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Lenovo on 2018/10/19.
 */
public interface PayValidateSink {

    @Input("inputBinding")
    SubscribableChannel bindingsOf1();
}
