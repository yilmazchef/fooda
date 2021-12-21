package be.fooda.backend.order.service.mapper;

import be.fooda.backend.order.model.dto.*;
import be.fooda.backend.order.model.entity.OrderEntity;
import be.fooda.backend.order.model.entity.OrderStatus;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface OrderMapper {

    OrderEntity toEntity(CreateOrderRequest source);

    OrderEntity toEntity(UpdateOrderRequest source, @MappingTarget OrderEntity target);

    CreateOrderRequest toCreate(OrderEntity source);

    UpdateOrderRequest toUpdate(OrderEntity source, @MappingTarget UpdateOrderRequest target);

    @Mapping(target = "customer.customerId", source = "customerId")
    @Mapping(target = "delivery.deliveryId", source = "deliveryId")
    @Mapping(target = "store.storeId", source = "storeId")
    OrderResponse toResponse(OrderEntity source);

    default Long toEntityPK(ProductResponse request) {
        return request == null ? null : request.getProductId();
    }

    default ProductResponse toProductResponse(Long productId) {
        ProductResponse request = new ProductResponse();
        request.setProductId(productId);
        return request;
    }

    default Long toEntityPK(PaymentResponse request) {
        return request == null ? null : request.getPaymentId();
    }

    default OrderEntity toCloneEntity(OrderEntity source){

        OrderEntity target = new OrderEntity();

        target.setId(null);
        target.setTrackingId(source.getTrackingId()); // TODO check this
        target.setIsActive(source.getIsActive());
        target.setDeliveryId(source.getDeliveryId());
        target.setCustomerId(source.getCustomerId());
        target.setStoreId(source.getStoreId());
        target.setStatus(OrderStatus.PROCESSING);
        target.setNote(source.getNote());
        target.setRequiredAt(Timestamp.from(Instant.now().plusSeconds(60 * 60 * 1)));
        target.setCreatedAt(Timestamp.from(Instant.now()));
        target.setUpdatedAt(Timestamp.from(Instant.now()));
        target.setDeliveredAt(source.getDeliveredAt());
        target.setPaymentAt(source.getPaymentAt());
        target.setProductsTotal(source.getProductsTotal());
        target.setTaxTotal(source.getTaxTotal());
        target.setDeliveryTotal(source.getDeliveryTotal());
        target.setPriceTotal(source.getPriceTotal());
        target.setProducts(source.getProducts());
        target.setPayments(source.getPayments());

        return target;
    }

    default PaymentResponse toPaymentResponse(Long paymentId) {
        PaymentResponse request = new PaymentResponse();
        request.setPaymentId(paymentId);
        return request;
    }

    @Mapping(target = "customer.customerId", source = "customerId")
    List<OrderResponse> toResponses(List<OrderEntity> sourceList);

}