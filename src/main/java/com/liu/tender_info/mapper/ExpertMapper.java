package com.liu.tender_info.mapper;

import com.liu.tender_info.bean.Expert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExpertMapper {

    /**
     *
     * 通过专家ID获取相应的专家信息
     * @param expert_id  专家ID
     * @return 专家信息
     */
    public Expert getExpertById(Integer expert_id);

    /**
     *
     * 通过专家姓名获取相应专家信息
     * @param expert_Name 专家姓名
     * @return  专家信息
     */
    public Expert getExpertByName(String expert_Name);

    /**
     * 通过专家专业获取所有有关专家信息
     * @param expert_profession  专家专业
     * @return  专家信息的List集合
     */
    public List<Expert> getExpertByProfession(String expert_profession);

    /**
     * 通过专家级别获取所有有关专家信息
     * @param expert_level 专家级别
     * @return  专家信息的List集合
     */
    public List<Expert> getExpertByLevel(String expert_level);

    /**
     * 通过价格区间获取所有有关专家信息
     * @param min  最低值
     * @param max  最高值
     * @return  专家信息的List集合
     */
    public List<Expert> getExpertByPrice(@Param("min") Integer min, @Param("max")Integer max);

    /**
     * 添加专家信息
     * @param expert 专家对象
     * @return
     */
    public int addExpert(Expert expert);

    /**
     * 更新专家信息
     * @param expert 专家对象
     * @return
     */
    public int updateExpert(Expert expert);

    /**
     * 删除专家信息
     * @param expert_id 专家ID
     * @return
     */
    public int deleteExpert(Integer expert_id);

    public int getCount();

    public List<Expert> getAllExpert();
}
