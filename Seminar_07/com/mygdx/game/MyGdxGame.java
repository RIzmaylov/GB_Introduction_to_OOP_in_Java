package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.CharacterPackage.BaseCharacter;
import com.mygdx.game.Engine.Engine;
//import com.mygdx.game.MVP.Main;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan;
	Music music;

	public ArrayList<BaseCharacter> LeftTeam;
	public ArrayList<BaseCharacter> RightTeam;
	public ArrayList<BaseCharacter> AllUnits;
	public ArrayList<BaseCharacter> SortedUnits;
	Engine engine;
	
	@Override
	public void create () {
		LeftTeam = new ArrayList<>();
		RightTeam = new ArrayList<>();
		AllUnits = new ArrayList<>();
		SortedUnits = new ArrayList<>();
		engine = new Engine();

		// Создание случайных команд:
		LeftTeam = engine.createTeam(BaseCharacter.Team.LEFT, 10);
		RightTeam = engine.createTeam(BaseCharacter.Team.RIGHT, 10);

		// Создание определенных команд:
//		 LeftTeam = engine.createBalancedTeam(BaseCharacter.Team.LEFT, 10);
//		 RightTeam = engine.createBalancedTeam(BaseCharacter.Team.RIGHT, 10);
//
		AllUnits.addAll(LeftTeam);
		AllUnits.addAll(RightTeam);
		SortedUnits.addAll(AllUnits);
		AllUnits.sort((o1, o2) -> o2.GetPosition().getX() - o1.GetPosition().getX());
		SortedUnits.sort((o1, o2) -> o2.GetInitiative() - o1.GetInitiative());

		batch = new SpriteBatch();

		fon = new Texture("fon/CmBk" + MathUtils.random(0, 4) + ".png");

		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0" + MathUtils.random(1, 4) + ".mp3"));
		music.setVolume(.5f);
		music.play();

		this.sniper = new Texture("units/Sniper.png");
		this.crossBowMan = new Texture("units/CrossBowMan.png");
		this.mage = new Texture("units/Mage.png");
		this.monk = new Texture("units/Monk.png");
		this.peasant = new Texture("units/Peasant.png");
		this.rouge = new Texture("units/Rouge.png");
		this.spearMan = new Texture("units/SpearMan.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		for (BaseCharacter unit : AllUnits) {
			if (!unit.isAlive()) continue;
			int y = unit.GetPosition().getX() * Gdx.graphics.getWidth() / 16;
			int x = unit.GetPosition().getY() * Gdx.graphics.getHeight() / 12 + 50;
			int k = -1;
			if (unit.GetTeamSide().equals("left")) k = 1;
			switch (unit.getInfo()) {
				case "Арбалетчик":
					batch.draw(crossBowMan, x, y, crossBowMan.getWidth() * k, crossBowMan.getHeight());
					break;
				case "Монах":
					batch.draw(monk,  x, y, monk.getWidth() * k, monk.getHeight());
					break;
				case "Фермер":
					batch.draw(peasant,  x, y, peasant.getWidth() * k, peasant.getHeight());
					break;
				case "Разбойник":
					batch.draw(rouge,  x, y, rouge.getWidth() * k, rouge.getHeight());
					break;
				case "Снайпер":
					batch.draw(sniper,  x, y, sniper.getWidth() * k, sniper.getHeight());
					break;
				case "Копейщик":
					batch.draw(spearMan,  x, y, spearMan.getWidth() * k, spearMan.getHeight());
					break;
				case "Волшебник":
					batch.draw(mage,  x, y, mage.getWidth() * k, mage.getHeight());
					break;
			}
		}

		batch.end();

		boolean flag = true;
		for (BaseCharacter unit : LeftTeam) {
			if (unit.isAlive()) flag = false;
		}

		if (flag) {
			Gdx.graphics.setTitle("Правая команда победила!");
			return;
		}
		flag = true;
		for (BaseCharacter unit : RightTeam) {
			if (unit.isAlive()) flag = false;
		}

		if (flag) {
			Gdx.graphics.setTitle("Левая команда победила!");
			return;
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.justTouched()){
			for (BaseCharacter baseCharacter : SortedUnits) {
				baseCharacter.step(SortedUnits);
			}
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		sniper.dispose();
		crossBowMan.dispose();
		mage.dispose();
		monk.dispose();
		peasant.dispose();
		rouge.dispose();
		spearMan.dispose();
		music.dispose();
	}
}
