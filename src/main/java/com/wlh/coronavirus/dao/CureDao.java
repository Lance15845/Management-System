package com.wlh.coronavirus.dao;


import com.wlh.coronavirus.entity.Base;
import com.wlh.coronavirus.entity.Cure;
import com.wlh.coronavirus.entity.Dead;
import com.wlh.coronavirus.entity.Patient;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CureDao {
    @Select("select baseId,dischargeDate, current from cure")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.wlh.coronavirus.dao.PatientDao.findById")),
            @Result(property = "dischargeDate", column = "dischargeDate"),
            @Result(property = "current", column = "current"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.wlh.coronavirus.dao.BaseDao.findById"))
    })
    //查看所有治愈病人
    public List<Cure> findAll( );

    //添加治愈病人
    @Insert("insert into Cure(baseId,dischargeDate,current)values(#{baseId},#{dischargeDate},#{current})")
    public void add(Cure cure);

    //根据id查找治愈病人
    @Select("select baseId,dischargeDate, current from cure where baseId = #{id}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "dischargeDate", column = "dischargeDate"),
            @Result(property = "current", column = "current"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.wlh.coronavirus.dao.PatientDao.findById")),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.wlh.coronavirus.dao.BaseDao.findById"))
    })
    public Cure findById(int baseId);


    @Select("select count(*) from cure")
    public int number();

    @Select("select count(*) from cure where dischargeDate <#{date}")
    public int beforeDay(Date date);


}
