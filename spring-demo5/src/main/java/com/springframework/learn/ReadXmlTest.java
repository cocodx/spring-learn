package com.springframework.learn;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Hello world!
 * 模拟spring读取xml的大致流程去
 * 读取xml文件 test-xml-read.xml
 */
public class ReadXmlTest
{
    public static void main( String[] args )throws Exception
    {
        //读取xml文件
        URL url = Thread.currentThread().getContextClassLoader().getResource("test-xml-read.xml");
        InputStream inputStream = url.openStream();
        //把流转变为InputSource，在后续xml解析中使用
        InputSource inputSource = new InputSource(inputStream);
        DocumentBuilderFactory factory = createDocumentBuilderFactory();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //可选，设置实体解析器，其实就是：你可以自定义在哪里记载xsd/dtd文件
        documentBuilder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return null;
            }
        });
        //设置回调处理器，当解析出现错误时，（biru）
        documentBuilder.setErrorHandler(null);
        //解析xml文件，获取到Document，代表了整个文件
        Document document = documentBuilder.parse(inputSource);
        Element root = document.getDocumentElement();

        //获取根元素下的每个child元素
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element element = (Element) node;
                System.out.println(element);
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
