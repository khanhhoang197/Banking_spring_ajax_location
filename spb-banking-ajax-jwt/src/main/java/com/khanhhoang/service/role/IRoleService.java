package com.khanhhoang.service.role;


import com.khanhhoang.model.Role;
import com.khanhhoang.model.dto.RoleDTO;
import com.khanhhoang.service.IGeneralService;

import java.util.List;

public interface IRoleService extends IGeneralService<Role> {
    List<RoleDTO> getAllRoleDTO();

    Role findByName(String name);
}
