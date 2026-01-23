package org.weewelchie.patients.data.entities;

import jakarta.persistence.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/*
Patient entity class
 */

@Entity(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entity_id")
    private Long entityId;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name = "entity_created", columnDefinition = "TIMESTAMP")
    private LocalDateTime entityCreated;

    @Column(name = "entity_updated", columnDefinition = "TIMESTAMP")
    private LocalDateTime entityUpdated;

    @Column(name="entity_version")
    private Long entityVersion;

    @Column(name = "when_discharged", columnDefinition = "TIMESTAMP")
    private LocalDateTime whenDischarged;

    @Column(name = "when_invited", columnDefinition = "TIMESTAMP")
    private LocalDateTime whenInvited;

    @Column(name = "when_registered", columnDefinition = "TIMESTAMP")
    private LocalDateTime whenRegistered;

    @Column(name="id")
    private UUID id;

    @Column(name="family_name")
    private String familyName;

    @Column(name="gender")
    private String gender;

    @Column(name="given_name")
    private String givenName;

    @Column(name="hospital_id")
    private String hospitalID;

    @Column(name="nhs_number")
    private String nhsNumber;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getEntityCreated() {
        return entityCreated;
    }

    public void setEntityCreated(LocalDateTime entityCreated) {
        this.entityCreated = entityCreated;
    }

    public LocalDateTime getEntityUpdated() {
        return entityUpdated;
    }

    public void setEntityUpdated(LocalDateTime entityUpdated) {
        this.entityUpdated = entityUpdated;
    }

    public Long getEntityVersion() {
        return entityVersion;
    }

    public void setEntityVersion(Long entityVersion) {
        this.entityVersion = entityVersion;
    }

    public LocalDateTime getWhenDischarged() {
        return whenDischarged;
    }

    public void setWhenDischarged(LocalDateTime whenDischarged) {
        this.whenDischarged = whenDischarged;
    }

    public LocalDateTime getWhenInvited() {
        return whenInvited;
    }

    public void setWhenInvited(LocalDateTime whenInvited) {
        this.whenInvited = whenInvited;
    }

    public LocalDateTime getWhenRegistered() {
        return whenRegistered;
    }

    public void setWhenRegistered(LocalDateTime whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;

        if (!Objects.equals(entityId, patient.entityId)) return false;
        if (!Objects.equals(dateOfBirth, patient.dateOfBirth)) return false;
        if (!Objects.equals(entityCreated, patient.entityCreated))
            return false;
        if (!Objects.equals(entityUpdated, patient.entityUpdated))
            return false;
        if (!Objects.equals(entityVersion, patient.entityVersion))
            return false;
        if (!Objects.equals(whenDischarged, patient.whenDischarged))
            return false;
        if (!Objects.equals(whenInvited, patient.whenInvited)) return false;
        if (!Objects.equals(whenRegistered, patient.whenRegistered))
            return false;
        if (!Objects.equals(id, patient.id)) return false;
        if (!Objects.equals(familyName, patient.familyName)) return false;
        if (!Objects.equals(gender, patient.gender)) return false;
        if (!Objects.equals(givenName, patient.givenName)) return false;
        if (!Objects.equals(hospitalID, patient.hospitalID)) return false;
        return Objects.equals(nhsNumber, patient.nhsNumber);
    }

    @Override
    public int hashCode() {
        int result = entityId != null ? entityId.hashCode() : 0;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (entityCreated != null ? entityCreated.hashCode() : 0);
        result = 31 * result + (entityUpdated != null ? entityUpdated.hashCode() : 0);
        result = 31 * result + (entityVersion != null ? entityVersion.hashCode() : 0);
        result = 31 * result + (whenDischarged != null ? whenDischarged.hashCode() : 0);
        result = 31 * result + (whenInvited != null ? whenInvited.hashCode() : 0);
        result = 31 * result + (whenRegistered != null ? whenRegistered.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (hospitalID != null ? hospitalID.hashCode() : 0);
        result = 31 * result + (nhsNumber != null ? nhsNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "entityId=" + entityId +
                ", dateOfBirth=" + dateOfBirth +
                ", entityCreated=" + entityCreated +
                ", entityUpdated=" + entityUpdated +
                ", entityVersion=" + entityVersion +
                ", whenDischarged=" + whenDischarged +
                ", whenInvited=" + whenInvited +
                ", whenRegistered=" + whenRegistered +
                ", id=" + id +
                ", familyName='" + familyName + '\'' +
                ", gender='" + gender + '\'' +
                ", givenName='" + givenName + '\'' +
                ", hospitalID='" + hospitalID + '\'' +
                ", nhsNumber='" + nhsNumber + '\'' +
                '}';
    }
}
