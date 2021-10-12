package companyx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import companyx.domain.AbsenceType;
import companyx.repository.AbsenceTypeRepository;


@Configuration
public class LoadInitialData
{
	
	private static Logger log = LoggerFactory.getLogger(LoadInitialData.class);
	

	@Bean
	CommandLineRunner initData(AbsenceTypeRepository absenceTypeRepo)
	{
		return args -> 
		{
			// add types
			log.info("# Loading: {}", absenceTypeRepo.save(new AbsenceType("Enfermedad")) );
			log.info("# Loading: {}", absenceTypeRepo.save(new AbsenceType("Diligencias")) );
			log.info("# Loading: {}", absenceTypeRepo.save(new AbsenceType("Otros")) );
		};
	}
	
}
