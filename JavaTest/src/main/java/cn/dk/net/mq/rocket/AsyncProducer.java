package cn.dk.net.mq.rocket;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer mqProducer = new DefaultMQProducer("TEST_Producer_asynchronous");
        mqProducer.setNamesrvAddr("115.29.66.74:9876");
        mqProducer.setRetryTimesWhenSendAsyncFailed(100);
        mqProducer.start();


        try {
            for (int i = 0; i < 10; i++) {
                final int index = i;
                Message message = new Message("TEST_Topic", "TEST_Tag_A", "AsyncID123",
                        ("Hello RocketMQ Asynchronous" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                mqProducer.send(message, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.printf("%-10d OK %s %n", index,
                                sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        System.out.printf("%-10d Exception %s %n", index, throwable);
                        throwable.printStackTrace();
                    }
                });
            }
        } finally {
            mqProducer.shutdown();
        }

    }
}
