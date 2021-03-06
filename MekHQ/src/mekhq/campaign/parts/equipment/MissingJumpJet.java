/*
 * MissingJumpJet.java
 * 
 * Copyright (c) 2009 Jay Lawson <jaylawson39 at yahoo.com>. All rights reserved.
 * 
 * This file is part of MekHQ.
 * 
 * MekHQ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MekHQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MekHQ.  If not, see <http://www.gnu.org/licenses/>.
 */

package mekhq.campaign.parts.equipment;

import megamek.common.EquipmentType;
import megamek.common.MiscType;
import mekhq.campaign.Campaign;
import mekhq.campaign.parts.Part;

/**
 *
 * @author Jay Lawson <jaylawson39 at yahoo.com>
 */
public class MissingJumpJet extends MissingEquipmentPart {
	private static final long serialVersionUID = 2892728320891712304L;

	public MissingJumpJet() {
    	this(0, null, -1, null);
    }
    
    public MissingJumpJet(int tonnage, EquipmentType et, int equipNum, Campaign c) {
        super(tonnage, et, equipNum, c, 1);
    }
    
    @Override 
	public int getBaseTime() {
		return 60;
	}
	
	@Override
	public int getDifficulty() {
		return 0;
	}
    
    @Override
	public Part getNewPart() {
		return new JumpJet(getUnitTonnage(), type, -1, campaign);
	}
    
    @Override
    public double getTonnage() {
    	double ton = 0.5;
    	if(getUnitTonnage() >= 90) {
    		ton = 2.0;
    	} else if(getUnitTonnage() >= 60) {
    		ton = 1.0;
    	}
    	if(type.hasSubType(MiscType.S_IMPROVED)) {
    		ton *= 2;
    	}
    	return ton;
    }
}
