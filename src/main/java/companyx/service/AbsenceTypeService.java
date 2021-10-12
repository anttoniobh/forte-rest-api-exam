package companyx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import companyx.domain.AbsenceType;
import companyx.repository.AbsenceTypeRepository;


@Service
public class AbsenceTypeService
{
	
	private final AbsenceTypeRepository absenceTypeRepo;

	
	public AbsenceTypeService(AbsenceTypeRepository absenceTypeRepo)
	{
		this.absenceTypeRepo = absenceTypeRepo;
	}
	
	
	
	public AbsenceType save(AbsenceType newType)
	{
		return this.absenceTypeRepo.save(newType);
	}
	
	
	public AbsenceType update(AbsenceType updatedType, Short id)
	{
		return this.absenceTypeRepo.findById(id)
			.map( type -> {
				type.setDescription( updatedType.getDescription() );
				return this.absenceTypeRepo.save(type);
			})
			.orElseGet( () -> {
				updatedType.setId(id);
				return this.absenceTypeRepo.save(updatedType);
			});
	} 
	
	
	public void delete(Short id)
	{
		this.absenceTypeRepo.deleteById(id);
	}
	
	
	public AbsenceType retrieve(Short id)
	{
		return this.absenceTypeRepo.findById(id).orElse(null);
	}
	
	
	public List<AbsenceType> retrieveAll()
	{
		return this.absenceTypeRepo.findAll();
	}

}
