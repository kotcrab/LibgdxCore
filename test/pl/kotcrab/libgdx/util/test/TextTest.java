/*******************************************************************************
 * Copyright 2014 Pawel Pastuszak
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

package pl.kotcrab.libgdx.util.test;

import pl.kotcrab.libgdx.util.Pointer;
import pl.kotcrab.libgdx.util.Text;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextTest {
	public static void main (String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "TextTester";
		cfg.width = 800;
		cfg.height = 480;

		new LwjglApplication(new TextTestApp(), cfg);
	}
}

class TextTestApp implements ApplicationListener {
	private SpriteBatch batch;
	private OrthographicCamera camera;

	private BitmapFont arial;

	private Text text;
	private Text multilineText;
	private Text wrappedText;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(800, 480);
		camera.position.x = 400;
		camera.position.y = 240;
		camera.update();
		Pointer.setCamera(camera);
		batch.setProjectionMatrix(camera.combined);

		arial = new BitmapFont(Gdx.files.internal("assets/font/arial.fnt"));

		text = new Text(arial);
		multilineText = new Text(arial);
		wrappedText = new Text(arial);

		text.setText("Simple text");
		multilineText.setMultiLineText("text\nthat\ncan\nbe\nin\nmultiple\nlines");
		wrappedText.setWrappedText(
			"this is quite long text that will be automatically wrapped to specified width. it may contain newlines (\\n) \n\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla dictum est at vehicula euismod. "
				+ "Proin varius dui augue, et bibendum libero faucibus in. Vivamus feugiat sollicitudin vehicula.", 200);

		text.setPosition(0, 0);
		multilineText.setPosition(100, 0);
		wrappedText.setPosition(200, 0);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		text.draw(batch);
		multilineText.draw(batch);
		wrappedText.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		arial.dispose();
	}

	// @formatter:off
	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void resize (int width, int height) {
	}
	// @formatter:on

}
