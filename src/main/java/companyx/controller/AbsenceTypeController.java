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

import companyx.controller.assembler.AbsenceTypeAssembler;
import companyx.controller.exception.AbsenceTypeNotFoundException;
import companyx.controller.resource.AbsenceTypeModel;
import companyx.domain.AbsenceType;
import companyx.service.AbsenceTypeService;


@RestController
@RequestMapping("/company-x/rest-api/absence-types")
public class AbsenceTypeController
{

	private final AbsenceTypeService typeService;
	private final AbsenceTypeAssembler typeAssembler;
	
	
	public AbsenceTypeController(AbsenceTypeService typeService, AbsenceTypeAssembler typeAssembler)
	{
		this.typeService = typeService;
		this.typeAssembler = typeAssembler;
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> newType(@Valid @RequestBody AbsenceType newType)
	{
		AbsenceTypeModel modelType = this.typeAssembler.toModel( this.typeService.save(newType) );
		
		return ResponseEntity
			.created( modelType.getRequiredLink(IanaLinkRelations.SELF).toUri() )
			.body(modelType);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> replace(@RequestBody AbsenceType updatedType, @PathVariable(required = true) Short id)
	{
		AbsenceTypeModel modelType = this.typeAssembler.toModel( this.typeService.update(updatedType, id) );
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation( modelType.getRequiredLink(IanaLinkRelations.SELF).toUri() ); 
		
		return new ResponseEntity<>(modelType, headers, HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable(required = true) Short id)
	{
		this.typeService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping(path = "{id}")
	public AbsenceTypeModel absenceType(@PathVariable(required = true) Short id)
	{
		AbsenceType type = this.typeService.retrieve(id);
		
		if (type == null)
			throw new AbsenceTypeNotFoundException(id);
		
		return this.typeAssembler.toModel(type);
	}
	
	
	@GetMapping
	public CollectionModel<AbsenceTypeModel> absenceTypes()
	{
		List<AbsenceType> typeList = this.typeService.retrieveAll(); 
		
		return this.typeAssembler.toCollectionModel(typeList);
	}
	
}
