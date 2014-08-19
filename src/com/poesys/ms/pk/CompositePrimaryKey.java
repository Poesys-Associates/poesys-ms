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


import java.util.ArrayList;
import java.util.List;

import com.poesys.ms.col.IColumnValue;


/**
 * An implementation of the IPrimaryKey interface that represents a composite
 * primary key. A composite key is a key composed of a parent key and an
 * additional primary key of some kind, often an integer (natural key)
 * representing a sort order.
 * 
 * @author Robert J. Muller
 */
public class CompositePrimaryKey extends AbstractPrimaryKey {
  /**
   * Serial version UID for Serializable class
   */
  private static final long serialVersionUID = 7481773653672954407L;
  /** The parent primary key */
  private final IPrimaryKey parentKey;
  /**
   * The child sub-key that identifies the child in combination with the parent
   * key; usually a natural key
   */
  private final IPrimaryKey subKey;

  /**
   * Create a CompositePrimaryKey object.
   * 
   * @param parentKey the key from the owning object
   * @param subKey the key that completes the primary key
   * @param className the name of the IDbDto class of the object that the
   *          primary key identifies
   * @throws InvalidParametersException when there is no parent or sub key
   * @throws DuplicateKeyNameException when there are multiple columns with the
   *           same name
   */
  public CompositePrimaryKey(IPrimaryKey parentKey,
                             IPrimaryKey subKey,
                             String className) {
    super(className);
    this.parentKey = parentKey;
    this.subKey = subKey;

    // Must have both keys.
    if (parentKey == null) {
      throw new RuntimeException("Null parent key in composite key");
    }
    if (subKey == null) {
      throw new RuntimeException("Null child key in composite key");
    }
  }

  /**
   * Get the parentKey.
   * 
   * @return a parentKey
   */
  public IPrimaryKey getParentKey() {
    return parentKey;
  }

  /**
   * Get the subKey.
   * 
   * @return a subKey
   */
  public IPrimaryKey getSubKey() {
    return subKey;
  }

  @Override
  public List<IColumnValue<?>> getColumnValues() {
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>();
    cols.addAll(parentKey.getColumnValues());
    cols.addAll(subKey.getColumnValues());
    return cols;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[Composite Key: ");
    builder.append("Parent key [");
    String sep = "";
    for (IColumnValue<?> col : parentKey.getColumnValues()) {
      builder.append(sep);
      builder.append(col.getName());
      builder.append("=");
      builder.append(col.getValue());
      sep = ", ";
    }
    builder.append("]");
    sep = "";
    builder.append(" Sub key [");
    for (IColumnValue<?> col : subKey.getColumnValues()) {
      builder.append(sep);
      builder.append(col.getName());
      builder.append("=");
      builder.append(col.getValue());
      sep = ", ";
    }
    builder.append("]");
    builder.append("]");
    return builder.toString();
  }
}
