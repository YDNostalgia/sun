package gxa.entity;

import java.util.Date;

public class Parking {
    private int id;
    private String communityName;
    private String parkingNumber;
    private String parkingName;
    private Date date;

    public Parking() {
    }

    public Parking(int id, String communityName, String parkingNumber, String parkingName, Date date) {
        this.id = id;
        this.communityName = communityName;
        this.parkingNumber = parkingNumber;
        this.parkingName = parkingName;
        this.date = date;
    }

    public Parking(int id, String communityName, String parkingNumber, String parkingName) {
        this.id = id;
        this.communityName = communityName;
        this.parkingNumber = parkingNumber;
        this.parkingName = parkingName;
    }

    public Parking(String communityName, String parkingNumber, String parkingName, Date date) {
        this.communityName = communityName;
        this.parkingNumber = parkingNumber;
        this.parkingName = parkingName;
        this.date = date;
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

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
