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


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.poesys.ms.col.ColumnValueImpl;
import com.poesys.ms.col.IColumnValue;


/**
 * Implements the identity primary key (a generated integer value key).
 * 
 * @author Robert J. Muller
 */
public class IdentityPrimaryKey extends AbstractPrimaryKey {
  /**
   * Serial version UID for Serializable class
   */
  private static final long serialVersionUID = 3711684893956067362L;

  private final String name;
  private final BigInteger value;

  /**
   * Create a primary key with a column value. Use this constructor to build a
   * key from a value coming from the database for an existing object.
   * 
   * @param name the name of the primary key column
   * @param value the integer key value
   * @param className the name of the IDbDto class of the object that the
   *          primary key identifies
   * 
   * @throws InvalidParametersException when the name is null
   */
  public IdentityPrimaryKey(String name, BigInteger value, String className) {
    super(className);
    this.name = name;
    this.value = value;
  }

  /**
   * Get the name.
   * 
   * @return a name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the value.
   * 
   * @return a value
   */
  public BigInteger getValue() {
    return value;
  }

  @Override
  public List<IColumnValue<?>> getColumnValues() {
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>();
    cols.add(new ColumnValueImpl<BigInteger>(name,
                                             IColumnValue.ColumnType.BigInteger,
                                             value));
    return cols;
  }

  @Override
  public String toString() {
    return "[Identity " + name + "=" + value + "]";
  }
}
