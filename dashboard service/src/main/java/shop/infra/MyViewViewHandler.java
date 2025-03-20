package shop.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shop.config.kafka.KafkaProcessor;
import shop.domain.*;

@Service
public class MyViewViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyViewRepository myViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyView myView = new MyView();
            // view 객체에 이벤트의 Value 를 set 함
            myView.setId(orderPlaced.getId());
            myView.setCustomerId(orderPlaced.getCustomerId());
            myView.setProductId(orderPlaced.getProductId());
            // view 레파지 토리에 save
            myViewRepository.save(myView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
