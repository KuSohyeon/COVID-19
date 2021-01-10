package com.miniPJT.covid19.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.miniPJT.covid19.model.DaySido;
import com.miniPJT.covid19.model.TotalSido;
import com.miniPJT.covid19.service.SidoService;

public class test {
	
	private static SidoService service;
	
	// tag값의 정보를 가져오는 메소드
		private static String getTagValue(String tag, Element eElement) {
		    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0);
		    if(nValue == null) 
		        return null;
		    return nValue.getNodeValue();
		}
		// 어제 지역별 확진/사망자 수 가져오기
		private static DaySido selectYesterdayToday(String sido) {
			Date dDate = new Date();
			dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
			SimpleDateFormat dSdf = new SimpleDateFormat("yyyyMMdd");
			String yesterday = dSdf.format(dDate);
			System.out.println("y today : " + yesterday);
			
			Map<String, String> yTotal = new HashMap<>();
			yTotal.put("stdDay", yesterday);
			yTotal.put("sido", sido);
			
			try {
				DaySido day = service.selectYesterdayToday(yTotal);
				System.out.println(day.getTotalDeathCnt());
				return day;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
//		어제 대한민국 전체 확진/사망자 수 가져오기
		public static TotalSido selectYesterdayTotal(String sido) {
			Date dDate = new Date();
			dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
			SimpleDateFormat dSdf = new SimpleDateFormat("yyyyMMdd");
			String yesterday = dSdf.format(dDate);
			System.out.println("y total : " + yesterday);
			
			Map<String, String> yTotal = new HashMap<>();
			yTotal.put("stdDay", yesterday);
			yTotal.put("sido", sido);
			
			try {
				return service.selectYesterdayTotal(yTotal);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String pattern = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date dDate = new Date();
		dDate = new Date(dDate.getTime()+(1000*60*60*24*-7));
		SimpleDateFormat dSdf = new SimpleDateFormat("yyyyMMdd");
		String week = dSdf.format(dDate);
		System.out.println(week);

		String today = simpleDateFormat.format(new Date());
		System.out.println(today);
		
		String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=%2FtZv4ogMKsNt56%2BAOss7VBpucmS4SdO3fyisZSq2R2f1%2FH2oFabSJIKGhEZBOvy4%2BbeXw00AWlVdz330O5dkdQ%3D%3D&pageNo=1&numOfRows=10&startCreateDt="+week+"&endCreateDt="+today;
		
		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(url);

		// root tag 
		doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: items
		
		// 파싱할 tag
		NodeList nList = doc.getElementsByTagName("item");
		System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		
		List<DaySido> list = new ArrayList<>();
		List<TotalSido> totalList = new ArrayList<>();
		
		for(int temp = 0; temp < nList.getLength(); temp++){		
			Node nNode = nList.item(temp);
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) nNode;
				// 총/일일 구분
				String gubun = getTagValue("gubun", eElement);
				int defCnt = Integer.parseInt(getTagValue("defCnt", eElement));
				int deathCnt = Integer.parseInt(getTagValue("deathCnt", eElement));
				String stdDay = getTagValue("stdDay", eElement);
				
				System.out.println(gubun);
				
				if(gubun.equals("합계")) { // 총 확진자
					TotalSido tSido = selectYesterdayTotal(gubun);
					int yDeathCnt = tSido.getTotalDeathCnt() + deathCnt;
					int yDefCnt = tSido.getTotalDefCnt() + defCnt;
					tSido.setSido(gubun);
					tSido.setDayDefCnt(defCnt);
					tSido.setDayDeathCnt(deathCnt);
					tSido.setStdDay(today);
					tSido.setTotalDeathCnt(yDeathCnt);
					tSido.setTotalDefCnt(yDefCnt);
					tSido.setStdDay(stdDay);
					
					totalList.add(tSido);
					
				} else { // 지역 확진자
					DaySido sido = selectYesterdayToday(gubun);
					int yDeathCnt = sido.getTotalDeathCnt() + deathCnt;
					int yDefCnt = sido.getTotalDefCnt() + defCnt;
					sido.setSido(gubun);
					sido.setDayDefCnt(defCnt);
					sido.setDayDeathCnt(deathCnt);
					sido.setStdDay(today);
					sido.setTotalDeathCnt(yDeathCnt);
					sido.setTotalDefCnt(yDefCnt);
					sido.setStdDay(stdDay);
					
					list.add(sido);
				}
			}	// for end
		}	// if end
		
		try {
			service.insertToday(list);
			service.insertTotal(totalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
