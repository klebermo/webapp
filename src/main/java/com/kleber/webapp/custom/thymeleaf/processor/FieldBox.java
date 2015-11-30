package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Map;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;

import org.thymeleaf.processor.element.AbstractConditionalVisibilityElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;

public class FieldBox extends AbstractConditionalVisibilityElementProcessor {

  public FieldBox() {
    super("field-box");
  }

  public boolean removeHostElementIfVisible(Arguments arguments, Element element) {
    return false;
  }

  public boolean isVisible(Arguments arguments, Element element) {
    Field field = (Field) arguments.getLocalVariable("field");
    for(Annotation annotation : field.getAnnotations()) {
      String annotationName = annotation.annotationType().getSimpleName();
      if(annotationName.equals(element.getAttributeValue("type")))
        return true;
    }
    return false;
  }

  public int getPrecedence() {
    return 1000;
  }

}
