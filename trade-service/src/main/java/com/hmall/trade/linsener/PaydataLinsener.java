package com.hmall.trade.linsener;

import com.hmall.trade.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaydataLinsener {
    public final IOrderService orderService ;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "trade.pay.success.queue",durable = "true"),
                    exchange = @Exchange(name = "pay.direct"),
                    key = "pay.success"
            ))
    public void linsenSuccess(Long orderId){
        orderService.markOrderPaySuccess(orderId);
    }
}
