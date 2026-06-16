package de.zeynep.homelab.controller;
import de.zeynep.homelab.model.Device;
import de.zeynep.homelab.model.DeviceType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DeviceController {
    ArrayList<Device> devices = new ArrayList<>();
    Device macbook = new Device("MacBook Air", "192.168.178.10", DeviceType.LAPTOP);
    Device lenovo = new Device("Lenovo","192.168.178.11", DeviceType.LAPTOP);
    Device fritzbox = new Device("FritzBox", "192.168.178.1", DeviceType.ROUTER);
    Device hpDrucker = new Device("HPdrucker", "192.168.178.20", DeviceType.PRINTER);
    Device ipad = new Device("iPad 11", "192.168.178.30", DeviceType.TABLET);
    Device iphone11 = new Device("iPhone 11", "192.168.178.32", DeviceType.SMARTPHONE);
    Device iphone17 = new Device("iPhone 17", "192.168.178.31", DeviceType.SMARTPHONE);
    Device alexa = new Device("Alexa", "192.168.178.40", DeviceType.OTHER);

    public DeviceController(){
        devices.add(macbook);
        devices.add(lenovo);
        devices.add(fritzbox);
        devices.add(hpDrucker);
        devices.add(ipad);
        devices.add(iphone11);
        devices.add(iphone17);
        devices.add(alexa);
    }
    @GetMapping("/devices")
    public ArrayList<Device> getDevices(){
        return devices;
    }

    @PostMapping("/devices")
    public Device postDevices(@RequestBody Device device){
        devices.add(device);
        return device;
    }

    @GetMapping("/devices/count")
    public int getDevicesCount(){
        return devices.size();
    }

    @GetMapping("/devices/{index}")
    public Device getDevicesIndex(@PathVariable int index){
        return devices.get(index);
    }
    @DeleteMapping("/devices/{index}")
    public Device deleteDevice(@PathVariable int index){
        return devices.remove(index);
    }

    @PutMapping("/devices/{index}")
    public Device putDevices(@PathVariable int index, @RequestBody Device device){
        devices.set(index, device);
        return device;
    }
}
