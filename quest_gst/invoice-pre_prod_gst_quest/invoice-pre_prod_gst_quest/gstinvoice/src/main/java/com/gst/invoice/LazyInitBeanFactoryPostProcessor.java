package com.gst.invoice;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class LazyInitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	  @Override
	  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
	      for (String beanName : beanFactory.getBeanDefinitionNames()) {
	        BeanDefinition definition = beanFactory.getBeanDefinition(beanName);
	        definition.setLazyInit(true);
	      }
	  }
	}