package ProjectModel;
import jakarta.persistence.*;


@Entity(name = "STUDENTS")
public class Student {
    
    @Id
    @Column(name = "STUDENT_ID")
    private Integer studentID;
    @Column(length = 128)
    private String name;
    

}
