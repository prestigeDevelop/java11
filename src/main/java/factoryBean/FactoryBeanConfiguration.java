package factoryBean;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfiguration {

//    @Bean
//    AnimalFactoryBean animalFactoryBean(){
//        return new AnimalFactoryBean(true);
//    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> applicationListener(Animal animal) {
        return new ApplicationListener<ApplicationReadyEvent>() {
            @Override
            public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
                animal.speak();
            }
        };
    }
}
