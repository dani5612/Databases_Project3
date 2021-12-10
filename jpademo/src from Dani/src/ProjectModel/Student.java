package ProjectModel;
import java.util.Set;

import jakarta.persistence.*;


@Entity(name = "STUDENTS")
public class Student {
    //Attributes needed
    //Primary Key
    //int should be enough for student ID's
    //in CSULB student ID's are currently
    //in the 200,000s, it will take a while before it reaches
    ///millions
    @Id
    @Column(name = "STUDENT_ID")
    private Integer studentID;
    @Column(length = 128, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "students")
    private Set<Section> sections;
    

    //Transcript Association
    @OneToMany(mappedBy = "student")
    private Set<Transcript> transcripts;

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    //Bi-Directional adder
    public void addSection(Section s) { 
        this.pushSection(s); 
        s.pushStudent(this); 
    }

    // Helper for addSection
    public void pushSection(Section s){
        this.sections.add(s);
    }

    public Student() {
    }

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }


    public int getStudentID() {
        return this.studentID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Section> getSections() {
        return this.sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public double getGPA(){
          
        double totalPoints = 0;
        double totalUnits = 0;
        

        for(Transcript t: transcripts){
       

            if(t.getStudent() == this){

                
                double units = t.getSection().getCourse().getUnits();
                double gradePoints;

                if(t.getGradeEarned() == "A"){
                    gradePoints = 4;
                } 
                else if (t.getGradeEarned() == "B"){
                    gradePoints = 3;
                }
                else if (t.getGradeEarned() == "C"){
                    gradePoints = 2;
                }
                else if (t.getGradeEarned() == "D"){
                    gradePoints = 1;
                }
                else{gradePoints = 0;}

                totalPoints = totalPoints + (gradePoints * units);
                totalUnits = totalUnits + units;

            }

            
        }
        double GPA = totalPoints/totalUnits;

        return GPA; 
    }

    @Override
    public String toString() {
        return getName() + ", ID: "
            + getStudentID();
    }

}
