package com.kevin.rabbit.hello;

import com.kevin.rabbit.MqttApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MqttApp.class)
public class HelloTest {
    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            helloSender.send();
        }
    }
}
