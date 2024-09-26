package com.mine.poetryback.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

//pg_subject_table

//诗歌种类
@Data
public class Category {
    @NotNull
    private Integer subjectId;//诗词序号
    @NotNull
    private String subject;//诗词类型名称
}
