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

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.poesys.ms.col.IColumnValue;


/**
 * Tests the GuidPrimaryKey messaging DTO
 * 
 * @author Robert J. Muller
 */
public class GuidPrimaryKeyTest {
  private UUID value = UUID.randomUUID();

  private static final String CLASS_NAME = "com.poesys.db.dto.TestNatural";

  /**
   * Test method for {@link com.poesys.ms.pk.GuidPrimaryKey#getName()}.
   */
  @Test
  public void testGetName() {
    String name = "guidColumn";
    GuidPrimaryKey key = new GuidPrimaryKey(name, value, CLASS_NAME);
    assertTrue("name not stored as class member", name.equals(key.getName()));
  }

  /**
   * Test method for {@link com.poesys.ms.pk.GuidPrimaryKey#getUuid()}.
   */
  @Test
  public void testGetValue() {
    String name = "guidColumn";
    GuidPrimaryKey key = new GuidPrimaryKey(name, value, CLASS_NAME);
    assertTrue("uuid not stored as class member", value.equals(key.getUuid()));
  }

  /**
   * Test method for
   * {@link com.poesys.ms.pk.GuidPrimaryKey#getColumnValues()}.
   */
  @Test
  public void testGetColumnValues() {
    String name = "guidColumn";
    GuidPrimaryKey key = new GuidPrimaryKey(name, value, CLASS_NAME);
    List<IColumnValue<?>> list = key.getColumnValues();
    assertTrue("Couldn't generate single-item list of columns",
               list.size() == 1);
    IColumnValue<?> col = list.get(0);
    assertTrue("Couldn't generate column value list", col != null);
    assertTrue("Column doesn't have correct name", name.equals(col.getName()));
    assertTrue("Column doesn't have correct uuid",
               value.equals(col.getValue()));
  }

  /**
   * Test method for {@link com.poesys.ms.pk.GuidPrimaryKey#toString()}.
   */
  @Test
  public void testToString() {
    String name = "guidColumn";
    GuidPrimaryKey key = new GuidPrimaryKey(name, value, CLASS_NAME);
    assertTrue("toString generates wrong value: " + key.toString(),
               key.toString().equals("[" + name + "=" + value.toString() + "]"));
  }
}
