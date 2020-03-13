package com.notifysender;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;
import com.microsoft.azure.servicebus.Message;

public class Function {
    @FunctionName("sbprocessor")
    public void serviceBusProcess(
            @ServiceBusQueueTrigger(name = "msg",
                    queueName = "message-in",
                    connection = "ServiceBusConnection") String message,
            final ExecutionContext context
    ) {
        context.getLogger().info("Receiving message from service bus");
        context.getLogger().info("Message" + message);
        context.getLogger().info("Received message from service bus");
    }
}
