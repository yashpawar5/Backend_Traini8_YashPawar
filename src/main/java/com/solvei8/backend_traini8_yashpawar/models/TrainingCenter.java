package com.solvei8.backend_traini8_yashpawar.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trainingCenters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String centerName;

    @Column(nullable = false, unique = true, length = 12)
    private String centerCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(nullable = false)
    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "center_courses", joinColumns = @JoinColumn(name = "center_id"))
    @Column(name = "course_name")
    private List<String> coursesOffered;

    @Column(nullable = false, updatable = false)
    private long createdOn;


    private String contactEmail;

    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        this.createdOn = System.currentTimeMillis() / 1000; // Store as epoch time
    }

}
