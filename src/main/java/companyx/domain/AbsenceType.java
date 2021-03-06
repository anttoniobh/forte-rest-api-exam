package companyx.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "TipoPermiso")
public class AbsenceType
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@NotNull(message = "{absenceType.description.null}")
	@Size(min = 3, max = 50, message = "{absenceType.description.size}")

	@Column(name = "descripcion")
	private String description;

	public AbsenceType()
	{

	}

	public AbsenceType(String description)
	{
		this.description = description;
	}

	public AbsenceType(Integer id)
	{
		this.id = id.shortValue();
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AbsenceType other = (AbsenceType) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "AbsenceType [id=" + id + ", description=" + description + "]";
	}

}
