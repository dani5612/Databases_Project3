package ProjectModel;

import jakarta.persistence.*;

@Entity(name = "PREREQUISITES")
public class Prerequisite{
    //Attributes required
    private char minimumGrade;

    // Since association is recursive,
    // we need two Course ID FKs
    @ManyToOne
    @JoinColumn(name = "FOLLOWUP_ID")
    private Course followupCourse; 
    //Tried specifiying another Many to one with join column here, and Eclipse Persistance HATED that.
    //Leaving it blank for now
    @ManyToOne
    @JoinColumn(name = "PREREQ_ID")
    private Course prereqCourse;


}