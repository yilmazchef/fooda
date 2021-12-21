package be.fooda.backend.payment.view.controller;

import be.fooda.backend.commons.model.payment.create.*;
import be.fooda.backend.commons.model.payment.update.*;
import be.fooda.backend.payment.dao.*;
import be.fooda.backend.payment.model.entity.*;
import be.fooda.backend.payment.model.http.FoodaPaymentHttpFailureMessages;
import be.fooda.backend.payment.model.http.FoodaPaymentHttpSuccessMessages;
import be.fooda.backend.payment.service.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("api/v1/payment")
public class FoodaPaymentController {

    // Parent DI ..
    private final FoodaPaymentRepository paymentRepository;
    private final FoodaPaymentIndexRepository indexRepository;
    private final FoodaPaymentMapper mapper;

    // Item DI ..
    private final FoodaPaymentItemRepository itemRepository;
    private final FoodaPaymentItemMapper itemMapper;

    // Order DI ..
    private final FoodaPaymentOrderRepository orderRepository;
    private final FoodaPaymentOrderMapper orderMapper;

    // Store DI ..
    private final FoodaPaymentStoreRepository storeRepository;
    private final FoodaPaymentStoreMapper storeMapper;

    // User DI ..
    private final FoodaPaymentUserRepository userRepository;
    private final FoodaPaymentUserMapper userMapper;

//    PAYMENT END POINTS

    @GetMapping("get_payment_by_id")
    public ResponseEntity getPaymentById(@RequestParam Long paymentId) {

        final Optional<FoodaPayment> foundPayment = paymentRepository.findById(paymentId);

        if (foundPayment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundPayment);
    }

    @GetMapping("get_all_payments")
    public ResponseEntity getAllPayments(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "25") int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<FoodaPayment> pageProducts = paymentRepository.findAll(paging);
        if (!pageProducts.hasContent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PRODUCTS_FOUND);
        }

        List<FoodaPayment> products = pageProducts.getContent();
        return ResponseEntity.status(HttpStatus.FOUND).body(products);
    }

    @GetMapping("get_payments_by_external_store_id")
    public ResponseEntity getPaymentsByExternalStoreId(@RequestParam Long externalStoreId) {

        final List<FoodaPayment> foundPayments = paymentRepository.findByOrder_Store_ExternalStoreId(externalStoreId);

        if (foundPayments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENTS_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundPayments);
    }

    @GetMapping("get_payments_by_external_user_id")
    public ResponseEntity getPaymentsByExternalUserId(@RequestParam Long externalUserId) {

        final List<FoodaPayment> foundPayments = paymentRepository.findByUser_ExternalUserId(externalUserId);

        if (foundPayments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENTS_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundPayments);
    }

    @GetMapping("get_payment_by_external_order_id")
    public ResponseEntity getPaymentByExternalOrderId(@RequestParam Long externalOrderId) {

        final Optional<FoodaPayment> foundPayments = paymentRepository.findByOrder_ExternalOrderId(externalOrderId);

        if (foundPayments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENTS_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundPayments);
    }

    @PostMapping("create_payment")
    public ResponseEntity createPayment(@RequestBody FoodaPaymentCreate paymentCreate) {

        final Long externalStoreId = paymentCreate.getOrder().getStore().getExternalStoreId();
        final Long externalUserId = paymentCreate.getUser().getExternalUserId();

        if (externalStoreId == null || externalUserId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FoodaPaymentHttpFailureMessages.REQUIRED_FIELDS_ARE_MISSING_IN_CREATE_REQUEST);
        }

        if (paymentRepository.existByUniqueFields(externalStoreId, externalUserId)) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(FoodaPaymentHttpFailureMessages.PAYMENT_ALREADY_EXIST);
        }

        // CLIENT EXIST CHECKS ..

        paymentRepository.save(mapper.fromCreateToEntity(paymentCreate));
        return ResponseEntity.status(HttpStatus.CREATED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_CREATED);
    }

    @PutMapping("update_payment_by_id")
    public ResponseEntity updatePaymentById(@RequestParam Long id, @RequestBody FoodaPaymentUpdate paymentUpdate) {

        final Optional<FoodaPayment> foundPayment = paymentRepository.findById(id);

        if (foundPayment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_DOES_NOT_EXIST);
        }

        FoodaPayment paymentBeingUpdated = mapper.fromUpdateToEntity(paymentUpdate, foundPayment.get());

        paymentRepository.save(paymentBeingUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_UPDATED);
    }

    @PatchMapping("delete_payment_by_id")
    public ResponseEntity deletePaymentById(@RequestParam Long id) {
        Optional<FoodaPayment> foundPayment = paymentRepository.findById(id);

        if (foundPayment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_DOES_NOT_EXIST);
        }

        FoodaPayment paymentBeingDeleted = foundPayment.get();
        paymentBeingDeleted.setIsActive(Boolean.FALSE);
        paymentRepository.save(paymentBeingDeleted);

        if (!paymentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(FoodaPaymentHttpFailureMessages.PAYMENT_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_DELETED);

    }

    @PatchMapping("delete_payment_by_external_order_id")
    public ResponseEntity deletePaymentByExternalOrderId(@RequestParam Long externalOrderId) {
        Optional<FoodaPayment> foundPayment = paymentRepository.findByOrder_ExternalOrderId(externalOrderId);

        if (foundPayment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_DOES_NOT_EXIST);
        }

        FoodaPayment paymentBeingDeleted = foundPayment.get();
        paymentBeingDeleted.setIsActive(Boolean.FALSE);
        paymentRepository.save(paymentBeingDeleted);

        if (!paymentRepository.existsByOrder_ExternalOrderId(externalOrderId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(FoodaPaymentHttpFailureMessages.PAYMENT_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_DELETED);

    }

//    @GetMapping("search")
//    public ResponseEntity search(@RequestParam Set<String> keywords, Integer pageNo, Integer pageSize) {
//
//        final List<FoodaPayment> foundPayments = indexRepository.combined(keywords, PageRequest.of(pageNo, pageSize));
//
//        if (foundPayments.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENTS_FOUND);
//        }
//
//        return ResponseEntity.status(HttpStatus.FOUND).body(foundPayments);
//    }

    @GetMapping("payment_exists")
    public ResponseEntity paymentExistsById(@RequestParam Long id) {

        if (!paymentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(FoodaPaymentHttpSuccessMessages.PAYMENT_EXISTS);
    }


    // PAYMENT ITEM SERVICE ENDPOINTS //


    @GetMapping("get_item_by_id")
    public ResponseEntity getItemByItemId(@RequestParam Long itemId) {

        final Optional<FoodaPaymentItem> foundItem = itemRepository.findById(itemId);

        if (foundItem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundItem);
    }

    @GetMapping("get_items_by_payment_id")
    public ResponseEntity getItemsByPaymentId(@RequestParam Long paymentId) {

        final List<FoodaPaymentItem> foundItems = itemRepository.findByPayment_Id(paymentId);

        if (!paymentRepository.existsById(paymentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_DOES_NOT_EXIST);
        }

        if (foundItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_HAS_NO_PAYMENT_ITEMS);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundItems);
    }

    @GetMapping("get_all_items")
    public ResponseEntity getAllItems(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {

        final List<FoodaPaymentItem> foundItems = itemRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();

        if (foundItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_ITEMS_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundItems);
    }

    @PostMapping("create_item")
    public ResponseEntity createItem(@RequestBody FoodaPaymentItemCreate toCreate) {

        final Optional<FoodaPaymentItem> foundItem = Optional.of(itemRepository.save(itemMapper.fromCreateToEntity(toCreate)));

        if (foundItem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_COULD_NOT_BE_CREATED);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(foundItem);
    }

    @PutMapping("update_item_by_id")
    public ResponseEntity updateItemByItemId(@RequestParam Long id, @RequestBody FoodaPaymentItemUpdate item) {

        final Optional<FoodaPaymentItem> foundItem = itemRepository.findById(id);

        if (foundItem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_DOES_NOT_EXIST);
        }

        FoodaPaymentItem itemBeingUpdated = itemMapper.fromUpdateToEntity(item, foundItem.get());

        itemRepository.save(itemBeingUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ITEM_UPDATED);
    }

    @DeleteMapping("delete_item_by_id")
    public ResponseEntity deleteItemByItemId(@RequestParam Long id) {

        if (!itemRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_DOES_NOT_EXIST);
        }

        itemRepository.deleteById(id);

        if (itemRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ITEM_DELETED);
    }

    @DeleteMapping("delete_items_by_payment_id")
    public ResponseEntity deleteItemsByPaymentId(@RequestParam Long paymentId) {

        boolean hasAnyPaymentItem = itemRepository.existsByPayment_Id(paymentId);

        if (!hasAnyPaymentItem) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_ITEMS_FOUND);
        }

        itemRepository.deleteByPayment_Id(paymentId);

        boolean stillHasAnyItems = itemRepository.existsByPayment_Id(paymentId);

        if (stillHasAnyItems) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_LIST_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ITEM_LIST_DELETED);
    }

    @GetMapping("item_exits")
    public ResponseEntity itemExistsById(@RequestParam Long id) {

        if (!itemRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ITEM_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ITEM_EXISTS);
    }

    // ORDER SERVICE ENDPOINTS //

    @GetMapping("get_order_by_id")
    public ResponseEntity getOrderById(@RequestParam Long id) {

        final Optional<FoodaPaymentOrder> foundOrder = orderRepository.findById(id);

        if (foundOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundOrder);
    }

    @GetMapping("get_order_by_payment_id")
    public ResponseEntity getOrderByPaymentId(@RequestParam Long paymentId) {

        final Optional<FoodaPaymentOrder> foundOrder = orderRepository.findByPayment_Id(paymentId);

        if (foundOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundOrder);
    }

    @GetMapping("get_all_orders")
    public ResponseEntity getAllOrders(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {

        final List<FoodaPaymentOrder> foundOrders = orderRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();

        if (foundOrders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_ORDERS_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundOrders);
    }

    @PostMapping("create_order")
    public ResponseEntity createOrder(@RequestBody FoodaPaymentOrderCreate toCreate) {

        final Optional<FoodaPaymentOrder> foundOrder = Optional.of(orderRepository.save(orderMapper.fromCreateToEntity(toCreate)));

        if (foundOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_COULD_NOT_BE_CREATED);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(foundOrder);
    }

    @PutMapping("upate_order")
    public ResponseEntity updateOrderByOrderId(@RequestParam Long id, @RequestBody FoodaPaymentOrderUpdate order) {

        final Optional<FoodaPaymentOrder> foundOrder = orderRepository.findById(id);

        if (foundOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_DOES_NOT_EXIST);
        }

        FoodaPaymentOrder orderBeingUpdated = orderMapper.fromUpdateToEntity(order, foundOrder.get());

        orderRepository.save(orderBeingUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ORDER_UPDATED);
    }

    @DeleteMapping("delete_order")
    public ResponseEntity deleteOrderByOrderId(@RequestParam Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_DOES_NOT_EXIST);
        }

        orderRepository.deleteById(id);

        if (orderRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ORDER_DELETED);
    }

    @DeleteMapping("delete_orders_by_payment_id")
    public ResponseEntity deleteOrdersByPaymentId(@RequestParam Long paymentId) {
        boolean hasAnyPaymentOrder = orderRepository.existsByPayment_Id(paymentId);

        if (!hasAnyPaymentOrder) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_ORDERS_FOUND);
        }

        orderRepository.deleteByPayment_Id(paymentId);

        boolean stillHasAnyOrders = orderRepository.existsByPayment_Id(paymentId);

        if (stillHasAnyOrders) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_LIST_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ORDER_LIST_DELETED);
    }

    @GetMapping("order_exists")
    public ResponseEntity orderExistsByOrderId(@RequestParam Long id) {

        if (!orderRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_ORDER_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(FoodaPaymentHttpSuccessMessages.PAYMENT_ORDER_EXISTS);
    }

    // STORE SERVICE ENDPOINTS //

    @GetMapping("get_store")
    public ResponseEntity getStoreById(@RequestParam Long id) {

        final Optional<FoodaPaymentStore> foundStore = storeRepository.findById(id);

        if (foundStore.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundStore);
    }

    @GetMapping("get_stores_by_payment_id")
    public ResponseEntity getStoresByPaymentId(@RequestParam Long paymentId) {

        final List<FoodaPaymentStore> foundStores = storeRepository.findByOrder_Payment_Id(paymentId);

        if (foundStores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundStores);
    }

    @GetMapping("get_stores_by_external_order_id")
    public ResponseEntity getStoresByExternalOrderId(@RequestParam Long externalOrderId) {

        final List<FoodaPaymentStore> foundStores = storeRepository.findByOrder_ExternalOrderId(externalOrderId);

        if (foundStores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORES_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundStores);
    }

    @GetMapping("get_all_stores")
    public ResponseEntity getAllStores(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {

        final List<FoodaPaymentStore> foundStores = storeRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();

        if (foundStores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_STORES_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundStores);
    }

    @PostMapping("create_store")
    public ResponseEntity createStore(@RequestBody FoodaPaymentStoreCreate toCreate) {

        final Optional<FoodaPaymentStore> foundStore = Optional.of(storeRepository.save(storeMapper.fromCreateToEntity(toCreate)));

        if (foundStore.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_COULD_NOT_BE_CREATED);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(foundStore);
    }

    @PutMapping("update_store")
    public ResponseEntity updateStoreByStoreId(@RequestParam Long id, @RequestBody FoodaPaymentStoreUpdate store) {

        final Optional<FoodaPaymentStore> foundStore = storeRepository.findById(id);

        if (foundStore.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_DOES_NOT_EXIST);
        }

        FoodaPaymentStore storeBeingUpdated = storeMapper.fromUpdateToEntity(store, foundStore.get());

        storeRepository.save(storeBeingUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_STORE_UPDATED);
    }

    @DeleteMapping("delete_store")
    public ResponseEntity deleteStoreByStoreId(@RequestParam Long id) {
        if (!storeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_DOES_NOT_EXIST);
        }

        storeRepository.deleteById(id);

        if (storeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_STORE_DELETED);
    }

    @DeleteMapping("delete_stores_by_payment_id")
    public ResponseEntity deleteStoresByPaymentId(@RequestParam Long paymentId) {
        boolean hasAnyPaymentStore = storeRepository.existsByOrder_Payment_Id(paymentId);

        if (!hasAnyPaymentStore) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_STORES_FOUND);
        }

        storeRepository.deleteByOrder_Payment_Id(paymentId);

        boolean stillHasAnyStores = storeRepository.existsByOrder_Payment_Id(paymentId);

        if (stillHasAnyStores) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_LIST_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_STORE_LIST_DELETED);
    }

    @DeleteMapping("delete_stores_by_external_order_id")
    public ResponseEntity deleteStoresByExternalOrderId(@RequestParam Long externalOrderId) {
        boolean hasAnyStore = storeRepository.existsByOrder_ExternalOrderId(externalOrderId);

        if (!hasAnyStore) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_STORES_FOUND);
        }

        storeRepository.deleteByOrder_ExternalOrderId(externalOrderId);

        boolean stillHasAnyStores = storeRepository.existsByOrder_ExternalOrderId(externalOrderId);

        if (stillHasAnyStores) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_LIST_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_STORE_LIST_DELETED);
    }

    @GetMapping("store_exists")
    public ResponseEntity storeExistsByStoreId(@RequestParam Long id) {

        if (!storeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_STORE_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(FoodaPaymentHttpSuccessMessages.PAYMENT_STORE_EXISTS);
    }


    //USER SERVICE ENDPOINTS //

    @GetMapping("get_user")
    public ResponseEntity getUserById(@RequestParam Long id) {

        final Optional<FoodaPaymentUser> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundUser);
    }

    @GetMapping("get_user_by_payment_id")
    public ResponseEntity getUserByPaymentId(@RequestParam Long paymentId) {

        final Optional<FoodaPaymentUser> foundUser = userRepository.findByPayment_Id(paymentId);

        if (foundUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundUser);
    }

    @GetMapping("get_all_users")
    public ResponseEntity getAllUsers(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {

        final List<FoodaPaymentUser> foundUsers = userRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();

        if (foundUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_USERS_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(foundUsers);
    }

    @PostMapping("create_user")
    public ResponseEntity createUser(@RequestBody FoodaPaymentUserCreate toCreate) {

        final Optional<FoodaPaymentUser> foundUser = Optional.of(userRepository.save(userMapper.fromCreateToEntity(toCreate)));

        if (foundUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_COULD_NOT_BE_CREATED);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(foundUser);
    }

    @PutMapping("update_user")
    public ResponseEntity updateUserByUserId(@RequestParam Long id, @RequestBody FoodaPaymentUserUpdate user) {

        final Optional<FoodaPaymentUser> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_DOES_NOT_EXIST);
        }

        FoodaPaymentUser userBeingUpdated = userMapper.fromUpdateToEntity(user, foundUser.get());

        userRepository.save(userBeingUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_USER_UPDATED);
    }

    @DeleteMapping("delete_user")
    public ResponseEntity deleteUserByUserId(@RequestParam Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_DOES_NOT_EXIST);
        }

        userRepository.deleteById(id);

        if (userRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_USER_DELETED);
    }

    @DeleteMapping("delete_user_by_payment_id")
    public ResponseEntity deleteUsersByPaymentId(@RequestParam Long paymentId) {
        boolean hasAnyPaymentUser = userRepository.existsByPayment_Id(paymentId);

        if (!hasAnyPaymentUser) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.NO_PAYMENT_USERS_FOUND);
        }

        userRepository.deleteByPayment_Id(paymentId);

        boolean stillHasAnyUsers = userRepository.existsByPayment_Id(paymentId);

        if (stillHasAnyUsers) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_LIST_COULD_NOT_BE_DELETED);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(FoodaPaymentHttpSuccessMessages.PAYMENT_USER_LIST_DELETED);
    }

    @GetMapping("user_exists")
    public ResponseEntity userExistsByUserId(@RequestParam Long id) {

        if (!userRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FoodaPaymentHttpFailureMessages.PAYMENT_USER_DOES_NOT_EXIST);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(FoodaPaymentHttpSuccessMessages.PAYMENT_USER_EXISTS);
    }
}
