package com.miniPJT.covid19.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.miniPJT.covid19.model.DayGlobal;

@Component
public class GlobalAPIExplorer {
	
	@Value("${world.covid19.service.key}")
	private String ServiceKey;
	
	public List<DayGlobal> save() throws Exception {
		List<DayGlobal> dayGlobal = new ArrayList<DayGlobal>();
		String today = DateFormat.format();

		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
		+ ServiceKey); 
		urlBuilder
		.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "="
				+ URLEncoder.encode(today, "UTF-8")); /* 검색할 생성일 범위의 시작 */
		urlBuilder.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "="
				+ URLEncoder.encode(today, "UTF-8")); /* 검색할 생성일 범위의 종료 */
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(urlBuilder.toString());
			
			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			// parsing tag
			
			NodeList nodeList = doc.getElementsByTagName("item");
			
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				
				Node nNode = nodeList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element element = (Element) nNode;
					
					
					String stdDay = getTagValue("createDt", element).substring(0,10);
					String areaName = getTagValue("areaNm", element);
					String nationName = getTagValue("nationNm", element);
					int defCnt = Integer.parseInt(getTagValue("natDefCnt", element));
					int deathCnt = Integer.parseInt(getTagValue("natDeathCnt", element));
					
					dayGlobal.add(new DayGlobal(stdDay,areaName,nationName,defCnt,deathCnt));
					
				} // if
				
			} // for
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return dayGlobal;
		
	}

	private static String getTagValue(String tag, Element ele) {
		NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nodeList.item(0);
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}// getTagValue
}
