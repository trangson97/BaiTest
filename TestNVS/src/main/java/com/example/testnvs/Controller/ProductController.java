package com.example.testnvs.Controller;

import com.example.testnvs.Dto.ProductDto;
import com.example.testnvs.Entity.ProductEntity;
import com.example.testnvs.Service.service.ProductService;
import com.example.testnvs.json.CustomPage;
import com.example.testnvs.json.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public DataResponse<CustomPage> findAll(@RequestParam(name = "pageNumber", defaultValue = "10") int pageNumber,
                                            @RequestParam(name = "pageSize", defaultValue = "0") int pageSize) {
        return productService.findAll(pageNumber, pageSize);
    }

    @PostMapping("")
    public DataResponse<ProductEntity> created(@RequestBody ProductDto productDto) {
        return productService.created(productDto);
    }

    @PutMapping("/{id}")
    public DataResponse<ProductEntity> update(@PathVariable(name = "id") Long id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        return productService.update(productDto);
    }

    @DeleteMapping("/{id}")
    public DataResponse<ProductEntity> delete(@PathVariable(name = "id") Long id) {
        return productService.delete(id);
    }
}
