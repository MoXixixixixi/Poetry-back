package com.mine.poetryback.pojo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
public class FloKeywords {
    @NonNull
    private String keywords;

    @NotEmpty
    private Integer keywordsId;
}
