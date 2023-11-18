package com.wlh.coronavirus.service;

import com.wlh.coronavirus.entity.Inspect;

import java.util.List;

public interface InspectService {
    public List<Inspect> find(int baseId);

}
