//package com.scaler1.scalerProject_1.dtos;
//
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//public class ProductDto {
//    private Long id;
//    private String title;
//    private String description;
//    private String image;
//    private PriceDto price;
//
//}

// ----------- other -----------
package com.scaler1.scalerProject_1.dtos;

import lombok.Data;

@Data
public class ProductDto  {
    private Long id;
    private String title;
    private String description;
    private String image;
    private PriceDto price;
}
