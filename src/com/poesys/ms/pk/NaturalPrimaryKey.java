/*
 * Copyright (c) 2011 Poesys Associates. All rights reserved.
 * 
 * This file is part of Poesys-DB.
 * 
 * Poesys-DB is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Poesys-DB is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Poesys-DB. If not, see <http://www.gnu.org/licenses/>.
 */
package com.poesys.ms.pk;


import java.util.List;

import com.poesys.ms.col.IColumnValue;


/**
 * <p>
 * Implements the IPrimaryKey interface with a list of single-valued columns.
 * </p>
 * 
 * @author Robert J. Muller
 */
public class NaturalPrimaryKey extends AbstractPrimaryKey {
  /**
   * Serial version UID for Serializable class
   */
  private static final long serialVersionUID = 8983449372538270911L;
  private final List<IColumnValue<?>> columns;

  /**
   * Create a NaturalPrimaryKey object with a list of the key column values.
   * 
   * @param list the list of column values
   * @param className the name of the IDbDto class of the object that the
   *          primary key identifies
   */
  public NaturalPrimaryKey(List<IColumnValue<?>> list, String className) {
    super(className);
    columns = list;
  }

  @Override
  public List<IColumnValue<?>> getColumnValues() {
    return columns;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[");
    String sep = "";
    for (IColumnValue<?> col : columns) {
      builder.append(sep);
      builder.append(col.getName());
      builder.append("=");
      builder.append(col.getValue());
      sep = ", ";
    }
    builder.append("]");
    return builder.toString();
  }
}
