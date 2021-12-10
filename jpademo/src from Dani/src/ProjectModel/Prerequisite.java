package ProjectModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "PREREQUISITES")
public class Prerequisite{
    //Attributes required
    @NotNull
    private char minimumGrade;

    // Since association is recursive,
    // we need two Course ID FKs
    @Id
    @ManyToOne
    @JoinColumn(name = "FOLLOWUP_ID")
    private Course followupCourse; 
    //Tried specifiying another Many to one with join column here, and Eclipse Persistance HATED that.
    //Leaving it blank for now
    @Id
    @ManyToOne
    @JoinColumn(name = "PREREQ_ID")
    private Course prereqCourse;

    public Prerequisite() {
    }

    public Prerequisite(char minimumGrade, Course followUpCourse, Course prereqCourse) {
        this.minimumGrade = minimumGrade;
        this.followupCourse = followUpCourse;
        this.prereqCourse = prereqCourse;
    }

    public char getMinimumGrade() {
        return this.minimumGrade;
    }

    public void setMinimumGrade(char minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    public Course getfollowUpCourse() {
        return this.followupCourse;
    }

    public Course getPrereqCourse() {
        return this.prereqCourse;
    }
    
    @Override
    public String toString() {
        return getPrereqCourse() + " with a grade of " +
            getMinimumGrade() + " or higher to enroll in " +
            getfollowUpCourse();
    }

}