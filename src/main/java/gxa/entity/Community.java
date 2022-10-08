package gxa.entity;


import java.util.Date;

public class Community {
    private Integer id;
    private String number;
    private String name;
    private String address;

    private String buildings;
    private String householders;
    private String thumbnail;
    private String property;
    private Date time;





    public Community() {}



    public Community(Integer id,String number, String name, String address, String buildings, String householders,String thumbnail, String property, Date time) {
        this.id=id;
        this.number=number;
        this.name=name;
        this.address=address;
        this.buildings=buildings;
        this.householders=householders;
        this.thumbnail=thumbnail;
        this.property=property;
        this.time=time;
    }

    public Community(String number, String name, String address, String buildings, String householders,String thumbnail, String property, Date time) {
        this.number=number;
        this.name=name;
        this.address=address;
        this.buildings=buildings;
        this.householders=householders;
        this.thumbnail=thumbnail;
        this.property=property;
        this.time=time;
    }

    public Community(int id,String number, String name, String address, String buildings, String householders,String thumbnail, String property) {
        this.id=id;
        this.number=number;
        this.name=name;
        this.address=address;
        this.buildings=buildings;
        this.householders=householders;
        this.thumbnail=thumbnail;
        this.property=property;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildings() {
        return buildings;
    }

    public void setBuildings(String buildings) {
        this.buildings = buildings;
    }

    public String getHouseholders() {
        return householders;
    }

    public void setHouseholders(String householders) {
        this.householders = householders;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
