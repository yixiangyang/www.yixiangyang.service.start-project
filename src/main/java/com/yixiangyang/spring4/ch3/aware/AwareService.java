/*package com.yixiangyang.spring4.ch3.aware;

import org.mockito.internal.util.io.IOUtil;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{

	private String beanName;
	
	private ResourceLoader loader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
		
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	public void outputResult(){
		System.out.println("Bean的名称为"+beanName);
		Resource resource = loader.getResource("classpath:/com/yixiangyang/spring4/ch3/aware/test.txt");
		try {
			System.out.println("ResourceLoader文件加载的内容为："+IOUtil.readLines( resource.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
*/