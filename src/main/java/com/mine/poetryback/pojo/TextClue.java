package com.mine.poetryback.pojo;

import lombok.Data;

@Data
public class TextClue {

    private Integer titleId;//题目序号
    private String title;//题目标题

    private String A;//线索A
    private String B;
    private String C;
    private String D;

    private String answer;//答案
}
