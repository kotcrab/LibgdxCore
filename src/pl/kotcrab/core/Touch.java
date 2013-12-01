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

package pl.kotcrab.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

/**
 * Class for caluclating propper touch cordinates
 * @author Pawel Pastuszak
 */
public class Touch
{
	private static OrthographicCamera camera; // kamera
	private static Vector3 calcVector; // wektor do obliczen
	
	/** Przygotowywuje klase do uzytku */
	public static void setCamera(OrthographicCamera camera)
	{
		Touch.camera = camera;
		calcVector = new Vector3(0, 0, 0);
	}
	
	/** Zwaraca kamere */
	public static OrthographicCamera getCamera()
	{
		return camera;
	}
	
	/**
	 * Zwaraca poprawne miejsce dotyku pobrane przy ucyzciu Gdx.input.getX() Aby uzywac nalezy wyowalc jednorazowo setCamera()
	 * 
	 * @param x
	 *            pochadzace z Gdx.input.getX()
	 */
	public static float calcX(float x)
	{
		calcVector.x = x;
		camera.unproject(calcVector);
		return calcVector.x;
	}
	
	/**
	 * Zwaraca poprawne miejsce dotyku pobrane przy ucyzciu Gdx.input.getY() Aby uzywac nalezy wyowalc jednorazowo setCamera()
	 * 
	 * @param y
	 *            pochadzace z Gdx.input.getY()
	 */	
	public static float calcY(float y)
	{
		calcVector.y = y;
		camera.unproject(calcVector);
		return calcVector.y;
	}
	
}