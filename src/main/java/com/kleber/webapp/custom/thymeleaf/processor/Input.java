package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Input extends AbstractElementProcessor {

  public Input() {
    super("Input");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    Element input = new Element("input");
    input.setProcessable(true);
    input.setAttribute("type", "...");
    element.getParent().insertBefore(element, input);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
