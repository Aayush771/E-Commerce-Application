package quickcart.quickcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableJpaRepositories("quickcart.quickcart.Repository")  // Ensure correct package
@EntityScan("quickcart.quickcart.Entity")
public class QuickCartApplication {

    public static void main(final String[] args) {
        SpringApplication.run(QuickCartApplication.class, args);
    }

}
