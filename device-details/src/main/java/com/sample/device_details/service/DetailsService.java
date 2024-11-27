package com.sample.device_details.service;

import com.sample.device_details.entity.DeviceDetails;

import java.util.Optional;

public interface DetailsService {

    public DeviceDetails saveDetails(DeviceDetails deviceDetails);

    public Optional<DeviceDetails> retrieveDetails(Long id);

    public String getId(long id);

}
