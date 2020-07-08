package com.moke.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by MOKE on 2020/7/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{
    private Long id;
    private String serial;
}
