package com.trs.test.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppHot implements Serializable {
    private int hot_id;
    private String msg_title;


}
