package com.mine.poetryback.pojo;

import lombok.Data;

@Data
public class AnsPoetry {

    private Integer poetryId;//诗序号
    private String poetryOn;//诗上一句
    private String poetryUn;//诗下一句
    private String poetrySource;//诗标题、作者
    private Integer subjectId;//诗种类序号
}
