package com.wlh.coronavirus.service.iml;

import com.wlh.coronavirus.dao.InspectDao;
import com.wlh.coronavirus.entity.Inspect;
import com.wlh.coronavirus.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InspectServiceImp implements InspectService {
    @Resource
    InspectDao dao;
    @Override
    public List<Inspect> find(int baseId) {
        return dao.findById( baseId);
    }

}
