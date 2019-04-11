package com.liu.tender_info.controller;

import com.liu.tender_info.bean.Expert;
import com.liu.tender_info.mapper.ExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ExpertController {

    @Autowired
    ExpertMapper expertMapper;


    @RequestMapping("/getExpertById/{expert_id}")
    public Expert getExpertById(@PathVariable("expert_id") Integer expert_id){
        System.out.println(expert_id);
        Expert ex = expertMapper.getExpertById(expert_id);
        return  ex;
    }

    @RequestMapping("/getExpertByName/{expert_Name}")
    public Expert getExpertByName(@PathVariable("expert_Name") String expert_Name){
        System.out.println(expert_Name);
        Expert ex = expertMapper.getExpertByName(expert_Name);
        return  ex;
    }

    @RequestMapping("/getExpertByProfession/{expert_profession}")
    public List<Expert> getExpertByProfession(@PathVariable("expert_profession") String expert_profession){
        System.out.println(expert_profession);
        List<Expert> ex = expertMapper.getExpertByProfession(expert_profession);
        return  ex;
    }

    @RequestMapping("/getExpertByLevel/{expert_level}")
    public List<Expert> getExpertByLevel(@PathVariable("expert_level") String expert_level){
        System.out.println(expert_level);
        List<Expert> ex = expertMapper.getExpertByLevel(expert_level);
        return  ex;
    }

    @RequestMapping("/getExpertByPrice/{min}/{max}")
    public List<Expert> getExpertByPrice(@PathVariable("min") Integer min,@PathVariable("max") Integer max){
        System.out.println(min);
        System.out.println(max);
        List<Expert> ex = expertMapper.getExpertByPrice(min,max);
        return  ex;
    }

    @RequestMapping("/addExpert")
    public int addExpert(Expert expert){
        return expertMapper.addExpert(expert);
    }

    @RequestMapping("/updateExpert")
    public int updateExpert(Expert expert){
        return expertMapper.updateExpert(expert);
    }

    @RequestMapping("/deleteExpert/{expert_id}")
    public int deleteExpert(Integer expert_id){
        return expertMapper.deleteExpert(expert_id);
    }




    @RequestMapping("/getCount")
    public int getCojunt(){
        int count = expertMapper.getCount();
        return count;
    }
}
