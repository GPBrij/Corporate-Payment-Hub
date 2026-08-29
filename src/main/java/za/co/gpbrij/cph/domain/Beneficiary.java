package za.co.gpbrij.cph.domain;
import jakarta.persistence.*;
@Entity public class Beneficiary {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private String id;
 @Column(nullable=false) private String name; @Column(nullable=false) private String accountNumber; @Column(nullable=false) private String bankCode; @Column(nullable=false) private String countryCode;
 public String getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;} public String getAccountNumber(){return accountNumber;} public void setAccountNumber(String v){accountNumber=v;} public String getBankCode(){return bankCode;} public void setBankCode(String v){bankCode=v;} public String getCountryCode(){return countryCode;} public void setCountryCode(String v){countryCode=v;}
}
