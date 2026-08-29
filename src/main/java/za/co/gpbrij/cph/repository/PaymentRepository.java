package za.co.gpbrij.cph.repository;
import za.co.gpbrij.cph.domain.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentRepository extends JpaRepository<Payment,String> {
 java.util.List<Payment> findByStatus(PaymentStatus status);
}
