    package com.mantech.egovsample.hello.controller;
    
    import javax.annotation.Resource;
    
    import com.mantech.egovsample.hello.service.HelloService;
    
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class HelloController {
    
      @Resource(name = "helloService")
      private HelloService helloService;
    
      @GetMapping("/")
      public String hello() {
        return helloService.getHello();
      }
    }
