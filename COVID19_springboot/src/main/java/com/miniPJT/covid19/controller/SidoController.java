package com.miniPJT.covid19.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.miniPJT.covid19.model.DaySido;
import com.miniPJT.covid19.model.TotalSido;
import com.miniPJT.covid19.service.SidoService;

@RestController
public class SidoController {
	@Autowired
	private SidoService service;
	
	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
	
//	현재 날짜를 기준으로 -7일의 일일 확진자 수 db에 저장 (초기값 설정)
	public void insertWeek() throws ParserConfigurationException, SAXException, IOException {
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
		
		for(int temp = 0; temp < nList.getLength(); temp++){		
			Node nNode = nList.item(temp);
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				DaySido sido = new DaySido();
				
				Element eElement = (Element) nNode;
				System.out.println("######################");
				System.out.println("오늘 사망자 수  : " + getTagValue("deathCnt", eElement));
				sido.setDeathCnt(Integer.parseInt(getTagValue("deathCnt", eElement)));
				System.out.println("오늘 확진자 수  : " + getTagValue("defCnt", eElement));
				sido.setDefCnt(Integer.parseInt(getTagValue("defCnt", eElement)));
				System.out.println("지역 : " + getTagValue("gubun", eElement));
				sido.setSido(getTagValue("gubun", eElement));
				System.out.println("기준일시  : " + getTagValue("stdDay", eElement));
				sido.setStdDay(getTagValue("stdDay", eElement));
				
				list.add(sido);
			}	// for end
		}	// if end
		
		try {
			service.insertWeek(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
//	오늘 날짜의 일일/총 확진자 수 db에 저장 : 스케쥴러 사용 (매일 오전 ?시에 정보 갱신)
	public void insertToday() throws ParserConfigurationException, SAXException, IOException {
		String pattern = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String today = simpleDateFormat.format(new Date());
		System.out.println(today);
		
		String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=%2FtZv4ogMKsNt56%2BAOss7VBpucmS4SdO3fyisZSq2R2f1%2FH2oFabSJIKGhEZBOvy4%2BbeXw00AWlVdz330O5dkdQ%3D%3D&pageNo=1&numOfRows=10&startCreateDt="+today+"&endCreateDt="+today;
		
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
				DaySido sido = new DaySido();
				
				Element eElement = (Element) nNode;
				System.out.println("######################");
				int deathCnt = Integer.parseInt(getTagValue("deathCnt", eElement));
				System.out.println("오늘 사망자 수  : " + deathCnt);
				sido.setDeathCnt(deathCnt);
				int defCnt = Integer.parseInt(getTagValue("defCnt", eElement));
				System.out.println("오늘 확진자 수  : " + defCnt);
				sido.setDefCnt(defCnt);
				String gubun = getTagValue("gubun", eElement);
				System.out.println("지역 : " + gubun);
				sido.setSido(gubun);
				String stdDay = getTagValue("stdDay", eElement);
				System.out.println("기준일시  : " + stdDay);
				sido.setStdDay(stdDay);
				
				TotalSido tSido = selectYesterdayTotal(gubun);
				int yDeathCnt = tSido.getDeathCnt() + deathCnt;
				int yDefCnt = tSido.getDefCnt() + defCnt;
				tSido.setDeathCnt(yDeathCnt);
				tSido.setDefCnt(yDefCnt);
				tSido.setStdDay(stdDay);

				totalList.add(tSido);
				list.add(sido);
				
			}	// for end
		}	// if end
		
		try {
			service.insertToday(list);
			service.insertTotal(totalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	어제 총 확진/사망자 수 가져오기
	public TotalSido selectYesterdayTotal(String sido) {
		Date dDate = new Date();
		dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
		SimpleDateFormat dSdf = new SimpleDateFormat("yyyy년 MM월 dd일 00시");
		String yesterday = dSdf.format(dDate);
		System.out.println(yesterday);
		
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
	
//	오늘 날짜 기준 총 확진/사망자 수 가져오기
	@GetMapping
	public List<TotalSido> selectTotal() {
		String pattern = "yyyy년 MM월 dd일 00시";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String today = simpleDateFormat.format(new Date());
		System.out.println(today);

		try {
			return service.selectTotal(today);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	오늘 날짜 기준 일일 확진/사망자 수 가져오기
	@GetMapping
	public List<DaySido> selectToday() {
		String pattern = "yyyy년 MM월 dd일 00시";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String today = simpleDateFormat.format(new Date());
		System.out.println(today);
		
		try {
			return service.selectToday(today);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
