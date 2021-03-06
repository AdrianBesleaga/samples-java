package io.serialized.samples.orderservice.integration;

import io.serialized.samples.orderservice.api.TransportObject;

public class OrderProjection extends Projection {

  public ProjectionData data;

  public static class ProjectionData extends TransportObject {
    public String customerId;
    public Long orderAmount;
    public String status;
    public String trackingNumber;
  }

}
