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


/**
 * Tests the AssociationPrimaryKey messaging DTO class
 * @author Robert J. Muller
 */
public class AssociationPrimaryKeyTest {
  
  private static final String CLASS_NAME = "com.poesys.db.dto.TestNatural";

  @Test
  public void testAssociationPrimaryKey() {
    // Create two sequence keys and build an association key.
    IPrimaryKey key1 = new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    IPrimaryKey key2 = new SequencePrimaryKey("key2", new BigInteger("2"), CLASS_NAME);
    List<IPrimaryKey> list = new ArrayList<IPrimaryKey>(2);
    list.add(key1);
    list.add(key2);
    AssociationPrimaryKey key = new AssociationPrimaryKey(list, CLASS_NAME);
    assertTrue("Could not create assocation key", key != null);
    assertTrue("Association key does not contain two associated keys",
               key.getKeys().size() == 2);
  }

  @Test
  public void testGetKeys() {
    // Create two sequence keys and build an association key.
    IPrimaryKey key1 = new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    IPrimaryKey key2 = new SequencePrimaryKey("key2", new BigInteger("2"), CLASS_NAME);
    List<IPrimaryKey> list = new ArrayList<IPrimaryKey>(2);
    list.add(key1);
    list.add(key2);
    AssociationPrimaryKey key = new AssociationPrimaryKey(list, CLASS_NAME);
    assertTrue("Could not create assocation key", key != null);
    List<IPrimaryKey> retrievedList = key.getKeys();
    assertTrue("Could not get list of associated keys", retrievedList != null);
    assertTrue("Association key does not contain two associated keys",
               key.getKeys().size() == 2);
    assertTrue("First key not the same", key.getKeys().get(0).equals(key1));
    assertTrue("Second key not the same", key.getKeys().get(1).equals(key2));
  }

  /**
   * Test method for {@link com.poesys.ms.pk.AssociationPrimaryKey#toString()}.
   */
  @Test
  public void testToString() {
    // Create two sequence keys and build an association key.
    SequencePrimaryKey key1 =
      new SequencePrimaryKey("key1", new BigInteger("1"), CLASS_NAME);
    SequencePrimaryKey key2 =
      new SequencePrimaryKey("key2", new BigInteger("2"), CLASS_NAME);
    List<IPrimaryKey> list = new ArrayList<IPrimaryKey>(2);
    list.add(key1);
    list.add(key2);
    AssociationPrimaryKey key = new AssociationPrimaryKey(list, CLASS_NAME);
    assertTrue("Could not create assocation key", key != null);
    String test =
      "[Association Key: Key [" + key1.getName() + "=" + key1.getValue()
          + "] Key [" + key2.getName() + "=" + key2.getValue() + "]]";
    assertTrue("Wrong string rep: " + key + ", not " + test, test.equals(key.toString()));
  }

}
