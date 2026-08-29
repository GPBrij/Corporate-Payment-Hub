package za.co.gpbrij.cph.repository;
import za.co.gpbrij.cph.domain.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface AuditLogRepository extends JpaRepository<AuditLog,String> {
}
