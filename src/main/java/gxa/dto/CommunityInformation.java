package gxa.dto;

public class CommunityInformation {
    private String name;
    private String number;
    private String buildingName;

    @Override
    public String toString() {
        return "CommunityInformation{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", buildingName='" + buildingName + '\'' +
                '}';
    }

    public CommunityInformation(){

    }

    public CommunityInformation(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public CommunityInformation(String buildingName) {
        this.buildingName=buildingName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
