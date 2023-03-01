package ru.natali.shop.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.natali.shop.model.entity.*;
import ru.natali.shop.repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {
//
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final BucketRepository bucketRepository;
//
//
    @GetMapping(value = "/test1")
    public void test() {
        var bucket = bucketRepository.save(new BucketEntity());

        UserEntity userEntity = new UserEntity();
        userEntity.setBucket(bucket);
        userEntity.setName("Иван");
        userRepository.save(userEntity);
    }

    @GetMapping(value = "/test2")
    public void addClient() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setPrice(new BigDecimal("100"));
        productEntity = productRepository.save(productEntity);

        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.add(productEntity);

        var user = userRepository.findById(1L);
        user.get().getBucket().setProductList(productEntityList);

        userRepository.save(user.get());
    }

    @GetMapping(value = "/test3")
    public void addProductInBucket() {
        var user = userRepository.findById(1l);
        System.out.println(user.get());
    }

    @GetMapping(value = "/test4")
    public void addProductInBucke2t() {
        var order = orderRepository.save(new OrderEntity());

        var user = userRepository.findById(1L);
        var productList = user.get().getBucket().getProductList();

        var details = orderDetailsRepository.save(new OrderDetailsEntity());

        details.setProduct(productList.get(0));
        details.setPrice(productList.get(0).getPrice());
        List<OrderDetailsEntity> orderDetailsEntityList = new ArrayList<>();
        orderDetailsEntityList.add(details);

        order.setDetailsList(orderDetailsEntityList);
        order.setUser(user.get());

        orderRepository.save(order);
    }

    @GetMapping(value = "/test5")
    public void addProductInBucke2t3() {

        var order = orderRepository.findById(1l);
        var user = userRepository.findById(1l);
        System.out.println(user.get().getOrderEntityList());
    }


    // Нужен товар, и пользователь с корзиной
//    @GetMapping(value = "/test3")
//    public void addProductInBucket(@RequestBody List<ProductDto> productList) {
//        log.info("Запрос /addProduct: {}", productList);
//        var clientOptional = userRepository.findById(1L);
//
//        if (clientOptional.isPresent()) {
//            var client = clientOptional.get();
//
//            productList.forEach(productDto -> {
//                var product = productRepository.findById(productDto.getId());
//                product.ifPresent(productEntity -> client.getBucket().getProductList().add(productEntity));
//            });
//
//            log.info("Выполняется обновление корзины клиента...");
//            userRepository.save(client);
//            log.info("Обновление корзины клиента выполнено успешно");
//        }
//    }
//
//    @PostMapping(value = "/createOrder")
//    public void createOrder(Long userId) {
//        log.info("Запрос /createOrder");
//
//        var clientOptional = userRepository.findById(1L);
//        var order = new OrderEntity();
//        List<OrderDetailsEntity> orderDetailsList = new ArrayList();
//
//        Set<Long> idSet = new HashSet<>();
//
//
//        if (clientOptional.isPresent()) {
//            log.info("Клиент найден");
//            var bucket = clientOptional.get().getBucket();
//
//            bucket.getProductList().forEach(e -> idSet.add(e.getId()));
//
//
//            idSet.forEach(productId -> {
//                var product = getProduct(productId, bucket.getProductList());
//                if (product.isPresent()) {
//                    var orderDetails = OrderDetailsEntity.builder()
////                            .order(order)
////                            .product(product.get())
//                            .amount((int)(getAmountProductInBucketProductList(bucket, productId)))
//                            .price(product.get().getPrice())
//                            .build();
//                    orderDetailsList.add(orderDetails);
//                }
//            });
//            order.setId(1L);
//            order.setClient(clientOptional.get());
//            order.setDetails(orderDetailsList);
//            order.setStatus("В обработке");
//            order.setSum(orderDetailsList.stream().reduce(BigDecimal.ZERO, (pre, e) -> pre.add(e.getPrice()), BigDecimal::add));
//
//            log.info("Выполняется сохранение заказа...");
//            orderRepository.save(order);
//            log.info("Сохранение заказа выполнено успешно");
//        } else {
//            log.info("Клиент не найден");
//        }
//    }
//
//    @Transactional
//    @GetMapping(value = "/order")
//    public OrderEntity getCurrentOrder() {
//        log.info("Запрос /order GET");
//        var client = new ClientEntity();
//        client.setId(1L);
//        return orderRepository.findOrderEntityById(1L).get();
//    }
//
//    public long getAmountProductInBucketProductList(BucketEntity bucket, Long productId) {
//        return bucket.getProductList().stream().filter(e -> e.getId().equals(productId)).count();
//    }
//
//    public Optional<ProductEntity> getProduct(Long id, List<ProductEntity> productEntityList) {
//        return productEntityList.stream().filter(e -> e.getId().equals(id)).findFirst();
//    }
}
