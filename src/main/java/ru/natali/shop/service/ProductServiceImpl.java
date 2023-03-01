package ru.natali.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.natali.shop.mapper.ProductMapper;
import ru.natali.shop.model.dto.ProductDto;
import ru.natali.shop.model.entity.ProductEntity;
import ru.natali.shop.repository.ProductRepository;
import ru.natali.shop.service.api.ProductService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public void addProduct(ProductDto productDto) {
        var productEntity = mapper.toEntity(productDto);
        saveProduct(productEntity);
    }

    private ProductEntity saveProduct(ProductEntity productEntity) {
        try {
            log.info("Попытка сохраниния записи product в БД: {}", productEntity);
            productEntity = repository.save(productEntity);
            log.info("Сохранение выполнено успешно: {}", productEntity);

            return productEntity;
        } catch (Exception ex) {
            log.error("Ошибка при сохранении", ex);
            // TODO обработать
            throw ex;
        }
    }
}
