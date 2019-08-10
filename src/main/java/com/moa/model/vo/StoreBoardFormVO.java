package com.moa.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreBoardFormVO {
    @NotBlank
    private String hostId;
    @NotBlank
    private String transactionType;
    @Max(100)
    private String pet;
    @NotBlank
    private String cctv;
    @NotBlank
    private List<String> forbiddenCategoryList;
    @NotBlank
    private List<String> forbiddenProductList;
    @NotBlank
    private String storagePeriodType;
    @NotBlank
    @Pattern(regexp = "\\d")
    private List<String> price;
    @NotBlank
    private List<String> pictureName;
    @NotBlank
    @Max(20)
    @Min(1)
    private String title;
    @NotBlank
    @Max(1333)
    @Min(1)
    private String content;
    @NotBlank
    private int storageId;
}
