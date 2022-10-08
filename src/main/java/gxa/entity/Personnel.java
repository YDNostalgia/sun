package gxa.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Personnel {
    private int id;
    private String communityName;
    private String realState;
    private String memberName;
    private String photo;
    private String idCard;
    private String contact;
    private String work;
    private Date birthdate;
    private String sex;
    private String memberType;
    private String note;
    private Date date;


    @Override
    public String toString() {
        return "personnel{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", realState='" + realState + '\'' +
                ", memberName='" + memberName + '\'' +
                ", photo='" + photo + '\'' +
                ", idCard='" + idCard + '\'' +
                ", contact='" + contact + '\'' +
                ", work='" + work + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", sex='" + sex + '\'' +
                ", memberType='" + memberType + '\'' +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }

    public Personnel() {
    }

    public Personnel(int id, String communityName, String realState, String memberName, String photo, String idCard, String contact, String work, Date birthdate, String sex, String memberType, String note, Date date) {
        this.id = id;
        this.communityName = communityName;
        this.realState = realState;
        this.memberName = memberName;
        this.photo = photo;
        this.idCard = idCard;
        this.contact = contact;
        this.work = work;
        this.birthdate = birthdate;
        this.sex = sex;
        this.memberType = memberType;
        this.note = note;
        this.date = date;
    }

    public Personnel(String communityName, String realState, String memberName, String photo, String idCard, String contact, String work, Date birthdate, String sex, String memberType, String note, Date date) {
        this.communityName = communityName;
        this.realState = realState;
        this.memberName = memberName;
        this.photo = photo;
        this.idCard = idCard;
        this.contact = contact;
        this.work = work;
        this.birthdate = birthdate;
        this.sex = sex;
        this.memberType = memberType;
        this.note = note;
        this.date = date;
    }

    public Personnel(int id, String communityName, String realState, String memberName, String photo, String idCard, String contact, String work, Date birthdate, String sex, String memberType, String note) {
        this.id = id;
        this.communityName = communityName;
        this.realState = realState;
        this.memberName = memberName;
        this.photo = photo;
        this.idCard = idCard;
        this.contact = contact;
        this.work = work;
        this.birthdate = birthdate;
        this.sex = sex;
        this.memberType = memberType;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getRealState() {
        return realState;
    }

    public void setRealState(String realState) {
        this.realState = realState;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
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
