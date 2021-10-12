package companyx.controller.exception;

public class AbsenceTypeNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public AbsenceTypeNotFoundException(Short id)
	{
		super(String.format("Could not find AbsenceType record with [id=%s]", id));
	}
}
