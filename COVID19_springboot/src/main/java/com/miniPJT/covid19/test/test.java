package com.miniPJT.covid19.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class test {
	
	// tag값의 정보를 가져오는 메소드
		private static String getTagValue(String tag, Element eElement) {
		    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0);
		    if(nValue == null) 
		        return null;
		    return nValue.getNodeValue();
		}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String pattern = "yyyy년 MM월 dd일 00시";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String today = simpleDateFormat.format(new Date());
		System.out.println(today);
	}

}
