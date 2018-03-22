package com.kevin.rabbit.hello;

import com.kevin.rabbit.MqttApp;
import com.kevin.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MqttApp.class)
public class TopicTest {

    @Autowired
    TopicSender topicSender;

    @Test
    public void topicSend() throws Exception {
        topicSender.send0();
        topicSender.send1();
        topicSender.send2();
    }
}
