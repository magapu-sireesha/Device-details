package com.sample.device_details.controller;

import com.sample.device_details.entity.DeviceDetails;
import com.sample.device_details.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    @PostMapping("/save")
    public DeviceDetails saveDetails(@Valid  @RequestBody DeviceDetails deviceDetails) {
        return detailsService.saveDetails(deviceDetails);
    }

    @GetMapping("/echo/{id}")
    public ResponseEntity<Optional<DeviceDetails>> fetchDetails(@PathVariable ("id") Long id) {
        if(detailsService.retrieveDetails(id).isPresent())
            return ResponseEntity.ok(detailsService.retrieveDetails(id));
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<String> fetchDeviceId(@PathVariable("id") Long id) {
        if(detailsService.getId(id) != null)
            return  ResponseEntity.ok(detailsService.getId(id));
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/nocontent")
    public ResponseEntity<Void> fetchNoContent() {
        return ResponseEntity.noContent().build();
    }


}
