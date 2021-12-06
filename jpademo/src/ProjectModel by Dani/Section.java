package ProjectModel;

import jakarta.persistence.*;

@Entity(name = "SECTIONS")
public class Section {
    //Required Attributes
    private int sectionNumber;
    private int maxCapacity;


    //Primary Key
    @Id
    @Column(name = "SECTION_ID")
    private int sectionID;

    //Many to one for Semester
    @ManyToOne
    @JoinColumn(name = "SEMESTER_ID")
    private Semester semester;

    //Many to one for Course
    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    //Many to one for Time Slot
    @ManyToOne
    @JoinColumn(name = "TIMESLOT_ID")
    private TimeSlot timeslot;

    
    //Many to many for students

    //Many to Many for Transcript (history?)

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    


    
}
