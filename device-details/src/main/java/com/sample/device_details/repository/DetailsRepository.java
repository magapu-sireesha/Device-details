package com.sample.device_details.repository;

import com.sample.device_details.entity.DeviceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<DeviceDetails, Long> {
}
