/*
 * Copyright (c) 2008 Poesys Associates. All rights reserved.
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
 * A concrete implementation of the IPrimaryKey interface that represents an
 * association primary key. An association key is a key composed of from two to
 * any number of primary keys of associated objects, linking those objects
 * together. The primary keys must have different column names. The
 * AssociationPrimaryKey is a subclass of AbstractMultiValuedPrimaryKey because
 * you construct it with multiple primary keys, not column values.
 * <p>
 * <em>
 * Note: The association primary key does not enforce any internal constraints
 * on the multiplicity of the mapped rows (1-M-M constraints, for example). The
 * key represents only a single link, not the complete mapping between the
 * objects.
 * </em>
 * </p>
 * 
 * @author Robert J. Muller
 */
public class AssociationPrimaryKey extends AbstractPrimaryKey {
  /** Serial version UID for Serializable class */
  private static final long serialVersionUID = -8647656705092239959L;
  /** The list of keys */
  private List<IPrimaryKey> keyList = null;

  /**
   * Create an AssociationPrimaryKey object. An association key must have at
   * least two internal primary keys, and all the keys must have different
   * names.
   * 
   * @param list a list of at least two primary key objects
   * @param className the name of the class of the object that this primary key
   *          identifies
   */
  public AssociationPrimaryKey(List<IPrimaryKey> list, String className) {
    super(className);
    keyList = list;
    // Must have at least two nested primary keys
    if (keyList.size() < 2) {
      throw new RuntimeException("Must have at least 2 keys but had "
                                 + keyList.size());
    }
  }

  @Override
  public List<IColumnValue<?>> getColumnValues() {
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>();
    for (IPrimaryKey key : keyList) {
      cols.addAll(key.getColumnValues());
    }
    return cols;
  }

  /**
   * Get the list of primary keys that make up the association key.
   * 
   * @return a List of IPrimaryKey objects
   */
  public List<IPrimaryKey> getKeys() {
    return keyList;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[Association Key:");
    for (IPrimaryKey key : keyList) {
      builder.append(" Key [");
      String sep = "";
      for (IColumnValue<?> col : key.getColumnValues()) {
        builder.append(sep);
        builder.append(col.getName());
        builder.append("=");
        builder.append(col.getValue());
        sep = ", ";
      }
      builder.append("]");
    }
    builder.append("]");
    return builder.toString();
  }
}
