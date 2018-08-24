package com.example.multimedia.juniorseoul.Classess;

public class MemorialModel {
    private String memorialName;
    private String address;
    private double latitude;
    private double longitude;
    private String phoneNum;
    private String administration;
    private String webSite;
    private boolean caseByCase=false;
    private int adultPrice=-1;
    private int juvenilePrice=-1;
    private int kidPrice=-1;


    public MemorialModel(String memorialName, String address, double latitude, double longitude, String phoneNum, String administration, String webSite, boolean caseByCase, int adultPrice, int juvenilePrice, int kidPrice) {
        this.memorialName = memorialName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNum = phoneNum;
        this.administration = administration;
        this.webSite = webSite;
        this.caseByCase = caseByCase;
        this.adultPrice = adultPrice;
        this.juvenilePrice = juvenilePrice;
        this.kidPrice = kidPrice;
    }

    public MemorialModel(String memorialName, String address, double latitude, double longitude, String phoneNum, String administration, String webSite) {
        this.memorialName = memorialName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNum = phoneNum;
        this.administration = administration;
        this.webSite = webSite;
    }

    public String getMemorialName() {
        return memorialName;
    }

    public void setMemorialName(String memorialName) {
        this.memorialName = memorialName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }


    public boolean isCaseByCase() {
        return caseByCase;
    }

    public void setCaseByCase(boolean caseByCase) {
        this.caseByCase = caseByCase;
    }


    public int getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public int getJuvenilePrice() {
        return juvenilePrice;
    }

    public void setJuvenilePrice(int juvenilePrice) {
        this.juvenilePrice = juvenilePrice;
    }

    public int getKidPrice() {
        return kidPrice;
    }

    public void setKidPrice(int kidPrice) {
        this.kidPrice = kidPrice;
    }
}
