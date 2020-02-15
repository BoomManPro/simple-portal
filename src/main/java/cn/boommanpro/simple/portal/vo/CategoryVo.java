package cn.boommanpro.simple.portal.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangqimeng
 * @date 2020/1/14 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {

    /**
     * 显示名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;


    private List<ViewDataVo> viewDataList;
}
