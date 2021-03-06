package com.tmaciejewski.showcaseapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tmaciejewski.showcaseapp.enums.StudyMode;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;


@Entity
@Table(name = "courses")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Lob
    private String description;
    @NotNull
    private StudyMode studyMode;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseModule> courseModules;
}
