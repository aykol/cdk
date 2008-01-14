/* $Revision: 8973 $ $Author: egonw $ $Date: 2007-09-26 13:47:29 +0200 (Wed, 26 Sep 2007) $
 * 
 * Copyright (C) 2007  Egon Willighagen <egonw@users.sf.net>
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.openscience.cdk.tools.manipulator;

import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.annotations.TestClass;
import org.openscience.cdk.annotations.TestMethod;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IRing;

import java.util.Iterator;

/**
 * @cdk.module standard
 * @cdk.svnrev  $Revision: 9162 $
 */
@TestClass("org.openscience.cdk.test.tools.manipulator.RingManipulatorTest")
public class RingManipulator {

    /**
     * Marks the ring aromatic if all atoms and all bonds are aromatic.
     *
     * The method assumes that aromaticity of atoms and bonds have been
     * detected beforehand
     * 
     * @param ring The ring to examine
     */
    @TestMethod("testMarkAromaticRings")
    public static void markAromaticRings(IRing ring) {
		// return as soon as the conditions are not met:
		// 1. all atoms are labeled aromatic
		Iterator<IAtom> atoms = ring.atoms();
		while (atoms.hasNext()) {
			if (!atoms.next().getFlag(CDKConstants.ISAROMATIC)) return;
		}
		// 2. all bonds are labeled aromatic
		Iterator<IBond> bonds = ring.bonds();
		while (bonds.hasNext()) {
			if (!bonds.next().getFlag(CDKConstants.ISAROMATIC)) return;
		}
		// OK, all conditions are met, so ring is aromatic
		ring.setFlag(CDKConstants.ISAROMATIC, true);
	}

}
