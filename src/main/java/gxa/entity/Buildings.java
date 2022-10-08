package gxa.entity;

import java.util.Date;

public class Buildings {
    private int id;
    private String communityName;
    private String communityNumber;
    private String buildingName;
    private String households;
    private String depict;
    private Date date;


    @Override
    public String toString() {
        return "Buildings{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityNumber='" + communityNumber + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", households='" + households + '\'' +
                ", depict='" + depict + '\'' +
                ", date=" + date +
                '}';
    }

    public Buildings() {
    }


    public Buildings(int id, String communityName, String communityNumber, String buildingName, String households, String depict, Date date) {
        this.id = id;
        this.communityName = communityName;
        this.communityNumber = communityNumber;
        this.buildingName = buildingName;
        this.households = households;
        this.depict = depict;
        this.date = date;
    }

    public Buildings(int id, String communityName, String communityNumber, String buildingName, String households, String depict) {
        this.id = id;
        this.communityName = communityName;
        this.communityNumber = communityNumber;
        this.buildingName = buildingName;
        this.households = households;
        this.depict = depict;
    }

    public Buildings(String communityName, String communityNumber, String buildingName, String households, String depict, Date date) {
        this.communityName = communityName;
        this.communityNumber = communityNumber;
        this.buildingName = buildingName;
        this.households = households;
        this.depict = depict;
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

    public String getCommunityNumber() {
        return communityNumber;
    }

    public void setCommunityNumber(String communityNumber) {
        this.communityNumber = communityNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getHouseholds() {
        return households;
    }

    public void setHouseholds(String households) {
        this.households = households;
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
