package ProjectModel;

import jakarta.persistence.*;

@Entity(name = "PREREQUISITES")
public class Prerequisite{
    private char minimumGrade;

    @Id
    @Column(name = "PREREQ_ID")
    private int prereqID;

    // Since association is recursive,
    // we need two Course ID FKs
    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course parentCourse; 

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course prereqCourse;


    public Prerequisite() {
    }

    public Prerequisite(char minimumGrade, int prereqID, Course parentCourse, Course prereqCourse) {
        this.minimumGrade = minimumGrade;
        this.prereqID = prereqID;
        this.parentCourse = parentCourse;
        this.prereqCourse = prereqCourse;
    }

    public char getMinimumGrade() {
        return this.minimumGrade;
    }

    public void setMinimumGrade(char minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    public int getPrereqID() {
        return this.prereqID;
    }

    public void setPrereqID(int prereqID) {
        this.prereqID = prereqID;
    }

    public Course getParentCourse() {
        return this.parentCourse;
    }

    public void setParentCourse(Course parentCourse) {
        this.parentCourse = parentCourse;
    }

    public Course getPrereqCourse() {
        return this.prereqCourse;
    }

    public void setPrereqCourse(Course prereqCourse) {
        this.prereqCourse = prereqCourse;
    }
    
    @Override
    public String toString() {
        return "To enroll in " +
            getParentCourse() + ", a grade of " +
            getMinimumGrade() + " or higher is required in the following course:" +
            getPrereqCourse();
    }

}