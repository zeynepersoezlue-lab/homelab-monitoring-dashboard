package de.zeynep.homelab.controller;
import de.zeynep.homelab.model.Device;
import de.zeynep.homelab.model.DeviceType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class DeviceController {
    private int nextId = 1;

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

        macbook.setId(nextId++);
        devices.add(macbook);

        lenovo.setId(nextId++);
        devices.add(lenovo);

        fritzbox.setId(nextId++);
        devices.add(fritzbox);

        hpDrucker.setId(nextId++);
        devices.add(hpDrucker);

        ipad.setId(nextId++);
        devices.add(ipad);

        iphone11.setId(nextId++);
        devices.add(iphone11);

        iphone17.setId(nextId++);
        devices.add(iphone17);

        alexa.setId(nextId++);
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

    @GetMapping("/devices/stats/count")
    public int getDevicesCount(){
        return devices.size();
    }

    @GetMapping("/devices/{index}")
    public Device getDevicesIndex(@PathVariable int index){
        if(index < 0 || index >= devices.size()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Device not found"
            );
        }
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

   /* @GetMapping("/devices/{id}")
    public Device getDeviceById(@PathVariable int id){

        for(int i = 0; i < devices.size(); i++){

            Device device = devices.get(i);

            if(device.getId() == id){
                return device;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Device not found"
        );
    }*/
}
