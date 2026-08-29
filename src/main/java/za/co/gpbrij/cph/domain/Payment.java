package za.co.gpbrij.cph.domain;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.Instant; import java.time.LocalDate;
@Entity public class Payment {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private String id;
 @ManyToOne(optional=false) private Customer customer; @ManyToOne(optional=false) private Beneficiary beneficiary;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal amount; @Column(nullable=false,length=3) private String currency;
 @Column(nullable=false,unique=true) private String clientReference; private LocalDate valueDate;
 @Enumerated(EnumType.STRING) private PaymentStatus status=PaymentStatus.DRAFT; private String rejectionReason; private Instant createdAt=Instant.now(); private Instant updatedAt=Instant.now();
 @Version private long version;
 public String getId(){return id;} public Customer getCustomer(){return customer;} public void setCustomer(Customer v){customer=v;} public Beneficiary getBeneficiary(){return beneficiary;} public void setBeneficiary(Beneficiary v){beneficiary=v;} public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;} public String getCurrency(){return currency;} public void setCurrency(String v){currency=v;} public String getClientReference(){return clientReference;} public void setClientReference(String v){clientReference=v;} public LocalDate getValueDate(){return valueDate;} public void setValueDate(LocalDate v){valueDate=v;} public PaymentStatus getStatus(){return status;} public void setStatus(PaymentStatus v){status=v;updatedAt=Instant.now();} public String getRejectionReason(){return rejectionReason;} public void setRejectionReason(String v){rejectionReason=v;} public Instant getCreatedAt(){return createdAt;} public Instant getUpdatedAt(){return updatedAt;} public long getVersion(){return version;}
}
