package companyx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import companyx.controller.exception.AbsenceTypeNotFoundException;
import companyx.domain.Absence;
import companyx.domain.AbsenceType;
import companyx.repository.AbsenceRepository;
import companyx.repository.AbsenceTypeRepository;


@Service
public class AbsenceService
{

	private final AbsenceRepository absenceRepo;
	private final AbsenceTypeRepository typeRepo;
	
	
	public AbsenceService(AbsenceRepository absenceRepo, AbsenceTypeRepository typeRepo)
	{
		this.absenceRepo = absenceRepo;
		this.typeRepo = typeRepo;
	}
	
	
	
	private void assignType(Absence absence)
	{
		Short typeId = absence.getType().getId().shortValue();
		AbsenceType type = this.typeRepo.findById(typeId)
			.orElseThrow(() -> new AbsenceTypeNotFoundException(typeId));
		absence.setType(type);
	}
	
	
	
	public Absence save(Absence absence)
	{
		this.assignType(absence);
		
		return this.absenceRepo.save(absence);
	}
	
	
	public Absence update(Absence updatedAbsence, Short id)
	{
		this.assignType(updatedAbsence);
		
		return this.absenceRepo.findById(id)
			.map( absence -> {
				absence.setEmployeeName( updatedAbsence.getEmployeeName() );
				absence.setEmployeeLastName( updatedAbsence.getEmployeeLastName() );
				absence.setType( updatedAbsence.getType() );
				absence.setApplyOn( updatedAbsence.getApplyOn() );
				return this.absenceRepo.save(absence);
			})
			.orElseGet( () -> {
				updatedAbsence.setId(id);
				return this.absenceRepo.save(updatedAbsence);
			});
	}
	
	
	public void delete(Short id)
	{
		this.absenceRepo.deleteById(id);
	}
	
	
	public Absence retrieve(Short id)
	{
		return this.absenceRepo.findById(id).orElse(null);
	}
	
	
	public List<Absence> retrieveAll()
	{
		return this.absenceRepo.findAll();
	}
	
}
