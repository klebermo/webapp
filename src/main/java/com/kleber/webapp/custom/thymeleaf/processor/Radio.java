package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Radio extends AbstractElementProcessor {

  public Radio() {
    super("Radio");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    Element radio = new Element("input");
    radio.setProcessable(true);
    radio.setAttribute("type", "radio");
    element.getParent().insertBefore(element, radio);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
