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
package com.poesys.ms.col;


import java.io.Serializable;


/**
 * An implementation of the IColumnValue interface that represents a column
 * value of a specific data type.
 * 
 * @author Robert J. Muller
 * @param <T> the Java data type for the implementation of the interface
 */
public class ColumnValueImpl<T> implements Serializable, IColumnValue<T> {

  /**
   * Generated serial version UID for Serializable object
   */
  private static final long serialVersionUID = -359907735683360263L;

  /** The column name */
  protected final String name;

  /** The column type for this column */
  protected final ColumnType type;

  /** The value for the column */
  protected final T value;

  /**
   * Create an AbstractColumnValue object with a required name and data type.
   * The appropriate subclass creates the value with data of the specified type.
   * 
   * @param name the required name for the column
   * @param type the data type for the column
   * @param value the column value of type T
   */
  public ColumnValueImpl(String name, ColumnType type, T value) {
    if (name == null) {
      throw new RuntimeException("Null column name");
    }
    if (type == null) {
      throw new RuntimeException("Null column type");
    }
    if (value == null) {
      throw new RuntimeException("Null column value");
    }
    this.name = name;
    this.type = type;
    this.value = value;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ColumnType getType() {
    return type;
  }

  @Override
  public T getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return "[" + name + "=" + value + "]";
  }
}
