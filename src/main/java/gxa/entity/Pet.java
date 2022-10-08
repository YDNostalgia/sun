package gxa.entity;

import java.util.Date;

public class Pet {
    private int id;
    private String photo;
    private String memberName;
    private String petName;
    private String petColor;
    private String note;
    private Date adoptionTime;
    private Date date;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", memberName='" + memberName + '\'' +
                ", petName='" + petName + '\'' +
                ", petColor='" + petColor + '\'' +
                ", note='" + note + '\'' +
                ", adoptionTime=" + adoptionTime +
                ", date=" + date +
                '}';
    }

    public Pet() {
    }

    public Pet(int id, String photo, String memberName, String petName, String petColor, String note, Date adoptionTime, Date date) {
        this.id = id;
        this.photo = photo;
        this.memberName = memberName;
        this.petName = petName;
        this.petColor = petColor;
        this.note = note;
        this.adoptionTime = adoptionTime;
        this.date = date;
    }

    public Pet(int id, String photo, String memberName, String petName, String petColor, String note, Date adoptionTime) {
        this.id = id;
        this.photo = photo;
        this.memberName = memberName;
        this.petName = petName;
        this.petColor = petColor;
        this.note = note;
        this.adoptionTime = adoptionTime;
    }

    public Pet(String photo, String memberName, String petName, String petColor, String note, Date adoptionTime, Date date) {
        this.photo = photo;
        this.memberName = memberName;
        this.petName = petName;
        this.petColor = petColor;
        this.note = note;
        this.adoptionTime = adoptionTime;
        this.date = date;
    }

    public Pet(String photo, String memberName, String petName, String petColor, String note, Date adoptionTime) {
        this.photo = photo;
        this.memberName = memberName;
        this.petName = petName;
        this.petColor = petColor;
        this.note = note;
        this.adoptionTime = adoptionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getAdoptionTime() {
        return adoptionTime;
    }

    public void setAdoptionTime(Date adoptionTime) {
        this.adoptionTime = adoptionTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
