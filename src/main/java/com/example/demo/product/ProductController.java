package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class ProductController {
    // 사용자의 요청을 받아서: method, URL 구분
    // 서비스에게 일 시킴: 메소드 안에서
    // 서비스에게 결과를 받아서: 서비스의 반환값을
    // 사용자에게 돌려줌: return

    //    @Autowired 필드 DI
    private ProductService productService;

//    @Autowired Setter DI
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    @Autowired // 스프링 소스사가 적극지원하는 방식이므로 자동으로 적용
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET) // localhost:8080은 생략
    public String hello() {
        return this.productService.hello();
    }

    @RequestMapping("/hi") // default method=GET, 매개변수가 하나일 때는 value로 받음
    public String hi() {
        return this.productService.hi();
    }

    @RequestMapping(value = "/products/{id}")
    public String findProductName(@PathVariable("id") Integer id) {
        return this.productService.findProductName(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public void save(@RequestBody Map<String, String> productsMap) {
        this.productService.save(productsMap.get("product"));
    }

    @RequestMapping(value = "/products")
    public HashMap pagination(@RequestParam(required = false, value = "page") Integer page,
        @RequestParam(required = false, value = "offset") Integer offset) {
        if (page != null) {
            return this.productService.pagination(page, offset);
        } else {
            return new HashMap<>(Map.of("products", this.productService.findProducts()));
        }
    }
}