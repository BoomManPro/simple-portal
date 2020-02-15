package cn.boommanpro.simple.portal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author wangqimeng
 * @date 2020/1/14 20:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "page_style")
public class PageStyle {
    /**
     * 主键id 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 底部
     */
    @TableField(value = "footer")
    private String footer;

    /**
     * 是否可用
     */
    @TableField(value = "enable")
    private Boolean enable;

    /**
     * 组件长度
     */
    @TableField(value = "component_length")
    private Integer componentLength;

    public static final String COL_ID = "id";

    public static final String COL_TITLE = "title";

    public static final String COL_FOOTER = "footer";

    public static final String COL_ENABLE = "enable";

    public static final String COL_COMPONENT_LENGTH = "component_length";
}