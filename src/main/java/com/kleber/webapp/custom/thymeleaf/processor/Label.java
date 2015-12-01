package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Map;
import java.util.Locale;
import java.util.ResourceBundle;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Text;

public class Label extends AbstractElementProcessor {

  public Label() {
    super("Label");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    java.lang.reflect.Field field = (java.lang.reflect.Field) element.getNodeProperty("field");
    Locale currentLocale = Locale.getDefault();
		ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);

    Element node = new Element("input");
    node.addChild(new Text(messages.getString(field.getName())));

    for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
      node.setAttribute(entry.getKey(), entry.getValue().getValue());

    element.getParent().insertBefore(element, node);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
