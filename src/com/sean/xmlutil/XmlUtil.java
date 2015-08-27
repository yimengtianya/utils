package com.sean.xmlutil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.javafx.scene.paint.GradientUtils.Parser;

public class XmlUtil {
	private DocumentBuilderFactory  bf = DocumentBuilderFactory.newInstance();
	
	public Document parse(String path){
		Document document = null;
		DocumentBuilder builder;
		try {
			builder = bf.newDocumentBuilder();
			document = builder.parse(new File(path));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public static void main(String[] args){
		XmlUtil xu = new XmlUtil();
		Document document = xu.parse("E:/xml/example.xml");
		Element element = document.getDocumentElement();
		
		Node bean = document.getElementsByTagName("bean").item(0);
		NamedNodeMap attr = bean.getAttributes();
		Node item = attr.getNamedItem("class");
		
		System.out.println(item.getNodeValue());
		
		Class aClass = null;
		Class bClass = null;
		try {
			aClass = Class.forName(item.getNodeValue());
			bClass = Class.forName("com.sean.xmlutil.B");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DOMException e) {
			e.printStackTrace();
		}
		Constructor con = null;
		try {
			con = aClass.getConstructor(B.class);
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		}
		A a = null;
		B b = null;
		try {
			b = (B) bClass.newInstance();
			try {
				a = (A) con.newInstance(b);
			} catch (IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		a.run();
		
		Node word = document.getElementsByTagName("word").item(0);
		System.out.println(word.getTextContent());
	}
}





















