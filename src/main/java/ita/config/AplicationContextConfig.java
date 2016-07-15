package ita.config;

import ita.dao.GetImage_dao;
import ita.daoIMPL.GetImage_daoIMPL;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class AplicationContextConfig {
    
    @Bean(name = "multipartResolver")
public CommonsMultipartResolver getCommonsMultipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(20971520);   // 20MB
    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
    return multipartResolver;
}
@Autowired
@Bean(name = "getImage_dao")
public GetImage_dao getImage(SessionFactory sessionFactory) {
    return new GetImage_daoIMPL(sessionFactory);
}
}
