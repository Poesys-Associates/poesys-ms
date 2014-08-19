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


import java.io.Serializable;
import java.util.List;

import com.poesys.ms.col.IColumnValue;


/**
 * A generic interface for primary key data transfer objects.
 * 
 * @author Robert J. Muller
 */
public interface IPrimaryKey extends Serializable {
  /**
   * Get a List of the IColumnValue column values in the key.
   * 
   * @return a List of IColumnValue of unknown basic data type
   */
  List<IColumnValue<?>> getColumnValues();

  /**
   * Get the class name of the class of the object which this primary key
   * identifies.
   * 
   * @return the class name
   */
  String getClassName();
}
