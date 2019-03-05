package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img2;
	Texture img3;
	private int kesto;
	ArrayList<String> foods;
	BitmapFont font;
	private OrthographicCamera camera;
	Rectangle firstReel;

	int a,b;
	ArrayList<Texture> images;
	@Override
	public void create () {
		batch = new SpriteBatch();
		int a=3;
		img = new Texture(Gdx.files.internal("banana.png"));
		img2 = new Texture(Gdx.files.internal("apple.png"));
		img3 = new Texture(Gdx.files.internal("tomato.png"));
		images = new ArrayList<Texture>();
		foods = new ArrayList<String>();
		foods.add("Banaani");
		foods.add("Omena");
		foods.add("Tomaatti");
		images.add(img);
		images.add(img2);
		images.add(img3);
		kesto = 0;
		a = random();
		b = random();
		font = new BitmapFont();
		camera = new OrthographicCamera();

		camera.setToOrtho(false, 10f, 5f);
		firstReel = new Rectangle(0,0,img.getWidth()/250f,img.getHeight()/250f);
	}
	public int random(){
		Random rand = new Random();
		int n = rand.nextInt(3);
		return n;
	}

	@Override
	public void render () {
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int n = 0;
		int f = 0;
		if(kesto < 5) {
			batch.begin();
			n = random();
			f = random();

			//batch.draw(images.get(n), 0, 2);

			//batch.draw(images.get(f), 4, 2);
			kesto ++;
			batch.end();
			try {
				Thread.sleep(80);

			} catch (Exception e) {
			}
		} else {
			batch.begin();
			batch.draw(images.get(a), 0, 2);
			batch.draw(images.get(b), 4, 2);
			font.draw(batch,"Arvotut ruoka-ainekset olivat: " + foods.get(a) + " ja "+ foods.get(b),10,20);
			batch.end();

		}
	}


	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
