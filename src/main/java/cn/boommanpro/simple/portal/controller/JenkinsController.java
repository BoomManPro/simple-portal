package cn.boommanpro.simple.portal.controller;

import cn.boommanpro.simple.portal.service.JenkinsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangqimeng
 * @date 2020/1/14 14:47
 */
@RestController
@RequestMapping("jenkins")
public class JenkinsController {

    private final RestTemplate restTemplate;

    private final JenkinsService jenkinsService;

    public JenkinsController(JenkinsService jenkinsService, RestTemplate restTemplate) {
        this.jenkinsService = jenkinsService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> jenkins(@PathVariable("id") Integer id) {
        return restTemplate.getForEntity(jenkinsService.getUrl(id), String.class);
    }
}
