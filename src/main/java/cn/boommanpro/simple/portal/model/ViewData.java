package cn.boommanpro.simple.portal.model;

import cn.boommanpro.simple.portal.enums.ViewDataType;
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
 * @date 2020/1/14 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "view_data")
public class ViewData {
    /**
     * 主键id 自增
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 类型id
     */
    @TableField(value = "view_category_id")
    private Integer viewCategoryId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 链接
     */
    @TableField(value = "link")
    private String link;

    /**
     * 类型 是否是AJAX
     */
    @TableField(value = "type")
    private ViewDataType type;

    /**
     * 显示顺序
     */
    @TableField(value = "view_order")
    private Integer viewOrder;

    public static final String COL_ID = "id";

    public static final String COL_VIEW_CATEGORY_ID = "view_category_id";

    public static final String COL_NAME = "name";

    public static final String COL_LINK = "link";

    public static final String COL_TYPE = "type";

    public static final String COL_VIEW_ORDER = "view_order";
}