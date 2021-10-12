package companyx.controller.resource;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import companyx.domain.Absence;
import companyx.domain.AbsenceType;

@Relation(value = "absence", collectionRelation = "absences")
public class AbsenceModel extends RepresentationModel<AbsenceModel>
{

	private final Short id;
	private final String employeeName;
	private final String employeeLastName;
	private final AbsenceType type;
	private final LocalDate applyOn;

	public AbsenceModel(Absence absence)
	{
		this.id = absence.getId();
		this.employeeName = absence.getEmployeeName();
		this.employeeLastName = absence.getEmployeeLastName();
		this.type = absence.getType();
		this.applyOn = absence.getApplyOn();
	}

	public Short getId()
	{
		return id;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public String getEmployeeLastName()
	{
		return employeeLastName;
	}

	public AbsenceType getType()
	{
		return type;
	}

	public LocalDate getApplyOn()
	{
		return applyOn;
	}

}
