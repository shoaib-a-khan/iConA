/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icona.gui;

import java.io.File;

/**
 *
 * @author line47
 */
  class TreeFile extends File {
    public TreeFile(File parent, String child) {
      super(parent, child);
    }

    public String toString() {
      return getName();
    }
  }
