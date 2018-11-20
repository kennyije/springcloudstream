package com.buxiaoxia;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Lenovo on 2018/10/25.
 */
public interface PayOutputSink {

    @Output("outputBinding")
    MessageChannel afterLoanComplete();
}
