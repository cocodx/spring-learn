package com.springframework.learn.rule;

import org.xml.sax.Attributes;

/**
 *
 */
public interface ParseRule {

   /*
   遇到xml元素的开始标记时，调用该方法。
   元素中的属性
    */
   void startElement(Attributes attributes);

   void body(String body);

   void endElement();
}
