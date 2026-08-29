package za.co.gpbrij.cph.domain;
import jakarta.persistence.*;
@Entity public class Customer {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private String id;
 @Column(nullable=false) private String companyName;
 @Column(nullable=false,unique=true) private String registrationNumber;
 private String riskRating="LOW"; private boolean active=true;
 public String getId(){return id;} public String getCompanyName(){return companyName;} public void setCompanyName(String v){companyName=v;}
 public String getRegistrationNumber(){return registrationNumber;} public void setRegistrationNumber(String v){registrationNumber=v;}
 public String getRiskRating(){return riskRating;} public void setRiskRating(String v){riskRating=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
