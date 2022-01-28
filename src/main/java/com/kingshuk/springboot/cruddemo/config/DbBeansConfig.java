package com.kingshuk.springboot.cruddemo.config;

import com.kingshuk.springboot.cruddemo.dao.EmployeeDAO;
import com.kingshuk.springboot.cruddemo.dao.impl.EmployeeDAOHibernateImpl;
import com.kingshuk.springboot.cruddemo.dao.impl.EmployeeDAOJpaImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbBeansConfig {

    @Bean
    @ConditionalOnProperty(name="spring.data.vendor", havingValue="jpa", matchIfMissing = true)
    public EmployeeDAO jpaEmployeeDAO(){
        return new EmployeeDAOJpaImpl();
    }

    @Bean
    @ConditionalOnProperty(name="spring.data.vendor", havingValue="hibernate", matchIfMissing = false)
    public EmployeeDAO hibernateEmployeeDAO(){
        return new EmployeeDAOHibernateImpl();
    }
}
