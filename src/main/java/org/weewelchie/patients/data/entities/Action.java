package org.weewelchie.patients.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name="action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entity_id", nullable = false)
    private Long entityId;

    @Column(name = "entity_created", columnDefinition = "TIMESTAMP")
    private LocalDateTime entityCreated;

    @Column(name="entity_version", nullable = false)
    private Long entityVersion;

    // Foreign key to patient
    @Column(name="patient_entity_id", nullable = false)
    private Long patientEntityId;

    @Column(name = "when_recorded", columnDefinition = "TIMESTAMP")
    private LocalDateTime whenRecorded;

    @Column(name="id")
    private UUID uuid;

    @Column(name="activity")
    private String activity;

    @Column(name="context")
    private String context;

    @Column(name="module_Id")
    private String moduleId;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public LocalDateTime getEntityCreated() {
        return entityCreated;
    }

    public void setEntityCreated(LocalDateTime entityCreated) {
        this.entityCreated = entityCreated;
    }

    public Long getEntityVersion() {
        return entityVersion;
    }

    public void setEntityVersion(Long entityVersion) {
        this.entityVersion = entityVersion;
    }

    public Long getPatientEntityId() {
        return patientEntityId;
    }

    public void setPatientEntityId(Long patientEntityId) {
        this.patientEntityId = patientEntityId;
    }

    public LocalDateTime getWhenRecorded() {
        return whenRecorded;
    }

    public void setWhenRecorded(LocalDateTime whenRecorded) {
        this.whenRecorded = whenRecorded;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action action)) return false;

        if (!Objects.equals(entityId, action.entityId)) return false;
        if (!Objects.equals(entityCreated, action.entityCreated))
            return false;
        if (!Objects.equals(entityVersion, action.entityVersion))
            return false;
        if (!Objects.equals(patientEntityId, action.patientEntityId))
            return false;
        if (!Objects.equals(whenRecorded, action.whenRecorded))
            return false;
        if (!Objects.equals(uuid, action.uuid)) return false;
        if (!Objects.equals(activity, action.activity)) return false;
        if (!Objects.equals(context, action.context)) return false;
        return Objects.equals(moduleId, action.moduleId);
    }

    @Override
    public int hashCode() {
        int result = entityId != null ? entityId.hashCode() : 0;
        result = 31 * result + (entityCreated != null ? entityCreated.hashCode() : 0);
        result = 31 * result + (entityVersion != null ? entityVersion.hashCode() : 0);
        result = 31 * result + (patientEntityId != null ? patientEntityId.hashCode() : 0);
        result = 31 * result + (whenRecorded != null ? whenRecorded.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (moduleId != null ? moduleId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" +
                "entityId=" + entityId +
                ", entityCreated=" + entityCreated +
                ", entityVersion=" + entityVersion +
                ", patientEntityId=" + patientEntityId +
                ", whenRecorded=" + whenRecorded +
                ", uuid=" + uuid +
                ", activity='" + activity + '\'' +
                ", context='" + context + '\'' +
                ", moduleId='" + moduleId + '\'' +
                '}';
    }
}
