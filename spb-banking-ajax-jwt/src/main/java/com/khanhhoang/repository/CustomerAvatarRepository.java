package com.khanhhoang.repository;

import com.khanhhoang.model.CustomerAvatar;
import com.khanhhoang.model.dto.CustomerAvatarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerAvatarRepository extends JpaRepository<CustomerAvatar, String> {
    @Query("SELECT NEW com.khanhhoang.model.dto.CustomerAvatarDTO (" +
            "ca.id, " +
            "ca.fileName, " +
            "ca.fileFolder, " +
            "ca.fileUrl, " +
            "ca.fileType, " +
            "ca.cloudId, " +
            "ca.ts, " +
            "ca.customer" +
            ") FROM CustomerAvatar AS ca JOIN Customer AS c ON ca.customer.id = c.id " +
            " WHERE c.deleted = false "
    )
    List<CustomerAvatarDTO> getAllCustomerAvatarDTO();

    @Query("SELECT NEW com.khanhhoang.model.dto.CustomerAvatarDTO (" +
            "ca.id, " +
            "ca.fileName, " +
            "ca.fileFolder, " +
            "ca.fileUrl, " +
            "ca.fileType, " +
            "ca.cloudId, " +
            "ca.ts, " +
            "ca.customer " +
            ") FROM CustomerAvatar AS ca JOIN Customer AS c ON ca.customer.id = c.id " +
            "WHERE c.deleted = false " +
            "AND c.id = :customerId"
    )
    CustomerAvatarDTO getCustomerAvatarById(@Param("customerId") long customerId);
}
