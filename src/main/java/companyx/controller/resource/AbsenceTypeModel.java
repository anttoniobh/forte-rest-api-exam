package companyx.controller.resource;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import companyx.domain.AbsenceType;


@Relation(value = "absenceType", collectionRelation = "absenceTypes")
public class AbsenceTypeModel extends RepresentationModel<AbsenceTypeModel>
{

	private final Short id;
	private final String description;

	public AbsenceTypeModel(AbsenceType type)
	{
		this.id = type.getId();
		this.description = type.getDescription();
	}

	public Short getId()
	{
		return id;
	}

	public String getDescription()
	{
		return description;
	}

}
