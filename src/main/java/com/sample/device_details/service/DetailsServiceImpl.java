package com.sample.device_details.service;

import com.sample.device_details.entity.DeviceDetails;
import com.sample.device_details.entity.User;
import com.sample.device_details.repository.DetailsRepository;
import com.sample.device_details.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class DetailsServiceImpl implements DetailsService, UserDetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    @Autowired
    private UserRepo userRepo;

    @Override
    public DeviceDetails saveDetails(DeviceDetails deviceDetails) {
        return detailsRepository.save(deviceDetails);
    }

    @Override
    public Optional<DeviceDetails> retrieveDetails(Long id) {
        return detailsRepository.findById(id);
    }

    @Override
    public String getId(long id) {
        String deviceId = detailsRepository.findById(id).get().getDeviceId();
        return deviceId;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userRecord = userRepo.findByEmail(email);
        if(userRecord.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with the email = "+email);
        }
        User user = userRecord.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
