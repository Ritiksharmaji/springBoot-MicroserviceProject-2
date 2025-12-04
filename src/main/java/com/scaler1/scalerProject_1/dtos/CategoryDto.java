//package com.scaler1.scalerProject_1.dtos;
//
//import lombok.Data;
//
//import java.util.List;
//@Data
//public class CategoryDto {
//    private Long id;
//    private String name;
//    private List<ProductDto> products;
//}

// ------------ other -----------
package com.scaler1.scalerProject_1.dtos;

import lombok.Data;
import java.util.List;

@Data
public class CategoryDto  {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
