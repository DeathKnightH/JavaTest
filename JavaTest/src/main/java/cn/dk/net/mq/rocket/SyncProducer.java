package cn.dk.net.mq.rocket;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class SyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer mqProducer = new DefaultMQProducer("TEST_Producer_synchronous");
        mqProducer.setNamesrvAddr("115.29.66.74:9876");
        mqProducer.start();

        for (int i = 0; i < 1000; i++) {
            Message message = new Message("TEST_Topic", "TEST_Tag_A", ("Hello RocketMQ" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = mqProducer.send(message);
            System.out.printf("%s%n", sendResult);
        }
        mqProducer.shutdown();
    }
}
