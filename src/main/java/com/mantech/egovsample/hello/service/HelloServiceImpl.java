    package com.mantech.egovsample.hello.service;
    
    import org.springframework.stereotype.Service;
    
    import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
    
    @Service("helloService")
    public class HelloServiceImpl extends EgovAbstractServiceImpl implements HelloService {
    
      @Override
      public String getHello() {
        return "Hello World";
      }
    }
