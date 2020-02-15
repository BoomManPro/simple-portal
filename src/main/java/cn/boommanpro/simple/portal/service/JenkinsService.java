package cn.boommanpro.simple.portal.service;

import java.util.Optional;

import cn.boommanpro.simple.portal.dao.ViewDataMapper;
import cn.boommanpro.simple.portal.enums.ViewDataType;
import cn.boommanpro.simple.portal.model.ViewData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
 * @author wangqimeng
 * @date 2020/1/14 15:04
 */
@Service
public class JenkinsService {

    private final ViewDataMapper viewDataMapper;

    public JenkinsService(ViewDataMapper viewDataMapper) {
        this.viewDataMapper = viewDataMapper;
    }

    public String getUrl(Integer id) {

        return Optional.ofNullable(viewDataMapper.selectOne(
                new QueryWrapper<ViewData>().eq(ViewData.COL_ID, id).eq(ViewData.COL_TYPE, ViewDataType.JENKINS))
        )
                .orElseThrow(() -> new RuntimeException("")).getLink();
    }

}
