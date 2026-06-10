package de.zeynep.homelab.model;

public class Device {

    private String name;
    private String ipAddress;
    private DeviceType deviceType;
    private DeviceStatus status = DeviceStatus.UNKNOWN;

    public Device(String name, String ipAddress, DeviceType deviceType){
        this.name = name;
        this.ipAddress = ipAddress;
        this.deviceType = deviceType;
    }
}
