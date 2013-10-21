package com.ru.ssh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
	public static void createXmlFile() throws IOException{
		
        // 创建文档并设置文档的根元素节点 
        Element root = DocumentHelper.createElement("student");  
        Document document = DocumentHelper.createDocument(root);  
  
        root.addAttribute("name", "ruge"); //是指root节点属性 
  
        //添加子节点
        Element subName = root.addElement("name");  
        Element subAge = root.addElement("age");
        Element subMajor = root.addElement("major");
        
        subName.setText("ru");//设置  
        subAge.setText("24");
        subMajor.setText("软件");
  
        subName.addAttribute("job", "programmer");  
  
        OutputFormat format = new OutputFormat("    ", true);  
          
        XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream("F:\\student.xml"), format);  
        xmlWriter2.write(document);  
          
        xmlWriter2.close();
	}
	
	/**
	 * 
	 * analysisXmlFile()
	 * @throws ParserConfigurationException
	 * @throws DocumentException
	 * @throws SAXException
	 * @throws IOException
	 * @return void
	 */
	@Test
	public void analysisXmlFile() throws ParserConfigurationException, DocumentException, SAXException, IOException{
		SAXReader saxReader = new SAXReader();  
        
        Document doc = saxReader.read(new File("F:\\student.xml"));//使用 SAXReader读取xml文件
        Element root = doc.getRootElement();//读取根节点
          
        List childList = root.elements();//得到root根节点下的子节点列表
        
        Element firstNameSub = root.element("name");//获取第一个name子节点
        System.out.println("子节点名称：" + firstNameSub.getName());
        System.out.println("子节点内容：" + firstNameSub.getText());
        System.out.println("子节点属性数：" + firstNameSub.attributeCount());
        System.out.println("子节点名称：" + firstNameSub.attributes().get(0).toString());
          
        for(Iterator iter = root.elementIterator(); iter.hasNext();)  
        {  
            Element e = (Element)iter.next();  
              
            System.out.println(e.attributeValue("age"));  
        }  
          
        System.out.println("---------------------------");  
          
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        org.w3c.dom.Document document = db.parse(new File("student2.xml"));  
          
        DOMReader domReader = new DOMReader();  
          
        //将JAXP的Document转换为dom4j的Document  
        Document d = domReader.read(document);  
          
        Element rootElement = d.getRootElement();  
          
        System.out.println(rootElement.getName());  
	}
}
