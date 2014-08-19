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
 * A column value is a serializable, single-valued, named data item of a
 * specific data type, with the type specified through an enumerated set of
 * supported types.
 * 
 * @author Robert J. Muller
 * @param <T> the Java data type for the column
 */
public interface IColumnValue<T> extends Serializable {

  /** The column type type */
  public enum ColumnType {
    /** Big Decimal type */
    BigDecimal,
    /** Big Integer type */
    BigInteger,
    /** Date type (no time) */
    Date,
    /** Integer type */
    Integer,
    /** Long integer type */
    Long,
    /** Null type (no value) */
    Null,
    /** String type */
    String,
    /** Timestamp (date and time) type */
    Timestamp,
    /** Uuid (GUID, globally unique identifier) type */
    Uuid;
  }

  /**
   * Get the name.
   * 
   * @return a name
   */
  public abstract String getName();

  /**
   * Get the type.
   * 
   * @return a type
   */
  public abstract ColumnType getType();

  /**
   * Get the value.
   * 
   * @return a value of type T
   */
  public abstract T getValue();
}