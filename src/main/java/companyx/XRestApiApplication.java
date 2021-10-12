package companyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@Import({LoadInitialData.class})

@EntityScan(basePackages = "companyx.domain")
@EnableJpaRepositories(basePackages = "companyx.repository")
@ComponentScan(basePackages = {"companyx.service", "companyx.controller"})

public class XRestApiApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(XRestApiApplication.class, args);
	}

}
