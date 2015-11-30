package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Map;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;

import com.kleber.webapp.generic.persistence.Model;

public class Input extends AbstractElementProcessor {

  public Input() {
    super("Input");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    java.lang.reflect.Field field = (java.lang.reflect.Field) element.getNodeProperty("field");
    Model target = (Model) arguments.getContext().getVariables().get("command");

    Element node = new Element("input");
    for(java.lang.annotation.Annotation annotation : field.getAnnotations())
      if(!annotation.annotationType().getSimpleName().equals("Input") && !annotation.annotationType().getSimpleName().equals("Column"))
        node.setAttribute("type", annotation.annotationType().getSimpleName().toLowerCase());
    node.setAttribute("name", field.getName());
    node.setAttribute("value", (String) target.getValue(field.getName()));

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
