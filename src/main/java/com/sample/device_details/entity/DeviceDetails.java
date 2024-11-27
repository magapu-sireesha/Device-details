package com.sample.device_details.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Please enter record field")
    private String recordType;

    @NotBlank(message = "Please enter device id")
    private String deviceId;

    @CreationTimestamp
    private LocalDateTime eventDateTime;

    @NotNull(message = "Please enter price")
    private Long price;

    @NotBlank(message = "Please enter model")
    private String model;

    @NotNull(message = "Please enter weight")
    private Double weight;

}

