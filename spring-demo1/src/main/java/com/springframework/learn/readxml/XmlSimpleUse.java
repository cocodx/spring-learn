package com.springframework.learn.readxml;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 16/3/2022 上午7:03
 */
@Slf4j
public class XmlSimpleUse {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        //读取xml文件
        URL url = Thread.currentThread().getContextClassLoader().getResource("test-xml-read.xml");
        InputStream inputStream = url.openStream();
        //再把流转变为InputSource，在后续xml解析使用
        InputSource inputSource = new InputSource(inputStream);
        DocumentBuilderFactory factory = createDocumentBuilderFactory();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //可选，设置实体解析器，其实就是：你可以自定义去哪里加载xsd/dtd文件
        documentBuilder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return null;
            }
        });
        documentBuilder.setErrorHandler(null);
        //解析xml文件，获取document，代表了整个文件
        Document document = documentBuilder.parse(inputSource);
        //获取根元素
        Element root = document.getDocumentElement();
        log.info("root is {}",root);

        //获取根元素下的每个child元素
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element element = (Element) node;
                log.info("element {}",element);
            }
        }

    }

    private static DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        return factory;
    }
}
