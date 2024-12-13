package org.example.springbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/3/2
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private List<T> records;
    private Integer count;
    private PageRequest pageRequest;

}
