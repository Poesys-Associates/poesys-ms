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
 * An abstract implementation of the IPrimaryKey interface that implements
 * elements shared between all the primary key classes.
 * 
 * @author Robert J. Muller
 */
public abstract class AbstractPrimaryKey implements IPrimaryKey {
  /** Generated serial version UID for the Serializable object */
  private static final long serialVersionUID = 3727965801735957852L;

  /** the name of the class of the object that this primary key identifies */
  protected String className;

  /**
   * Create a AbstractPrimaryKey object.
   * 
   * @param className the name of the class of the object that this primary key
   *          identifies
   */
  public AbstractPrimaryKey(String className) {
    this.className = className;
  }

  @Override
  abstract public List<IColumnValue<?>> getColumnValues();

  @Override
  public String getClassName() {
    return className;
  }
}
