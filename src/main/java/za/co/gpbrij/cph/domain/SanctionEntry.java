package za.co.gpbrij.cph.domain;
import jakarta.persistence.*;
@Entity public class SanctionEntry { @Id @GeneratedValue(strategy=GenerationType.UUID) private String id; private String entityName; private String countryCode; private boolean active=true; public String getId(){return id;} public String getEntityName(){return entityName;} public void setEntityName(String v){entityName=v;} public String getCountryCode(){return countryCode;} public void setCountryCode(String v){countryCode=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;} }
