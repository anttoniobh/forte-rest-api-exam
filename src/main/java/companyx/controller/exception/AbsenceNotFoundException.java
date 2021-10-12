package companyx.controller.exception;

public class AbsenceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public AbsenceNotFoundException(Short id)
	{
		super(String.format("No se encuentra Permiso con [id=%s]", id));
	}
}
