package cn.dk.base.bean;

import lombok.Data;

import java.util.List;

@Data
public class ListInput {
    String key;

    List<String> values;
}
