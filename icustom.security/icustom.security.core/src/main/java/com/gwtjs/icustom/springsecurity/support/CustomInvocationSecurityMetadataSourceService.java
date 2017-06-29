package com.gwtjs.icustom.springsecurity.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.springsecurity.entity.SysResource;
import com.gwtjs.icustom.springsecurity.entity.SysResourceRole;
import com.gwtjs.icustom.springsecurity.entity.SysRole;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysResourceDao;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysResourceRoleDao;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysRoleDao;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {

	protected static Logger logger = LoggerFactory
			.getLogger(CustomInvocationSecurityMetadataSourceService.class);

	@Autowired
	private ISysResourceDao sysResourceDao;
	@Autowired
	private ISysResourceRoleDao sysResourceRoleDao;

	@Autowired
	private ISysRoleDao sysRoleDao;
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	/*public CustomInvocationSecurityMetadataSourceService() {
		loadResourceDefine();
	}*/
	
	@PostConstruct
	// 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
	private void loadResourceDefine() {// 一定要加上@PostConstruct注解
		// 在Web服务器启动时，提取系统中的所有权限。
		List<SysRole> list = new ArrayList<SysRole>()/*sysRoleDao.findAll()*/;
		
		List<String> roleNames = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (SysRole sr : list) {
				// String name = sr.get("name")
				String name = sr.getRolename();
				roleNames.add(name);
			}
		}
		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (String roleName : roleNames) {
			ConfigAttribute ca = new SecurityConfig(roleName);
			
			List<String> urls = new ArrayList<String>();
			logger.debug("\nsysResourceDao:" + sysResourceDao);
			SysRole role = sysRoleDao.findByRoleName(roleName);
			List<SysResourceRole> resourceRoles = sysResourceRoleDao.findByRoleResource(role.getId());
			logger.info(getRoleIds(resourceRoles).toString());
			List<SysResource> resources = new ArrayList<>();
			if(resourceRoles.size()>0)
				resources = sysResourceDao.findByRole(getRoleIds(resourceRoles));
			if (resources != null && resources.size() > 0) {
				for (SysResource resource : resources) {
					// Object value = map.get("resource_string");
					// String url = String.valueOf(value);
					urls.add(resource.getResourceString());
				}
			}
			for (String res : urls) {
				String url = res;

				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
				 */
				if (resourceMap.containsKey(url)) {
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}

			}
		}

	}
	
	private List<Integer> getRoleIds(List<SysResourceRole> rrs){
		List<Integer> ids = new ArrayList<Integer>();
		for (SysResourceRole role : rrs) {
			ids.add(role.getId());
		}
		return ids;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	// 根据URL，找到相关的权限配置。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		logger.debug("object", object.toString());
		// object 是一个URL，被用户请求的url。
		FilterInvocation filterInvocation = (FilterInvocation) object;
		if (resourceMap == null) {
			loadResourceDefine();
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
			if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
