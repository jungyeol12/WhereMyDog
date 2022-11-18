package com.example.wheremydog;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DogParser {

    String url = "http://apis.data.go.kr/6300000/animalDaejeonService/animalDaejeonList?serviceKey=4FBaXYcryy2%2BcgNgH6SaCqRpCF3fiTUPsozPirpZl07c5%2F36hX68PScjfFM9TCL%2FpErXVA6E1HhyL%2F673SSdEA%3D%3D&numOfRows=10&pageNo=1";

    @FXML
    private Label age;
    @FXML
    private Label gender;
    @FXML
    private Label classification;
    @FXML
    private Label foundPlace;
    @FXML
    private Label species;
    @FXML
    private Label weight;


    @FXML
    private Label memo; // 특이 사항
    @FXML
    private Label adoptionStatusCd; // 입양 상태
    @FXML
    private Label animalSeq; // 게시물 번호
    @FXML
    private Label noticeDate; // 공고일
    @FXML
    private Label regDtTm; // 게시글 등록일

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

                // Pane 에 표시될 기본 정보들
                animalSeq.setText(getTagValue("animalSeq", eElement));
                regDtTm.setText(getTagValue("regDtTm", eElement));
                adoptionStatusCd.setText(getTagValue("adoptionStatusCd", eElement));
                noticeDate.setText(getTagValue("noticeDate", eElement));
                memo.setText(getTagValue("memo", eElement));


                //age.setText("나이: " + getTagValue("age", eElement));
                //gender.setText("성별: " + getTagValue("gender", eElement)); // 1: 암 2: 수
                //classification.setText("종류  : " + getTagValue("classification", eElement)); // 1: 개 2: 고양이 3: 기타동물
                //foundPlace.setText("발견 장소  : " + getTagValue("foundPlace", eElement));
                //species.setText("품종 : " + getTagValue("species", eElement));
                //System.out.println("몸무게  : " + getTagValue("weight", eElement));
            }	// for end
        }	// if end
    }
}
