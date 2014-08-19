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


import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Tests the methods on the interface implementation NullColumnValueImpl
 * 
 * @author Robert J. Muller
 */
public class NullColumnValueImplTest {

  /**
   * Test method for {@link com.poesys.ms.col.NullColumnValueImpl#getName()}.
   */
  @Test
  public void testGetName() {
    String name = "columnName";
    Integer jdbcType = java.sql.Types.VARCHAR;
    IColumnValue<Integer> col =
      new NullColumnValueImpl(name, IColumnValue.ColumnType.Null, jdbcType);
    String retrievedName = col.getName();
    assertTrue("Name not stored as class member", name.equals(retrievedName));
  }

  /**
   * Test method for {@link com.poesys.ms.col.NullColumnValueImpl#getType()}.
   */
  @Test
  public void testGetType() {
    String name = "columnName";
    IColumnValue.ColumnType type = IColumnValue.ColumnType.Null;
    Integer jdbcType = java.sql.Types.VARCHAR;
    IColumnValue<Integer> col = new NullColumnValueImpl(name, type, jdbcType);
    IColumnValue.ColumnType retrievedType = col.getType();
    assertTrue("Type not stored as class member", type == retrievedType);
  }

  /**
   * Test method for {@link com.poesys.ms.col.NullColumnValueImpl#getValue()}.
   */
  @Test
  public void testGetValue() {
    String name = "columnName";
    IColumnValue.ColumnType type = IColumnValue.ColumnType.Null;
    Integer jdbcType = java.sql.Types.VARCHAR;
    IColumnValue<Integer> col = new NullColumnValueImpl(name, type, jdbcType);
    Integer retrievedValue = col.getValue();
    // The value is the JDBC type.
    assertTrue("Type not stored as class member",
               jdbcType.equals(retrievedValue));
  }

  /**
   * Test method for {@link com.poesys.ms.col.NullColumnValueImpl#toString()}.
   */
  @Test
  public void testToString() {
    String name = "columnName";
    IColumnValue.ColumnType type = IColumnValue.ColumnType.String;
    Integer jdbcType = java.sql.Types.VARCHAR;
    IColumnValue<Integer> col = new NullColumnValueImpl(name, type, jdbcType);
    assertTrue("toString gives wrong result: " + col.toString(),
               col.toString().equals("[" + name + "=null,JDBC Type=" + jdbcType
                                     + "]"));
  }

}
