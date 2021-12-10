package ProjectModel;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "DEPARTMENTS")
public class Department {
    //Attributes required
    @Column(length = 128, nullable = false)
    private String name;
    @Column(length = 8, nullable = false)
    private String abbreviation;

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private int deptID;

    // One-to-many with Course.
    @OneToMany(mappedBy = "department")
    private List<Course> courses;


    //Bi-Directional adder
    public void addCourse(Course c) { 
        this.courses.add(c); 
        c.setDepartment(this); 
    }

    //Default Constructor
    public Department() {
    }
    //Overloaded Constructor
    public Department(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getDeptID() {
        return this.deptID;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return
            getName() +
            " Department, '" + getAbbreviation() + "' ID: " +
            getDeptID();
    }

}
