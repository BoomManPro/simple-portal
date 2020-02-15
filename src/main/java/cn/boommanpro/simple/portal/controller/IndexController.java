package cn.boommanpro.simple.portal.controller;

import cn.boommanpro.simple.portal.service.PageViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangqimeng
 * @date 2020/1/14 15:42
 */
@Controller
@RequestMapping
public class IndexController {

    private final PageViewService pageViewService;

    public IndexController(PageViewService pageViewService) {
        this.pageViewService = pageViewService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pageView", pageViewService.pageView());
        model.addAttribute("pageStyle", pageViewService.pageStyle());
        return "index";
    }
}
