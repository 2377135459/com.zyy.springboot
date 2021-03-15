package com.springboot.demo.service;

import com.springboot.demo.bean.UserLand;

public interface LandService {
    boolean selectLand(UserLand user);

    boolean updateLandPasword(UserLand user);
}
