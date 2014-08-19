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
 * An implementation of the IColumnValue interface that represents a null column
 * value that has a specific JDBC data type. Note that this is not currently
 * used by messaging as all messages required non-null columns in an active
 * primary key; this implementation exists for completeness.
 * 
 * @author Robert J. Muller
 */
public class NullColumnValueImpl implements Serializable, IColumnValue<Integer> {
  /** Generated serial version UID for Serializable object */
  private static final long serialVersionUID = 6532698850260304548L;

  /** The column name */
  protected final String name;

  /** The column type for this column */
  protected final ColumnType type;

  /** The value for the column */
  protected final Integer value;

  /**
   * Create a null column value with a target JDBC type.
   * 
   * @param name the required name for the column
   * @param type the data type for the column
   * @param jdbcType the JDBC java.sql.type type for the data
   */
  public NullColumnValueImpl(String name, ColumnType type, Integer jdbcType) {
    if (name == null) {
      throw new RuntimeException("Null column name");
    }
    if (type == null) {
      throw new RuntimeException("Null column type");
    }
    if (jdbcType == null) {
      throw new RuntimeException("Null JDBC type for null column value");
    }
    this.name = name;
    this.type = type;
    this.value = jdbcType;
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
  public Integer getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return "[" + name + "=null,JDBC Type=" + value + "]";
  }
}
