package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractIterationElementProcessor;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Form extends AbstractIterationElementProcessor {

  public Form() {
    super("form");
  }

   public void processClonedHostIterationElement(Arguments arguments, Element iteratedChild) {
   }

   public String	getIteratedElementName(Arguments arguments, Element element) {
     return "form";
   }

   public boolean	removeHostIterationElement(Arguments arguments, Element element) {
     return false;
   }

   public AbstractIterationElementProcessor.IterationSpec getIterationSpec(Arguments arguments, Element element) {
     return null;
   }

   public int getPrecedence() {
     return 1000;
   }

}
