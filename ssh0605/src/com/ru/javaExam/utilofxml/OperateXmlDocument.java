package com.ru.javaExam.utilofxml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.xml.sax.SAXException;


/**
 * 
 * 项目名称：ssh0605
 * 类描述：使用dom4j创建解析xml文件
 * 创建人：成如
 * 创建时间：2013年10月21日 下午3:05:14
 * 修改人：成如
 * 修改时间：2013年10月21日 下午3:05:14
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class OperateXmlDocument {
	
	/**
	 * 
	 * createXml(创建xml文件)
	 * @throws IOException
	 * @return void
	 */
	public static boolean createXmlFile(String rootElement,Map<String, String> map,String savePath) throws IOException{
		
		if(rootElement == null || savePath == null || savePath.equals("") || rootElement.equals("")){
			return false;
		}else if(map != null && map.size() > 0){
			// 创建文档并设置文档的根元素节点 
	        Element root = DocumentHelper.createElement(rootElement);  
	        Document document = DocumentHelper.createDocument(root);  
	  
	        /*//添加子节点
	        Element subName = root.addElement("name");  
	        Element subAge = root.addElement("age");
	        Element subMajor = root.addElement("major");
	        
	        subName.setText("ru");//设置  
	        subAge.setText("24");
	        subMajor.setText("软件");*/
	        for(Iterator it = map.keySet().iterator(); it.hasNext();){
	        	String key = (String) it.next();
	        	String value = map.get(key);
	        	root.addElement(key).setText(value);
	        }
	        
	        OutputFormat format = new OutputFormat("    ", true);  
	          
	        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(savePath), format);  
	        xmlWriter.write(document);  
	          
	        xmlWriter.close();
		}
		
        return true;
	}
	
	/**
	 * 
	 * analysisXmlFile(解析xml文件)
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 * @throws SAXException
	 * @throws IOException
	 * @return void
	 */
	public static HashMap<String, String> analysisXmlFile(String xmlFilePath) throws Exception{
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(xmlFilePath == null || xmlFilePath.equals("")){
			return map;
		}
		
		SAXReader saxReader = new SAXReader();  
        
        Document doc = saxReader.read(new File(xmlFilePath));//使用 SAXReader读取xml文件
        Element root = doc.getRootElement();//读取根节点
          
        List childList = root.elements();//得到root根节点下的子节点列表
        
        for(Object obj : childList){
     	    Element  childElement = (Element)obj;
     	    String name = childElement.getName();
     	    String txt = childElement.getText();
     	    map.put(name, txt);
        }
        
        System.out.println(map);
        
        return map;
        
        //下面注释代码对Element方法做了一些简单应用
        /*Element firstNameSub = root.element("name");//获取第一个name子节点
        System.out.println("子节点名称：" + firstNameSub.getName());
        System.out.println("子节点内容：" + firstNameSub.getText());
        System.out.println("子节点属性数：" + firstNameSub.attributeCount());
        System.out.println("子节点属性名称：" + firstNameSub.attributeValue("hobby"));*/
          
        /*//使用迭代器
        for(Iterator iter = root.elementIterator(); iter.hasNext();)  
        {  
            Element e = (Element)iter.next();  
              
            System.out.println(e.attributeValue("hobby"));  
        }  */
           
	}
	
	
	public static void main(String[] args) throws Exception{
		try {
			String filePath = "F:\\student.xml";
			String root = "";
			Map<String, String> map = new HashMap<String, String>();
			map.put("语文", "21");
			map.put("数学", "20");
			map.put("英语", "20");
			System.out.println(createXmlFile(root, map, filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
