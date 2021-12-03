package ProjectModel;

import jakarta.persistence.*;

public class Section {

    //Many to one for Semester
    @ManyToOne
    @JoinColumn(name = "SEMESTER_ID")
    private Semester semester;

    //Many to one for Course
    //Many to one for Time Slot
    
    //Many to many for students

    //Many to Many for Transcript (history?)
    
}
