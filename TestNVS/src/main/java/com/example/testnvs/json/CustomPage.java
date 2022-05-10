package com.example.testnvs.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomPage {
    List<?> content;
    PageInfo pageInfo;

    public CustomPage(Page<?> page) {
        this.content = page.getContent();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(page.getPageable().getPageSize());
        pageInfo.setPageNumber(page.getPageable().getPageNumber());
        pageInfo.setTotal((int) page.getTotalElements());
        this.pageInfo = pageInfo;
    }

    public CustomPage() {

    }
}
