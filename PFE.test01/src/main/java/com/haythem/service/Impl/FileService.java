package com.haythem.service.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import resourceinjection.ResourceInjection;


@Service
public class FileService {

	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"classpath:META-INF/resourceContext.xml");
	
	
	String text ="test : ";
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String readFromFile() throws IOException{
	
		
		InputStream inputStream = null;
		Scanner scanner = null;
		try {
//			Resource classPathResource = applicationContext
//					.getResource("resourceinjection/sample2.txt");
//			inputStream = classPathResource.getInputStream();
//			scanner = new Scanner(inputStream);
//			while (scanner.hasNext()) {
//				System.out.println(scanner.nextLine());
//			}

			ResourceInjection resourceInjection = applicationContext.getBean(
					"resourceInjection", ResourceInjection.class);
			// returns the static resource set in the resourceContext.xml.
			Resource springBeanInjectedResource = resourceInjection
					.getTextFile();
			inputStream = springBeanInjectedResource.getInputStream();
			scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
			text = text + " " + scanner.nextLine();
			}
			//System.out.println(text);
			/**
			 * this returns a resource on run time based on certain condition or
			 * logic. This is accomplished by injecting /*a resource loader in
			 * the bean and then using it to get the resource. See method body
			 */
//			Resource dynamicResourceViaResourceLoader = resourceInjection
//					.loadDynamicResource();
//			inputStream = dynamicResourceViaResourceLoader.getInputStream();
//			scanner = new Scanner(inputStream);
//			while (scanner.hasNext()) {
//				System.out.println(scanner.nextLine());
//			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		
		
		return text;
		
		//return "hello world";
		
		}
	
	
	
	
	public FileService() {
		super();
	}
	
	
}
