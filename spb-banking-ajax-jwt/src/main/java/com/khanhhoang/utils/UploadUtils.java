package com.khanhhoang.utils;

import com.cloudinary.utils.ObjectUtils;
import com.khanhhoang.exception.DataInputException;
import com.khanhhoang.model.Customer;
import com.khanhhoang.model.CustomerAvatar;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UploadUtils {
    public static final String IMAGE_UPLOAD_FOLDER = "customer_image";
    public static final String VIDEO_UPLOAD_FOLDER = "customer_video";
    public Map buildImageUploadParams(CustomerAvatar customerAvatar) {
        if (customerAvatar == null || customerAvatar.getId() == null)
            throw new DataInputException("Không thể upload hình ảnh của sản phẩm chưa được lưu");

        String publicId = String.format("%s/%s", IMAGE_UPLOAD_FOLDER, customerAvatar.getId());

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }

    public Map buildImageDestroyParams(Customer customer, String publicId) {
        if (customer == null || customer.getId() == null)
            throw new DataInputException("Không thể destroy hình ảnh của sản phẩm không xác định");

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }
}
