package com.buxiaoxia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * Created by xw on 2017/2/20.
 * 2017-02-20 16:51
 */
@SpringBootApplication
@EnableBinding({PayValidateSink.class,PayOutputSink.class})
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private PayOutputSink payOutputSink;


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        payOutputSink.afterLoanComplete().send(MessageBuilder.withPayload("adfadf").build());
    }


    public void lotory() {

    }

    @StreamListener("inputBinding")
    public void getMessage(Message message) {
        Long startTime = System.currentTimeMillis();
        log.info("接收到死信队列的消息{}",message);
        Long endTime = System.currentTimeMillis();
        log.info("耗时{}", endTime-startTime);
    }

}


