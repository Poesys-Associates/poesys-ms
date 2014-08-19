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


import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Tests the methods on the interface implementation ColumnValueImpl
 * 
 * @author Robert J. Muller
 */
public class ColumnValueImplTest {

  /**
   * Test method for {@link com.poesys.ms.col.ColumnValueImpl#getName()}.
   */
  @Test
  public void testGetName() {
    String name = "columnName";
    IColumnValue<String> col =
      new ColumnValueImpl<String>(name,
                                  IColumnValue.ColumnType.String,
                                  "a string value");
    String retrievedName = col.getName();
    assertTrue("Name not stored as class member", name.equals(retrievedName));
  }

  /**
   * Test method for {@link com.poesys.ms.col.ColumnValueImpl#getType()}.
   */
  @Test
  public void testGetType() {
    String name = "columnName";
    IColumnValue.ColumnType type = IColumnValue.ColumnType.String;
    IColumnValue<String> col =
      new ColumnValueImpl<String>(name, type, "a string value");
    IColumnValue.ColumnType retrievedType = col.getType();
    assertTrue("Type not stored as class member", type == retrievedType);
  }

  /**
   * Test method for {@link com.poesys.ms.col.ColumnValueImpl#getValue()}.
   */
  @Test
  public void testGetValue() {
    String name = "columnName";
    IColumnValue.ColumnType type = IColumnValue.ColumnType.String;
    String value = "a string value";
    IColumnValue<String> col = new ColumnValueImpl<String>(name, type, value);
    String retrievedValue = col.getValue();
    assertTrue("Value not stored as class member", value.equals(retrievedValue));
  }

  /**
   * Test method for {@link com.poesys.ms.col.ColumnValueImpl#toString()}.
   */
  @Test
  public void testToString() {
    String name = "columnName";
    IColumnValue.ColumnType type = IColumnValue.ColumnType.String;
    String value = "a string value";
    IColumnValue<String> col = new ColumnValueImpl<String>(name, type, value);
    assertTrue("toString gives wrong result: " + col.toString(),
               col.toString().equals("[" + name + "=" + value + "]"));
  }

}
