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
import java.util.UUID;

import com.poesys.ms.col.ColumnValueImpl;
import com.poesys.ms.col.IColumnValue;


/**
 * Implements the IPrimaryKey interface for a key constructed from a single UUID
 * value.
 * 
 * @author Robert J. Muller
 */
public class GuidPrimaryKey extends AbstractPrimaryKey {
  /** Serial version UID for Serializable class */
  private static final long serialVersionUID = 7931389459540514239L;
  private final String name;
  private final UUID uuid;

  /**
   * Create a GuidPrimaryKey object.
   * 
   * @param name the primary key column name
   * @param uuid the UUID
   * @param className the name of the IDbDto class of the object that the
   *          primary key identifies
   */
  public GuidPrimaryKey(String name, UUID uuid, String className) {
    super(className);
    this.name = name;
    this.uuid = uuid;
  }

  /**
   * Get the primary key column name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the primary key value UUID.
   * 
   * @return a UUID
   */
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public List<IColumnValue<?>> getColumnValues() {
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>();
    cols.add(new ColumnValueImpl<UUID>(name, IColumnValue.ColumnType.Uuid, uuid));
    return cols;
  }

  @Override
  public String toString() {
    return "[" + name + "=" + uuid.toString() + "]";
  }
}
