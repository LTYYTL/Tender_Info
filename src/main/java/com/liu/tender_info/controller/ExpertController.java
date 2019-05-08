package com.liu.tender_info.controller;

import com.liu.tender_info.bean.Expert;
import com.liu.tender_info.bean.Product;
import com.liu.tender_info.mapper.ExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExpertController {

    @Autowired
    ExpertMapper expertMapper;


    /**
     * 获取所有的数据
     * @param page 第几页
     * @param limit 一页几条数据
     * @return
     */
    @RequestMapping("/getAllExpert")
    public Map getAllProduct(@RequestParam("page") int page, @RequestParam("limit") int limit){
        Map map = new HashMap();
        List<Expert> ex = expertMapper.getAllExpert();
        List<Expert> list = new ArrayList<Expert>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (ex.size()<(page*limit)){
            index = ex.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(ex.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",ex.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getExpertById/{expert_id}")
    public Map getExpertById(@PathVariable("expert_id") Integer expert_id,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(expert_id);
        Map map = new HashMap();
        List<Expert> ex = new ArrayList<Expert>();
        ex.add(expertMapper.getExpertById(expert_id));
        List<Expert> list = new ArrayList<Expert>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (ex.size()<(page*limit)){
            index = ex.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(ex.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",ex.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getExpertByName/{expert_Name}")
    public Map getExpertByName(@PathVariable("expert_Name") String expert_Name,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(expert_Name);
        Map map = new HashMap();
        List<Expert> ex = new ArrayList<Expert>();
        ex.add(expertMapper.getExpertByName(expert_Name));
        List<Expert> list = new ArrayList<Expert>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (ex.size()<(page*limit)){
            index = ex.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(ex.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",ex.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getExpertByProfession/{expert_profession}")
    public Map getExpertByProfession(@PathVariable("expert_profession") String expert_profession,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(expert_profession);
        Map map = new HashMap();
        List<Expert> ex = expertMapper.getExpertByProfession(expert_profession);
        List<Expert> list = new ArrayList<Expert>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (ex.size()<(page*limit)){
            index = ex.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(ex.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",ex.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getExpertByLevel/{expert_level}")
    public Map getExpertByLevel(@PathVariable("expert_level") String expert_level,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(expert_level);
        Map map = new HashMap();
        List<Expert> ex = expertMapper.getExpertByLevel(expert_level);List<Expert> list = new ArrayList<Expert>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (ex.size()<(page*limit)){
            index = ex.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(ex.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",ex.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getExpertByPrice/{min}/{max}")
    public List<Expert> getExpertByPrice(@PathVariable("min") Integer min,@PathVariable("max") Integer max){
        System.out.println(min);
        System.out.println(max);
        List<Expert> ex = expertMapper.getExpertByPrice(min,max);
        return  ex;
    }

    @RequestMapping("/addExpert")
    public String addExpert(Expert expert){
        System.out.println(expert.toString());
        expertMapper.addExpert(expert);
        return "<script>alert(\"添加成功\");setInterval(function(){location.href=\"\\html/expert.html\"},100)</script>";
    }

    @RequestMapping("/updateExpert")
    public String updateExpert(Expert expert){
        System.out.println(expert.toString());
        expertMapper.updateExpert(expert);
        return "<script>alert(\"更新成功\");setInterval(function(){location.href=\"\\html/expert.html\"},100)</script>";
    }

    @RequestMapping("/deleteExpert")
    public int deleteExpert(@RequestParam("expert_id")Integer expert_id){
        System.out.println(expert_id);
        return expertMapper.deleteExpert(expert_id);
    }




    @RequestMapping("/getCount")
    public int getCojunt(){
        int count = expertMapper.getCount();
        return count;
    }
}
