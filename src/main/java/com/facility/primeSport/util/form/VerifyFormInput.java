package com.facility.primeSport.util.form;

import com.facility.primeSport.dto.user.UserAuthRegisterRequest;
import com.facility.primeSport.util.CommonUtil;

public class VerifyFormInput {
    public static Boolean isValid(UserAuthRegisterRequest request){
        return CommonUtil.isNullOrEmpathy(request.getUserName())
                || CommonUtil.isValidEmail(request.getEmail())
                || CommonUtil.isValidPhoneNumber(request.getPhoneNumber());
    }
}
