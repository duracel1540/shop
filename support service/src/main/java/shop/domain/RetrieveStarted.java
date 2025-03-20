package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RetrieveStarted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer quantity;
    private String address;
    private String orderId;

    public RetrieveStarted(Delivery aggregate) {
        super(aggregate);
    }

    public RetrieveStarted() {
        super();
    }
}
//>>> DDD / Domain Event
