package companyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import companyx.domain.AbsenceType;

public interface AbsenceTypeRepository extends JpaRepository<AbsenceType, Short>
{

}
