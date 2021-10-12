package companyx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import companyx.controller.assembler.AbsenceAssembler;
import companyx.controller.exception.AbsenceNotFoundException;
import companyx.controller.resource.AbsenceModel;
import companyx.domain.Absence;
import companyx.service.AbsenceService;


@RestController
@RequestMapping("/company-x/rest-api/absences")
public class AbsenceController
{
	
	private final AbsenceService absenceService;
	private final AbsenceAssembler absenceAssembler;

	
	public AbsenceController(AbsenceService absenceService, AbsenceAssembler absenceAssembler)
	{
		this.absenceService = absenceService;
		this.absenceAssembler = absenceAssembler;
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> newType(@Valid @RequestBody Absence newAbsence)
	{
		AbsenceModel modelType = this.absenceAssembler.toModel( this.absenceService.save(newAbsence) );
		
		return ResponseEntity
			.created( modelType.getRequiredLink(IanaLinkRelations.SELF).toUri() )
			.body(modelType);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> replace(@Valid @RequestBody Absence updatedAbsence, @PathVariable(required = true) Short id)
	{
		AbsenceModel modelType = this.absenceAssembler.toModel( this.absenceService.update(updatedAbsence, id) );
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation( modelType.getRequiredLink(IanaLinkRelations.SELF).toUri() ); 
		
		return new ResponseEntity<>(modelType, headers, HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable(required = true) Short id)
	{
		this.absenceService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping(path = "{id}")
	public AbsenceModel absence(@PathVariable(required = true) Short id)
	{
		Absence absence = this.absenceService.retrieve(id);
		
		if (absence == null)
			throw new AbsenceNotFoundException(id);
		
		return this.absenceAssembler.toModel(absence);
	}
	
	
	@GetMapping
	public CollectionModel<AbsenceModel> absences()
	{
		List<Absence> absenceList = this.absenceService.retrieveAll(); 
		
		return this.absenceAssembler.toCollectionModel(absenceList);
	}
	
}
