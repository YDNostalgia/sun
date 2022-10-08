package gxa.entity;

import java.util.Date;

public class Car {
    private int id;
    private String photo;
    private String memberName;
    private String carColor;
    private String carNumber;
    private String note;
    private Date date;

    public Car() {
    }

    public Car(int id, String photo, String memberName, String carColor, String carNumber, String note, Date date) {
        this.id = id;
        this.photo = photo;
        this.memberName = memberName;
        this.carColor = carColor;
        this.carNumber = carNumber;
        this.note = note;
        this.date = date;
    }

    public Car(int id, String photo, String memberName, String carColor, String carNumber, String note) {
        this.id = id;
        this.photo = photo;
        this.memberName = memberName;
        this.carColor = carColor;
        this.carNumber = carNumber;
        this.note = note;
    }

    public Car(String photo, String memberName, String carColor, String carNumber, String note, Date date) {
        this.photo = photo;
        this.memberName = memberName;
        this.carColor = carColor;
        this.carNumber = carNumber;
        this.note = note;
        this.date = date;
    }

    public Car(String photo, String memberName, String carColor, String carNumber, String note) {
        this.photo = photo;
        this.memberName = memberName;
        this.carColor = carColor;
        this.carNumber = carNumber;
        this.note = note;
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

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
