/*******************************************************************************
 * Copyright 2013 Pawel Pastuszak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package pl.kotcrab.core.accessor;

import pl.kotcrab.core.KotcrabText;
import aurelienribon.tweenengine.TweenAccessor;

public class AccessorKotcrabText implements TweenAccessor<KotcrabText>
{
	public static final int POSITION_XY = 1;
	public static final int ALPHA = 2;
	public static final int ROTATION = 3;
	public static final int SCALE_XY = 4;
	
	// TweenAccessor implementation
	
	@Override
	public int getValues(KotcrabText target, int tweenType, float[] returnValues)
	{
		switch (tweenType)
		{
		case POSITION_XY:
			returnValues[0] = target.getPosition().x;
			returnValues[1] = target.getPosition().y;
			return 2;
		case ALPHA:
			returnValues[0] = target.getColor().a;
			return 1;
		case ROTATION:
			returnValues[0] = target.getRotation();
			return 1;
		case SCALE_XY:
			returnValues[0] = target.getScale().x;
			returnValues[1] = target.getScale().y;
			return 2;
		default:
			assert false;
			return -1;
		}
	}
	
	@Override
	public void setValues(KotcrabText target, int tweenType, float[] newValues)
	{
		switch (tweenType)
		{
		case POSITION_XY:
			target.setPosition(newValues[0], newValues[1]);
			break;
		case ALPHA:
			target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0]);
		case ROTATION:
			target.setRotation(newValues[0]);
		case SCALE_XY:
			target.setScale(newValues[0], newValues[1]);
		default:
			assert false;
			break;
		}
	}
}