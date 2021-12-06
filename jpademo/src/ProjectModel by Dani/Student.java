package ProjectModel;
import java.util.Set;

import jakarta.persistence.*;


@Entity(name = "STUDENTS")
public class Student {
    //Attributes needed
    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Integer studentID;
    @Column(length = 128)
    private String name;

    @ManyToMany(mappedBy = "students")
    private Set<Section> sections;
    

}
