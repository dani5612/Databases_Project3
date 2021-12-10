package ProjectModel;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;

@Entity(name = "SEMESTERS")
public class Semester {
    //Attributes needed
    @Column(length = 16, nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate startDate;

    //ObjectID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMESTER_ID")
    private int semesterId;

    //One to many relation to Section
    //

    @OneToMany(mappedBy = "semester")
    private List<Section> sections;

    public void addSection(Section s) { 
        this.sections.add(s); 
        s.setSemester(this); 
    }

    public Semester() {
    }

    public Semester(String title, LocalDate startDate) {
        this.title = title;
        this.startDate = startDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getSemesterId() {
        return this.semesterId;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    

    @Override
    public String toString() {
        return 
            getTitle() + " semester. Starts on" +
            getStartDate() + ". ";
    }

}
