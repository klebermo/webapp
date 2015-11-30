package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Map;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Text;

import com.kleber.webapp.generic.persistence.Model;

public class Textarea extends AbstractElementProcessor {

  public Textarea() {
    super("Textarea");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    java.lang.reflect.Field field = (java.lang.reflect.Field) element.getNodeProperty("field");
    Model target = (Model) arguments.getContext().getVariables().get("command");

    Element node = new Element("textarea");
    node.setAttribute("name", field.getName());
    node.addChild(new Text((String) target.getValue(field.getName())));

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
