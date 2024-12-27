package com.starsol.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.starsol.website.jpa.entity.UserPrivilege;
import com.starsol.website.models.Privilege;
import com.starsol.website.jpa.repository.UserPrivilegeRepository;

@Service
public class UserServices {

    @Autowired
    private UserPrivilegeRepository userPrivilegeRepository;

    // por ahora voy a quemar el user y password y token
    public List<Privilege> getUserPrivilegeIds(Integer userId) throws Exception
    {
        List<Privilege> privileges = new ArrayList<>();
        List<UserPrivilege> userpri = userPrivilegeRepository.findPrivilegeIdsByUserId(userId);

        for (UserPrivilege userPrivilege : userpri) {
            // Supongamos que tienes un método para convertir UserPrivilege a Privilege
            Privilege privilege = convertToPrivilege(userPrivilege);
            privileges.add(privilege);
        }
        
        return privileges;
    }


    
    // Método de ejemplo para transformar UserPrivilege a Privilege
    private Privilege convertToPrivilege(UserPrivilege userPrivilege) {
        Privilege privilege = new Privilege();
        privilege.setPrivilegeId(userPrivilege.getId().getPrivilegeId()); 
        privilege.setPrivilegeTypeId(userPrivilege.getPrivilege().getPrivilegeTypeId());
        privilege.setDescription(userPrivilege.getPrivilege().getDescription()); // Ajusta según tus atributos
        return privilege;
    }
}
