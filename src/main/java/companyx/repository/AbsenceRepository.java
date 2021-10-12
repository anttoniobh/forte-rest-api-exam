package companyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import companyx.domain.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Short>
{

}
