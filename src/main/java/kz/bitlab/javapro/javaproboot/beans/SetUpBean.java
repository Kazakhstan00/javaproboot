package kz.bitlab.javapro.javaproboot.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SetUpBean {

    @Bean
    @Qualifier("secondBeanWithoutConstructor")
    public SecondBean secondBean(){
        return new SecondBean();
    }
    @Bean
    @Qualifier("secondBeanWithConstructor")
    public SecondBean secondOfSecondBean(){
        return new SecondBean(4444, "ploshad");
    }
}
