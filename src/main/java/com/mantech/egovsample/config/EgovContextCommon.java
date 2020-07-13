    package com.mantech.egovsample.config;
    
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.FilterType;
    import org.springframework.stereotype.Controller;
    import org.springframework.stereotype.Repository;
    import org.springframework.stereotype.Service;
    import org.springframework.util.AntPathMatcher;
    
    import egovframework.rte.fdl.cmmn.trace.LeaveaTrace;
    import egovframework.rte.fdl.cmmn.trace.handler.DefaultTraceHandler;
    import egovframework.rte.fdl.cmmn.trace.handler.TraceHandler;
    import egovframework.rte.fdl.cmmn.trace.manager.DefaultTraceHandleManager;
    import egovframework.rte.fdl.cmmn.trace.manager.TraceHandlerService;
    
    
    @Configuration
    @ComponentScan(basePackages = "egovframework, egovsmaple", includeFilters = {
      @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
      @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class)
    }, excludeFilters = {
      @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
      @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
    })
    public class EgovContextCommon {
    
      @Bean
      public LeaveaTrace leaveaTrace(DefaultTraceHandleManager traceHandleManager) {
        LeaveaTrace leaveaTrace = new LeaveaTrace();
        leaveaTrace.setTraceHandlerServices(new TraceHandlerService[]{traceHandleManager});
        return leaveaTrace;
      }
    
      @Bean
      public DefaultTraceHandleManager traceHandleManager(AntPathMatcher antPathMatcher, DefaultTraceHandler defaultTraceHandler) {
        DefaultTraceHandleManager defaultTraceHandleManager = new DefaultTraceHandleManager();
        defaultTraceHandleManager.setReqExpMatcher(antPathMatcher);
        defaultTraceHandleManager.setPatterns(new String[]{"*"});
        defaultTraceHandleManager.setHandlers(new TraceHandler[]{defaultTraceHandler});
        return defaultTraceHandleManager;
      }
    
      @Bean
      public AntPathMatcher antPathMatcher() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        return antPathMatcher;
      }
    
      @Bean
      public DefaultTraceHandler defaultTraceHandler() {
        DefaultTraceHandler defaultTraceHandler = new DefaultTraceHandler();
        return defaultTraceHandler;
      }
    }
