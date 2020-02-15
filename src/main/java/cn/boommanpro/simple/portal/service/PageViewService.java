package cn.boommanpro.simple.portal.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.boommanpro.simple.portal.dao.PageStyleMapper;
import cn.boommanpro.simple.portal.dao.ViewCategoryMapper;
import cn.boommanpro.simple.portal.dao.ViewDataMapper;
import cn.boommanpro.simple.portal.model.PageStyle;
import cn.boommanpro.simple.portal.model.ViewCategory;
import cn.boommanpro.simple.portal.model.ViewData;
import cn.boommanpro.simple.portal.vo.CategoryVo;
import cn.boommanpro.simple.portal.vo.ViewDataVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
 * @author wangqimeng
 * @date 2020/1/14 15:04
 */
@Service
public class PageViewService {

    private final PageStyleMapper pageStyleMapper;

    private final ViewDataMapper viewDataMapper;

    private final ViewCategoryMapper viewCategoryMapper;

    public PageViewService(ViewDataMapper viewDataMapper, ViewCategoryMapper viewCategoryMapper, PageStyleMapper pageStyleMapper) {
        this.viewDataMapper = viewDataMapper;
        this.viewCategoryMapper = viewCategoryMapper;
        this.pageStyleMapper = pageStyleMapper;
    }

    public List<CategoryVo> pageView() {
        List<ViewCategory> allViewCategory = viewCategoryMapper.selectList(null);
        List<Integer> viewCateGoryIds = allViewCategory.stream().map(ViewCategory::getId).collect(Collectors.toList());
        QueryWrapper<ViewData> query = new QueryWrapper<ViewData>()
                .in(ViewData.COL_VIEW_CATEGORY_ID, viewCateGoryIds);
        Map<Integer, List<ViewData>> viewDataMap = viewDataMapper.selectList(query)
                .stream()
                .collect(Collectors.groupingBy(ViewData::getViewCategoryId));

        return allViewCategory
                .stream()
                .map(e -> new CategoryVo(e.getName(),
                        e.getDescription(),
                        viewDataMap.get(e.getId()).stream().map(ViewDataVo::new).collect(Collectors.toList()))).collect(Collectors.toList()
                );
    }

    public PageStyle pageStyle() {
        return pageStyleMapper.selectOne(new QueryWrapper<PageStyle>().eq(PageStyle.COL_ENABLE, true));
    }
}
