package com.sftest.rest.utils;


	
	import java.io.File;

	import java.io.FileInputStream;

	import java.io.FileNotFoundException;

	import java.io.IOException;

	import java.util.Properties;



	public class SFUtil {

		Properties properties;

		

		public SFUtil() {

			// TODO Auto-generated constructor stub

			ClassLoader classLoader = getClass().getClassLoader();

			

			try {

				File file = new File(classLoader.getResource("resources.properties").getFile());

				FileInputStream prop = new FileInputStream(file);

				

				properties = new Properties();

				properties.load(prop);

				

			}catch(FileNotFoundException fne) {

				fne.printStackTrace();

			}catch(IOException ie) {

				ie.printStackTrace();

			}

		}

		

		public String getProperty(String key) {

			return properties.getProperty(key);

		}

	}


