package com.gwtjs.springsecurity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.gwtjs.springsecurity.entity.SysResource;
import com.gwtjs.springsecurity.service.SysResourceService;

@Configuration
public class RequestMappingHandlerConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(RequestMappingHandlerConfig.class);
	
	@Autowired
	private SysResourceService resourceService;
	
	@Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
        return mapping;
    }
	
	/**
	 * 使用spring的RequestMappingHandlerMapping类自动扫描入库
	 * 扫描URL，如果数据库中不存在，则保存入数据库
	 */
	@PostConstruct
	// 这个注解很重要，可以在每次启动的时候检查是否有URL更新，RequestMappingHandlerMapping只能在controller层用。这里我们放在主类中
	public void detectHandlerMethods() {
		final RequestMappingHandlerMapping requestMappingHandlerMapping = requestMappingHandlerMapping();
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
				.getHandlerMethods();
		Set<RequestMappingInfo> mappings = map.keySet();
		// Map<String, String> reversedMap = new HashMap<String, String>();
		for (RequestMappingInfo info : mappings) {
			HandlerMethod method = map.get(info);
			String methodstr = method.toString();
			methodstr = methodstr.split("\\(")[0];
			methodstr = methodstr.split(" ")[2];
			int i = methodstr.lastIndexOf(".");
			methodstr = methodstr.substring(0, i);
			String urlparm = info.getPatternsCondition().toString();
			String url = urlparm.substring(1, urlparm.length() - 1);
			List<SysResource> list = resourceService.findByResourceString(url);
			if (list == null || list.size() <= 0) {
				int num = (int) (Math.random() * 100 + 1);
				String rand = String.valueOf(num);
				String resourceId = "res" + System.currentTimeMillis() + rand;
				SysResource resource = new SysResource();
				resource.setResourceString(url);
				resource.setRemark("0");
				resource.setResourceId(resourceId);
				resource.setMethodPath(methodstr);
				resourceService.save(resource);
				log.debug("===>" , url);
			}

		}
	}
	
}
