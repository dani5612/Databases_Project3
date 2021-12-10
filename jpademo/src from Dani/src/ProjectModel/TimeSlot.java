package ProjectModel;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;

@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"daysOfWeek", "startTime", "endTime"})
})
@Entity(name = "TIMESLOTS")
public class TimeSlot {
    
    //Required Attributes
    @Column(nullable = false)
    private byte daysOfWeek;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIMESLOT_ID")
    private int timeslotID;

    //one to many with section
    /*@OneToMany
    @JoinColumn(name = "SECTION_ID")
    private List<Section> sections;*/


    public TimeSlot() {
    }

    public TimeSlot(byte daysOfWeek, LocalTime startTime, LocalTime endTime) {
        this.daysOfWeek = daysOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Accessors and Mutators 

    public int getTimeSlotID() {
        return timeslotID;
    }

    public byte getDaysOfWeek() {
        return daysOfWeek;
    }
    public void setDaysOfWeek(byte daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


}
