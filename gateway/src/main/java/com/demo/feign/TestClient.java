// gateway/src/main/java/com/demo/feign/TestClient.java
package com.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface TestClient {
    @GetMapping("/test")
    String test();
}