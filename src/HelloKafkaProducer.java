import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Created by user on 8/4/14.
 */
public class HelloKafkaProducer {
    //final static String TOPIC = "Cary";
	final static String[] TOPIC = {"1","2","3","4","5","6","7","8","9","10"};

    public static void main(String[] argv){
        Properties properties = new Properties();
        properties.put("metadata.broker.list","localhost:9092");
        properties.put("serializer.class","kafka.serializer.StringEncoder");
        ProducerConfig producerConfig = new ProducerConfig(properties);
        kafka.javaapi.producer.Producer<String,String> producer = new kafka.javaapi.producer.Producer<String, String>(producerConfig);
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println("Start time for producer: "+System.currentTimeMillis());
        for(int i=0;i<10;i++){
        	System.out.println(TOPIC[i]);
        	for(int j=0;j<1000;j++){
        KeyedMessage<String, String> message =new KeyedMessage<String, String>(TOPIC[i],"Test message " + j);
        producer.send(message);
        	}
        	//
        }
        producer.close();
    }
}