package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Checkbox extends AbstractElementProcessor {

  public Checkbox() {
    super("Checkbox");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    Element checkbox = new Element("input");
    checkbox.setProcessable(true);
    checkbox.setAttribute("type", "checkbox");
    element.getParent().insertBefore(element, checkbox);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
