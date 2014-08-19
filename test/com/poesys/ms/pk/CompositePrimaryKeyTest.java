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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.poesys.ms.col.ColumnValueImpl;
import com.poesys.ms.col.IColumnValue;


/**
 * Tests the CompositePrimaryKey messaging DTO class
 * 
 * @author Robert J. Muller
 */
public class CompositePrimaryKeyTest {

  private static final String CLASS_NAME = "com.poesys.db.dto.TestNatural";

  /**
   * Test method for
   * {@link com.poesys.ms.pk.CompositePrimaryKey#CompositePrimaryKey(com.poesys.ms.pk.IPrimaryKey, com.poesys.ms.pk.IPrimaryKey)}
   * .
   */
  @Test
  public void testCompositePrimaryKey() {
    // Create a sequence parent key and a natural subkey with one integer value.
    IPrimaryKey parentKey = new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>(1);
    IColumnValue<Integer> intCol = new ColumnValueImpl<Integer>("subKey", IColumnValue.ColumnType.Integer, 1);
    cols.add(intCol);
    IPrimaryKey subKey = new NaturalPrimaryKey(cols, CLASS_NAME);
    CompositePrimaryKey key = new CompositePrimaryKey(parentKey, subKey, CLASS_NAME);
    assertTrue("Could not create composite key", key != null);
    assertTrue("Composite key does not contain parent and sub-keys",
               key.getParentKey() != null && key.getSubKey() != null);
  }

  /**
   * Test method for {@link com.poesys.ms.pk.CompositePrimaryKey#getParentKey()}
   * .
   */
  @Test
  public void testGetParentKey() {
    // Create a sequence parent key and a natural subkey with one integer value.
    IPrimaryKey parentKey = new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>(1);
    IColumnValue<Integer> intCol = new ColumnValueImpl<Integer>("subKey", IColumnValue.ColumnType.Integer, 1);
    cols.add(intCol);
    IPrimaryKey subKey = new NaturalPrimaryKey(cols, CLASS_NAME);
    CompositePrimaryKey key = new CompositePrimaryKey(parentKey, subKey, CLASS_NAME);
    assertTrue("Could not create composite key", key != null);
    assertTrue("Could not get parent key", key.getParentKey().toString().equals(parentKey.toString()));
  }

  /**
   * Test method for {@link com.poesys.ms.pk.CompositePrimaryKey#getSubKey()}.
   */
  @Test
  public void testGetSubKey() {
    // Create a sequence parent key and a natural subkey with one integer value.
    IPrimaryKey parentKey = new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>(1);
    IColumnValue<Integer> intCol = new ColumnValueImpl<Integer>("subKey", IColumnValue.ColumnType.Integer, 1);
    cols.add(intCol);
    IPrimaryKey subKey = new NaturalPrimaryKey(cols, CLASS_NAME);
    CompositePrimaryKey key = new CompositePrimaryKey(parentKey, subKey, CLASS_NAME);
    assertTrue("Could not create composite key", key != null);
    assertTrue("Could not get sub key", key.getSubKey().toString().equals(subKey.toString()));
  }

  /**
   * Test method for {@link com.poesys.ms.pk.CompositePrimaryKey#toString()}.
   */
  @Test
  public void testToString() {
    // Create a sequence parent key and a natural subkey with one integer value.
    SequencePrimaryKey parentKey = new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    List<IColumnValue<?>> cols = new ArrayList<IColumnValue<?>>(1);
    IColumnValue<Integer> intCol = new ColumnValueImpl<Integer>("subKey", IColumnValue.ColumnType.Integer, 1);
    cols.add(intCol);
    NaturalPrimaryKey subKey = new NaturalPrimaryKey(cols, CLASS_NAME);
    CompositePrimaryKey key = new CompositePrimaryKey(parentKey, subKey, CLASS_NAME);
    assertTrue("Could not create composite key", key != null);
    String test =
      "[Composite Key: Parent key [" + parentKey.getName() + "=" + parentKey.getValue()
          + "] Sub key [subKey=1]]";
    assertTrue("Wrong string rep: " + key + ", not " + test, test.equals(key.toString()));
  }
}
