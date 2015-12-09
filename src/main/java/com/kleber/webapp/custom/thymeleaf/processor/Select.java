package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Select extends AbstractElementProcessor {

  public Select() {
    super("Select");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    Element select = new Element("select");
    select.setProcessable(true);
    element.getParent().insertBefore(element, select);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
