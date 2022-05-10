package com.example.testnvs.Service.impl;
import com.example.testnvs.Dto.ProductDto;
import com.example.testnvs.Entity.ProductEntity;
import com.example.testnvs.Repository.ProductRepository;
import com.example.testnvs.Service.service.ProductService;
import com.example.testnvs.enums.ResponseStatusCode;
import com.example.testnvs.json.CustomPage;
import com.example.testnvs.json.DataResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class ProductImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public DataResponse<CustomPage> findAll(int pageNumber, int pageSize) {
        DataResponse<CustomPage> rs = new DataResponse<>(ResponseStatusCode.OK);
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("createdAt").ascending());
            Page<ProductEntity> page = productRepository.findAll(pageable);
            CustomPage customPage = new CustomPage(page);
            rs.setData(customPage);
        } catch (Exception e) {
            throw e;
        }
        return rs;
    }

    @Override
    public DataResponse<ProductEntity> created(ProductDto productDto) {
        DataResponse<ProductEntity>rs=new DataResponse<>(ResponseStatusCode.OK);
        try {
            ProductEntity product=new ProductEntity();
            Date currentDate=new Date();
            product.setCreatedAt(currentDate);
            if (StringUtils.isNotEmpty(productDto.getName())){
                product.setName(productDto.getName());
            }else {
                return new DataResponse<>(ResponseStatusCode.NAME_IS_EMPTY);
            }
            if (StringUtils.isNotEmpty(productDto.getTitle())){
                product.setTitle(productDto.getTitle());
            }else {
                return new DataResponse<>(ResponseStatusCode.NAME_IS_EMPTY);
            }if (StringUtils.isNotEmpty(productDto.getPrice())){
                product.setPrice(productDto.getPrice());
            }else {
                return new DataResponse<>(ResponseStatusCode.NAME_IS_EMPTY);
            }
            product.setUpdateAt(productDto.getUpdateAt());
            product=productRepository.save(product);
            rs.setData(product);
        }catch (Exception e){
            throw e;
        }
        return rs;
    }

    @Override
    public DataResponse<ProductEntity> update(ProductDto productDto) {
        DataResponse<ProductEntity>rs=new DataResponse<>(ResponseStatusCode.OK);
        try {
            Optional<ProductEntity> product=productRepository.findById(productDto.getId());
            ProductEntity productUpdate=new ProductEntity();
            if (product.isPresent()){
                productUpdate.setName(productDto.getName());
                productUpdate.setPrice(productDto.getPrice());
                productUpdate.setTitle(productDto.getTitle());
                productUpdate=productRepository.save(productUpdate);
                rs.setData(productUpdate);
            }

        }catch (Exception e){
            throw e;
        }
        return rs;
    }

    @Override
    public DataResponse<ProductEntity> delete(Long id) {
        DataResponse<ProductEntity>rs=new DataResponse<>(ResponseStatusCode.OK);
        try {
            Optional<ProductEntity>product=productRepository.findById(id);
            if (StringUtils.isNotEmpty(product.toString())){
                productRepository.delete(product.get());
            }
        }catch (Exception e){
            throw e;
        }
        return rs;
    }
}
