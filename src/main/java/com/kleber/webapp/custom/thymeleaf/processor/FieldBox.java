package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractConditionalVisibilityElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Node;

public class FieldBox extends AbstractConditionalVisibilityElementProcessor {

  public FieldBox() {
    super("field-box");
  }

  public boolean removeHostElementIfVisible(Arguments arguments, Element element) {
    return false;
  }

  public boolean isVisible(Arguments arguments, Element element) {
    java.lang.reflect.Field field = (java.lang.reflect.Field) element.getNodeProperty("field");
    for(Element node : element.getElementChildren()) {
      if(node.getNormalizedName().equals(field.getName())) {
        node.setProcessable(true);
        return true;
      }
    }
    return false;
  }

  public int getPrecedence() {
    return 1000;
  }

}
