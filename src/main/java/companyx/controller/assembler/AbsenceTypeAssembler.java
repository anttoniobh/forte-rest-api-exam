package companyx.controller.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import companyx.controller.AbsenceTypeController;
import companyx.controller.resource.AbsenceTypeModel;
import companyx.domain.AbsenceType;


@Component
public class AbsenceTypeAssembler
{
	
	private final static String ABSENCE_TYPES = "absenceTypes"; 
	
	
	public AbsenceTypeModel toModel(AbsenceType type)
	{
		Link self = this.self(type.getId());
		Link aggregationRoot = this.aggregationRoot(false);
		
		return new AbsenceTypeModel(type).add(self, aggregationRoot);
	}
	
	
	public CollectionModel<AbsenceTypeModel> toCollectionModel(List<AbsenceType> typeList)
	{
		List<AbsenceTypeModel> modelList = typeList.stream()
			.map(type -> this.toModel(type))
			.collect(Collectors.toList());
		
		Link aggregationRoot = this.aggregationRoot(true);
		
		return CollectionModel.of(modelList, aggregationRoot);
	}
	
	
	
	public Link self(Short id)
	{
		return linkTo(methodOn(AbsenceTypeController.class).absenceType(id)).withSelfRel();
	}
	
	
	public Link aggregationRoot(boolean isSelfRel)
	{
		return isSelfRel ? 
			linkTo(methodOn(AbsenceTypeController.class).absenceTypes()).withSelfRel() : 
			linkTo(methodOn(AbsenceTypeController.class).absenceTypes()).withRel(ABSENCE_TYPES) ;
	}

}
