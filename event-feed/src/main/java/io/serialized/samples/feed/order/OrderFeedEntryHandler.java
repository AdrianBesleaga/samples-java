package io.serialized.samples.feed.order;

import io.serialized.samples.feed.client.Feed;
import io.serialized.samples.feed.client.FeedEntryHandler;

import static java.lang.String.format;

public class OrderFeedEntryHandler implements FeedEntryHandler {

  @Override
  public void handle(Feed.FeedEntry feedEntry) {
    System.out.println("Processing entry with sequenceNumber: " + feedEntry.sequenceNumber);

    for (Feed.FeedEntry.Event event : feedEntry.events) {
      switch (event.eventType) {
        case "OrderPlacedEvent": {
          System.out.println(format("An order with ID [%s] was placed by [%s]", feedEntry.aggregateId, event.data.get("customerId")));
          break;
        }
        case "OrderPaidEvent": {
          System.out.println(format("The order with ID [%s] was paid", feedEntry.aggregateId));
          break;
        }
        case "OrderCancelledEvent": {
          System.out.println(format("The order with ID [%s] was cancelled", feedEntry.aggregateId));
          break;
        }
        default:
          throw new RuntimeException("Don't know how to handle events of type: " + event.eventType);
      }
    }
  }

}
