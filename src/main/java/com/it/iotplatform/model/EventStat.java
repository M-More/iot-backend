package com.it.iotplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventStat {
    private int total;
    private int todo;
    private int doing;
    private int done;
    private int important_total;
    private int normal_total;
    private int important_todo;
    private int important_doing;
    private int important_done;
    private int normal_todo;
    private int normal_doing;
    private int normal_done;
    private int lastmonth_important;
    private int lastmonth_normal;
    private int lastyear_important;
    private int lastyear_normal;
    private int thisyear_01;
    private int thisyear_02;
    private int thisyear_03;
    private int thisyear_04;
    private int thisyear_05;
    private int thisyear_06;
    private int thisyear_07;
    private int thisyear_08;
    private int thisyear_09;
    private int thisyear_10;
    private int thisyear_11;
    private int thisyear_12;
}
