package companyx.controller.exception;

public class AbsenceTypeNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public AbsenceTypeNotFoundException(Short id)
	{
		super(String.format("No se encuentra Tipo de Permiso con [id=%s]", id));
	}
}
