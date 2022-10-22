package org.wildfly.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wildfly.HelloWorld;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Configuration
public class EjbConfig {

    @Bean
    public Context context() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put("java.naming.factory.initial", "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProps.put("jboss.naming.client.ejb.context", true);
//        jndiProps.put("java.naming.provider.url", "http-remoting://localhost:8080");
        return new InitialContext(jndiProps);
    }

    @Bean
    public HelloWorld helloWorld(Context context) throws NamingException{
//        return new HelloWorld() {
//            @Override
//            public String returnSmth() {
//                return "not remote";
//            }
//        };
        return (HelloWorld) context.lookup("ejb:/remote-service/HelloWorld!org.wildfly.HelloWorld");
    }

    private String getFullName(Class<?> classType) {
        String moduleName = "ejb:/main/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();
        return moduleName + beanName + "!" + viewClassName;
    }
}
