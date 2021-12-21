package be.fooda.backend.customer.service.mapper;

import be.fooda.backend.customer.model.dto.*;
import be.fooda.backend.customer.model.entity.CustomerEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {

    CustomerEntity toEntity(CreateCustomerRequest source);

    CustomerEntity toEntity(UpdateCustomerRequest source, @MappingTarget CustomerEntity target);

    CreateCustomerRequest toCreate(CustomerEntity source);

    UpdateCustomerRequest toUpdate(CustomerEntity source, @MappingTarget UpdateCustomerRequest target);

    CustomerResponse toResponse(CustomerEntity source);

    @Mapping(target = "customer.id", source = "id")
    @Mapping(target = "user.userId", source = "id")
    List<CustomerResponse> toResponses(List<CustomerEntity> sourceList);

    default AddressResponse toAddressResponse(Long addressId) {
        AddressResponse response = new AddressResponse();
        response.setAddressId(addressId);
        return response;
    }

    default Long toAddressPK(AddressResponse address) {
        return address.getAddressId();
    }

    default ContactResponse toContactResponse(Long contactId) {
        ContactResponse response = new ContactResponse();
        response.setContactId(contactId);
        return response;
    }

    default Long toContactPK(ContactResponse contact) {
        return contact.getContactId();
    }

    default OrderResponse toOrderResponse(Long orderId) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(orderId);
        return response;
    }

    default Long toOrderPK(OrderResponse order) {
        return order.getOrderId();
    }

    default PaymentResponse toPaymentResponse(Long paymentId) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(paymentId);
        return response;
    }

    default Long toPaymentPK(PaymentResponse payment) {
        return payment.getPaymentId();
    }

    default ProductResponse toProductResponse(Long productId) {
        ProductResponse response = new ProductResponse();
        response.setProductId(productId);
        return response;
    }

    default Long toProductPK(ProductResponse product) {
        return product.getProductId();

    }

    default StoreResponse toStoreResponse(Long storeId) {
        StoreResponse response = new StoreResponse();
        response.setStoreId(storeId);
        return response;
    }

    default Long toStorePK(StoreResponse store) {
        return store.getStoreId();

    }

    default UserResponse toUserResponse(Long userId) {
        UserResponse response = new UserResponse();
        response.setUserId(userId);
        return response;
    }

    default Long toUserPK(UserResponse user) {
        return user.getUserId();
    }
}
