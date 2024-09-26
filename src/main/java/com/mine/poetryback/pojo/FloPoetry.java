package com.mine.poetryback.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FloPoetry {
    @NotNull
    private String poetry;//诗句的内容及出处
    private Integer poetryId;//诗句的位置
    @NotEmpty
    private Integer keywordsId;//关键字id

}
