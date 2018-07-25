package com.ajax.cal.service;


import com.db.UserCalenderEntry;
import lombok.Data;

import java.util.List;

@Data
public class CalDto {

    private final List<UserCalenderEntry> cals;



}
