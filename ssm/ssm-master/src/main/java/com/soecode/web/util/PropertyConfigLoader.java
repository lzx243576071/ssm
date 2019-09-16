package com.soecode.web.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class PropertyConfigLoader extends PropertyPlaceholderConfigurer {

	static Properties properties;
	 protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException
	 {
		 super.processProperties(beanFactoryToProcess, props);
		 properties = props;
	 }
	 public static String getProperty(String key){
		 return (String)properties.get(key);
	 }
}
