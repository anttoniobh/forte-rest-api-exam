package companyx.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity(name = "Permiso")
public class Absence
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	
	@NotBlank(message = "{absence.employeeName.blank}")
	
	@Column(name = "nombreEmpleado")
	private String employeeName;

	
	@NotBlank(message = "{absence.employeeLastName.blank}")
	
	@Column(name = "apellidosEmpleado")
	private String employeeLastName;
	
	
	@NotNull(message = "{absence.type.null}")
	
	@ManyToOne
	@JoinColumn(name = "tipoPermiso", referencedColumnName = "id")
	// @Column(name = "tipoPermiso")
	private AbsenceType type;

	
	@NotNull(message = "{absence.applyOn.null}")
	
	@Column(name = "fechaPermiso")
	private LocalDate applyOn;

	
	public Absence()
	{

	}

	
	public Absence(String employeeName, String employeeLastName, AbsenceType type, LocalDate applyOn)
	{
		super();
		this.employeeName = employeeName;
		this.employeeLastName = employeeLastName;
		this.type = type;
		this.applyOn = applyOn;
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	public String getEmployeeLastName()
	{
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName)
	{
		this.employeeLastName = employeeLastName;
	}

	public AbsenceType getType()
	{
		return type;
	}

	public void setType(AbsenceType type)
	{
		this.type = type;
	}

	public LocalDate getApplyOn()
	{
		return applyOn;
	}

	public void setApplyOn(LocalDate applyOn)
	{
		this.applyOn = applyOn;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyOn == null) ? 0 : applyOn.hashCode());
		result = prime * result + ((employeeLastName == null) ? 0 : employeeLastName.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Absence other = (Absence) obj;
		if (applyOn == null)
		{
			if (other.applyOn != null)
				return false;
		}
		else if (!applyOn.equals(other.applyOn))
			return false;
		if (employeeLastName == null)
		{
			if (other.employeeLastName != null)
				return false;
		}
		else if (!employeeLastName.equals(other.employeeLastName))
			return false;
		if (employeeName == null)
		{
			if (other.employeeName != null)
				return false;
		}
		else if (!employeeName.equals(other.employeeName))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (type == null)
		{
			if (other.type != null)
				return false;
		}
		else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Absence [id=" + id + ", employeeName=" + employeeName + ", employeeLastName=" + employeeLastName
				+ ", type=" + type + ", applyOn=" + applyOn + "]";
	}

}
