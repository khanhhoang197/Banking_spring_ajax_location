package com.khanhhoang.service.customerAvatar;

import com.khanhhoang.model.CustomerAvatar;
import com.khanhhoang.model.dto.CustomerAvatarDTO;
import com.khanhhoang.service.IGeneralService;

import java.util.List;

public interface ICustomerAvatarService extends IGeneralService<CustomerAvatar> {
    List<CustomerAvatarDTO> getAllCustomerAvatarDTO();
    CustomerAvatarDTO getCustomerAvatarById(long customerId);
}
