package com.interview.notable.entities;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String patientFirstName;

    @Column(nullable = false)
    private String patientLastName;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private boolean deleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Appointment that = (Appointment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
