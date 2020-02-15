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
 * @date 2020/1/14 15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "view_category")
public class ViewCategory {
    /**
     * 主键id自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 显示名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 类型Code
     */
    @TableField(value = "code")
    private String code;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 显示顺序
     */
    @TableField(value = "view_order")
    private Integer viewOrder;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_CODE = "code";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_VIEW_ORDER = "view_order";
}