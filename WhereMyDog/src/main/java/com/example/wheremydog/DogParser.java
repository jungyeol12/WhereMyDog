package com.example.wheremydog;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DogParser {

    String url = "http://apis.data.go.kr/6300000/animalDaejeonService/animalDaejeonList?serviceKey=4FBaXYcryy2%2BcgNgH6SaCqRpCF3fiTUPsozPirpZl07c5%2F36hX68PScjfFM9TCL%2FpErXVA6E1HhyL%2F673SSdEA%3D%3D&numOfRows=10&pageNo=1";

    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    public void dogInformation() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(url);

        // 파싱할 tag
        NodeList nList = doc.getElementsByTagName("items");
        System.out.println("파싱할 리스트 수 : "+ nList.getLength());

        for(int temp = 0; temp < nList.getLength(); temp++){
            Node nNode = nList.item(temp);
            if(nNode.getNodeType() == Node.ELEMENT_NODE){

                Element eElement = (Element) nNode;
                System.out.println("######################");
                //System.out.println(eElement.getTextContent());
                System.out.println("나이  : " + getTagValue("age", eElement));
                System.out.println("성별  : " + getTagValue("gender", eElement)); // 1: 암 2: 수
                System.out.println("종류  : " + getTagValue("classification", eElement)); // 1: 개 2: 고양이 3: 기타동물
                System.out.println("발견 장소  : " + getTagValue("foundPlace", eElement));
                System.out.println("품종 : " + getTagValue("species", eElement));
                System.out.println("몸무게  : " + getTagValue("weight", eElement));
                System.out.println("특이사항  : " + getTagValue("memo", eElement));
                System.out.println("구조일  : " + getTagValue("rescueDate", eElement));
                // System.out.println("이미지  : " + getTagValue("filePath", eElement));
            }	// for end
        }	// if end
    }
}
