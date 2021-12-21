package be.fooda.backend.media.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
// JPA
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MediaEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long userId;

    Long relatedId;

    String type;

    Double width;

    Double height;

    String url;

    String extension;

    String createdAt;

    String updatedAt;

    Boolean isResponsive;

    Boolean isVisible;

    Boolean isPublic;

    Boolean isActive;

    @PrePersist
    private void prePersistFunction() {
        log.info("PrePersist method called. Auto-persistable fields are being managed.");
        this.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
        this.setIsResponsive(true);
        this.setIsVisible(true);
        this.setIsPublic(false);
        this.setIsActive(true);
    }

    @PreUpdate
    public void preUpdateFunction() {
        log.info("PreUpdate method called. Auto-updatable fields are being managed.");
        this.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MediaEntity)) return false;

        MediaEntity that = (MediaEntity) o;

        return new EqualsBuilder().append(getId(), that.getId()).append(getUserId(), that.getUserId()).append(getRelatedId(), that.getRelatedId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getUserId()).append(getRelatedId()).toHashCode();
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}
