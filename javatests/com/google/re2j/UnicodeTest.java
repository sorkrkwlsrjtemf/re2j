/*
 * Copyright (c) 2020 The Go Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
package com.google.re2j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UnicodeTest {

  @Test
  public void testFoldConstants() {
    int last = -1;
    for (int i = 0; i <= Unicode.MAX_RUNE; i++) {
      if (Unicode.simpleFold(i) == i) {
        continue;
      }
      if (last == -1 && Unicode.MIN_FOLD != i) {
        fail(String.format("MIN_FOLD=#%04X should be #%04X", Unicode.MIN_FOLD, i));
      }
      last = i;
    }
    if (Unicode.MAX_FOLD != last) {
      fail(String.format("MAX_FOLD=#%04X should be #%04X", Unicode.MAX_FOLD, last));
    }
  }

  @Test
  public void uppertest() {
    assertEquals(true, Unicode.isUpper('A'));
  }

  @Test
  public void printtest() {
    assertEquals(true, Unicode.isPrint(' '));
    assertEquals(true, Unicode.isPrint(0x20));
  }

  @Test
  public void simplefold() {
    assertEquals('A', Unicode.simpleFold('a'));
    assertEquals('a', Unicode.simpleFold('A'));
    assertEquals('1', Unicode.simpleFold('1'));
  }



  // boolean isLower(int r);
  // boolean isTitle(int r);
  // int to(int _case, int r, int[][] caseRange);
  // int toUpper(int r);
  // int toLower(int r);


}
