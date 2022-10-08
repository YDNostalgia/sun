package gxa.entity;

import java.util.Date;

public class House {
    private int id;
    private String community;
    private String building;
    private String estateCodes;
    private String estateName;
    private String protagonist;
    private String contact;
    private String rooms;
    private String element;
    private String floor;
    private String depict;
    private Date date;

    public House(){

    }

    public House(int id, String community, String building, String estateCodes, String estateName, String protagonist, String contact, String rooms, String element, String floor, String depict, Date date) {
        this.id = id;
        this.community = community;
        this.building = building;
        this.estateCodes = estateCodes;
        this.estateName = estateName;
        this.protagonist = protagonist;
        this.contact = contact;
        this.rooms = rooms;
        this.element = element;
        this.floor = floor;
        this.depict = depict;
        this.date = date;
    }

    public House(String community) {
        this.community = community;
    }

    public House(String community, String building, String estateCodes, String estateName, String protagonist, String contact, String rooms, String element, String floor, String depict, Date date) {
        this.community = community;
        this.building = building;
        this.estateCodes = estateCodes;
        this.estateName = estateName;
        this.protagonist = protagonist;
        this.contact = contact;
        this.rooms = rooms;
        this.element = element;
        this.floor = floor;
        this.depict = depict;
        this.date = date;
    }

    public House(int id,String community, String building, String estateCodes, String estateName, String protagonist, String contact, String rooms, String element, String floor, String depict) {
        this.id = id;
        this.community = community;
        this.building = building;
        this.estateCodes = estateCodes;
        this.estateName = estateName;
        this.protagonist = protagonist;
        this.contact = contact;
        this.rooms = rooms;
        this.element = element;
        this.floor = floor;
        this.depict = depict;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", community='" + community + '\'' +
                ", building='" + building + '\'' +
                ", estateCodes='" + estateCodes + '\'' +
                ", estateName='" + estateName + '\'' +
                ",protagonist='" + protagonist + '\'' +
                ", contact='" + contact + '\'' +
                ", rooms='" + rooms + '\'' +
                ", element='" + element + '\'' +
                ", floor='" + floor + '\'' +
                ", depict='" + depict + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getEstateCodes() {
        return estateCodes;
    }

    public void setEstateCodes(String estateCodes) {
        this.estateCodes = estateCodes;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String householder) {
        this.protagonist = protagonist;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
