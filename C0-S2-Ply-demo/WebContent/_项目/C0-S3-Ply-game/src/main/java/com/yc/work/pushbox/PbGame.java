package com.yc.work.pushbox;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.yc.util.IOHelper;
import com.yc.work.pushbox.base.PushBoxBase;

/**
 * 推箱子游戏
 */
public class PbGame extends PushBoxBase {

	private static final long serialVersionUID = 1L;

	/**
	 * 向上移动
	 * @return 
	 */
	public boolean moveUp() {
		return move(0, -1);
	}

	/**
	 * 向下移动
	 * @return 
	 */
	public boolean moveDown() {
		return move(0, 1);
	}

	/**
	 * 向左移动
	 * @return 
	 */
	public boolean moveLeft() {
		return move(-1, 0);
	}

	/**
	 * 向右移动
	 * @return 
	 */
	public boolean moveRight() {
		return move(1, 0);
	}

	/**
	 * 下一关
	 */
	public void next() {
		level++;
		loadMap();
	}

	/**
	 * 重新开始
	 */
	public void restart() {
		loadMap();
	}

	@Override
	public void save() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("pushbox.dat"));
			oos.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOHelper.close(oos);
		}
	}

	@Override
	public boolean load() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("pushbox.dat"));
			PbGame pg = (PbGame) ois.readObject();
			this.map = pg.map;
			this.mapEmpty = pg.mapEmpty;
			this.level = pg.level;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			IOHelper.close(ois);
		}
	}

}
