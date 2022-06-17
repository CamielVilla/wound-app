package nl.novi.assigment.homecare.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WoundExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nurseAssessment;
    private LocalDateTime assessmentDate;
    private String patientComment;
    private LocalDateTime photoDate;

    @OneToOne
    private FileUploadResponse file;


    @ManyToOne
    @JsonIgnore
    @JoinColumn (name = "wound_id")
    private Wound wound;


    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNurseAssessment() {
        return nurseAssessment;
    }

    public void setNurseAssessment(String nurseAssessment) {
        this.nurseAssessment = nurseAssessment;
    }

    public LocalDateTime getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDateTime assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getPatientComment() {
        return patientComment;
    }

    public void setPatientComment(String patientComment) {
        this.patientComment = patientComment;
    }

    public LocalDateTime getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(LocalDateTime photoDate) {
        this.photoDate = photoDate;
    }

    public Wound getWound() {
        return wound;
    }

    public void setWound(Wound wound) {
        this.wound = wound;
    }
}