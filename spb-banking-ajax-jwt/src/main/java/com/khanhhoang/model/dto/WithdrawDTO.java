package com.khanhhoang.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class WithdrawDTO implements Validator {
    private long id;

    @NotEmpty(message = "Thông tin khách hàng là bắt buộc")
    @Pattern(regexp = "^\\d+$", message = "ID khách hàng không hợp lệ")
    private String customerId;

    @NotEmpty(message = "Thông tin khách hàng là bắt buộc")
    @Pattern(regexp = "^\\d+$", message = "ID khách hàng không hợp lệ")
    private String transactionAmount;

    @Override
    public boolean supports(@NotNull Class<?> aClass) {
        return WithdrawDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        WithdrawDTO withdrawDTO = (WithdrawDTO) target;

        String transactionAmount = withdrawDTO.getTransactionAmount();

        if (transactionAmount != null && transactionAmount.length() > 0) {
            if (transactionAmount.length() > 9){
                errors.rejectValue("transactionAmount", "transactionAmount.max", "Số tiền chuyển khoản tối đa là 1.000.000.000 VNĐ");
                return;
            }

            if (transactionAmount.length() < 6){
                errors.rejectValue("transactionAmount", "transactionAmount.min.length", "Số tiền chuyển khoản thấp nhất là 100.000 VNĐ");
                return;
            }

            if (!transactionAmount.matches("(^$|[0-9]*$)")){
                errors.rejectValue("transactionAmount", "transactionAmount.number", "Chỉ chấp nhận số tiền chuyển khoản là ký tự số");
            }

            float transactionAmountFloat= Float.parseFloat(transactionAmount);

            if (transactionAmountFloat % 10 > 0) {
                errors.rejectValue("transactionAmount", "transactionAmount.decimal", "Số tiền chuyển khoản phải là số chẵn chia hết cho 10");
            }

        } else {
            errors.rejectValue("transactionAmount",  "transactionAmount.null", "Số tiền chuyển khoản là bắt buộc");
        }
    }
}
