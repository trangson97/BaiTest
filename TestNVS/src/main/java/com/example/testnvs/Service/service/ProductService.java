package com.example.testnvs.Service.service;

import com.example.testnvs.Dto.ProductDto;
import com.example.testnvs.Entity.ProductEntity;
import com.example.testnvs.json.CustomPage;
import com.example.testnvs.json.DataResponse;


public interface ProductService {
    DataResponse<CustomPage> findAll(String name, int pageNumber, int pageSize);

    DataResponse<ProductEntity> created(ProductDto productDto);

    DataResponse<ProductEntity> update(ProductDto productDto);

    DataResponse<ProductEntity> delete(Long id);
}
