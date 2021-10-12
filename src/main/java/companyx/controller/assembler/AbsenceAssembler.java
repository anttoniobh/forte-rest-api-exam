package companyx.controller.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import companyx.controller.AbsenceController;
import companyx.controller.resource.AbsenceModel;
import companyx.domain.Absence;


@Component
public class AbsenceAssembler
{

	private final static String ABSENCES = "absences";
	
	
	public AbsenceModel toModel(Absence absence)
	{
		Link self = this.self(absence.getId());
		Link aggregationRoot = this.aggregationRoot(false);
		
		return new AbsenceModel(absence).add(self, aggregationRoot);
	}
	
	
	public CollectionModel<AbsenceModel> toCollectionModel(List<Absence> absenceList)
	{
		List<AbsenceModel> modelList = absenceList.stream()
			.map(absence -> this.toModel(absence))
			.collect(Collectors.toList());
		
		Link aggregationRoot = this.aggregationRoot(true);
		
		return CollectionModel.of(modelList, aggregationRoot);
	}
	
	
	
	public Link self(Short id)
	{
		return linkTo(methodOn(AbsenceController.class).absence(id)).withSelfRel();
	}
	
	
	public Link aggregationRoot(boolean isSelfRel)
	{
		return isSelfRel ? 
			linkTo(methodOn(AbsenceController.class).absences()).withSelfRel() : 
			linkTo(methodOn(AbsenceController.class).absences()).withRel(ABSENCES);
	}
	
}
