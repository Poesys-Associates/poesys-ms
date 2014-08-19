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


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.poesys.ms.col.ColumnValueImpl;
import com.poesys.ms.col.IColumnValue;


/**
 * Tests the NaturalPrimaryKey messaging DTO class
 * 
 * @author Robert J. Muller
 */
public class NaturalPrimaryKeyTest {

  private static final String CLASS_NAME = "com.poesys.db.dto.TestNatural";

  /**
   * Test method for
   * {@link com.poesys.ms.pk.NaturalPrimaryKey#NaturalPrimaryKey(java.util.List)}
   * Test method for
   * {@link com.poesys.ms.pk.NaturalPrimaryKey#getColumnValues()}.
   * Single-valued case .
   */
  @Test
  public void testNaturalPrimaryKey1() {
    // Create a single-valued natural key.
    String name1 = "first Column";
    String value = "first column value";
    List<IColumnValue<?>> singleList = new ArrayList<IColumnValue<?>>(1);
    IColumnValue<String> stringValue =
      new ColumnValueImpl<String>(name1, IColumnValue.ColumnType.String, value);
    singleList.add(stringValue);
    NaturalPrimaryKey key = new NaturalPrimaryKey(singleList, CLASS_NAME);
    assertTrue("No key created", key != null);
    List<IColumnValue<?>> retrievedSingleList = key.getColumnValues();
    assertTrue("No list retrieved", retrievedSingleList != null);
    assertTrue("List is not one column", retrievedSingleList.size() == 1);
    IColumnValue<?> retrievedCol = retrievedSingleList.get(0);
    assertTrue("No column retrieved", retrievedCol != null);
    assertTrue("Column name wrong", retrievedCol.getName().equals(name1));
    assertTrue("Column type wrong",
               retrievedCol.getType() == IColumnValue.ColumnType.String);
    assertTrue("Column value wrong", retrievedCol.getValue().equals(value));
  }

  /**
   * Test method for
   * {@link com.poesys.ms.pk.NaturalPrimaryKey#NaturalPrimaryKey(java.util.List)}
   * Test method for
   * {@link com.poesys.ms.pk.NaturalPrimaryKey#getColumnValues()}.
   * Multiple-valued case .
   */
  @Test
  public void testNaturalPrimaryKey2() {
    // Create a multiple-valued natural key.
    List<IColumnValue<?>> multiList = new ArrayList<IColumnValue<?>>(2);
    String name1 = "first Column";
    String value1 = "first column value";
    IColumnValue<String> stringValue1 =
      new ColumnValueImpl<String>(name1, IColumnValue.ColumnType.String, value1);
    String name2 = "second Column";
    Integer value2 = 20;
    IColumnValue<Integer> integerValue2 =
      new ColumnValueImpl<Integer>(name2,
                                   IColumnValue.ColumnType.Integer,
                                   value2);
    multiList.add(stringValue1);
    multiList.add(integerValue2);
    NaturalPrimaryKey key = new NaturalPrimaryKey(multiList, CLASS_NAME);
    assertTrue("No key created", key != null);
    List<IColumnValue<?>> retrievedMultiList = key.getColumnValues();
    assertTrue("No list retrieved", retrievedMultiList != null);
    assertTrue("List is not two columns", retrievedMultiList.size() == 2);
    IColumnValue<?> retrievedCol1 = retrievedMultiList.get(0);
    IColumnValue<?> retrievedCol2 = retrievedMultiList.get(1);
    assertTrue("No string column retrieved", retrievedCol1 != null);
    assertTrue("No integer column retrieved", retrievedCol2 != null);
    assertTrue("Column 1 name wrong", retrievedCol1.getName().equals(name1));
    assertTrue("Column 1 type wrong",
               retrievedCol1.getType() == IColumnValue.ColumnType.String);
    assertTrue("Column 1 value wrong", retrievedCol2.getValue().equals(value2));
    assertTrue("Column 2 name wrong", retrievedCol2.getName().equals(name2));
    assertTrue("Column 2 type wrong",
               retrievedCol2.getType() == IColumnValue.ColumnType.Integer);
    assertTrue("Column 2 value wrong", retrievedCol2.getValue().equals(value2));
  }

  /**
   * Test method for {@link com.poesys.ms.pk.NaturalPrimaryKey#toString()}.
   */
  @Test
  public void testToString() {
    // Create a multiple-valued natural key.
    List<IColumnValue<?>> multiList = new ArrayList<IColumnValue<?>>(2);
    String name1 = "first Column";
    String value1 = "first column value";
    IColumnValue<String> stringValue1 =
      new ColumnValueImpl<String>(name1, IColumnValue.ColumnType.String, value1);
    String name2 = "second Column";
    Integer value2 = 20;
    IColumnValue<Integer> integerValue2 =
      new ColumnValueImpl<Integer>(name2,
                                   IColumnValue.ColumnType.Integer,
                                   value2);
    multiList.add(stringValue1);
    multiList.add(integerValue2);
    NaturalPrimaryKey key = new NaturalPrimaryKey(multiList, CLASS_NAME);
    assertTrue("No key created", key != null);
    String stringRep = key.toString();
    String test = "[" + name1 + "=" + value1 + ", " + name2 + "=" + value2 + "]";
    assertTrue("String representation failed: " + stringRep, stringRep.equals(test));
  }
}
