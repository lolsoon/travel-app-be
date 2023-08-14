package com.travelapp.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class FormBase {
    @Min(value = 0, message = "Size phải lớn hơn 0")
    protected int pageSize;
    @Min(value = 0, message = "Size phải lớn hơn 0")
    protected int pageNumber;
    protected String sortBy;
    protected String sortType;

    public static PageRequest buildPageRequest(FormBase formBase) {
        PageRequest pageRequest = null;
        if (formBase.getSortType().equals("DESC")) {
            pageRequest = PageRequest.of(formBase.getPageNumber()-1, formBase.getPageSize(), Sort.by(formBase.getSortBy()).descending());
        } else {
            pageRequest = PageRequest.of(formBase.getPageNumber()-1, formBase.getPageSize(), Sort.by(formBase.getSortBy()).ascending());
        }
        return pageRequest;
    }
}
