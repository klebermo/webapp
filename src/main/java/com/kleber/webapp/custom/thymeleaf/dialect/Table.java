package com.kleber.webapp.custom.thymeleaf.dialect;

import java.util.Set;
import java.util.HashSet;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Table extends AbstractDialect {

  public Table() {
    super();
  }

  public String getPrefix() {
    return null;
  }

  public Set<IProcessor> getProcessors() {
    final Set<IProcessor> processor = new HashSet<IProcessor>();
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Table());
    return processor;
  }
}
