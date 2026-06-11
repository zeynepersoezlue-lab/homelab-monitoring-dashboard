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

    public String getName(){
        return name;
    }

    public String getIpAddress(){
        return ipAddress;
    }

    public DeviceType getDeviceType(){
        return deviceType;
    }

    public DeviceStatus getStatus(){
        return status;
    }
}
