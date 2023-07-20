package springDeneme.Entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public class BaseUser {
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
