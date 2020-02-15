package cn.boommanpro.simple.portal.vo;

import cn.boommanpro.simple.portal.enums.ViewDataType;
import cn.boommanpro.simple.portal.model.ViewData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @author wangqimeng
 * @date 2020/1/14 15:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewDataVo {

    /**
     * 请求 id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    private String link;

    /**
     * 显示类型
     */
    private ViewDataType type;



    public ViewDataVo(ViewData v) {
        BeanUtils.copyProperties(v, this);
    }
}
