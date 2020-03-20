package com.yc.game.clean.core;

import java.util.ArrayList;

import com.yc.game.clean.base.CleanGame;

public class CleanGameImpl implements CleanGame {

	private int[][] board;
	private int imgCount;
	private BoardChangeListner bcl;

	public CleanGameImpl(int width, int height, int imgCount) {
		board = new int[height][width];
		this.imgCount = imgCount;
		begin();
	}

	@Override
	public boolean swap(int x1, int y1, int x2, int y2) {
		int tmp = board[y1][x1];
		board[y1][x1] = board[y2][x2];
		board[y2][x2] = tmp;
		if (clean() == false) {
			tmp = board[y1][x1];
			board[y1][x1] = board[y2][x2];
			board[y2][x2] = tmp;
			return false;
		}
		return true;
	}

	protected boolean clean() {
		boolean ret = false;
		/*while (true) {
			System.out.println("==================");*/
			ArrayList<Integer[]> clearImgList = check();
			if (clearImgList.size() == 0) {
				// break;
			} else {
				ret = true;
			}
			for (Integer[] xy : clearImgList) {
				board[xy[1]][xy[0]] = 0;
			}
		//}
		return ret;
	}

	public boolean down() {
		boolean ret = false;
		for (int x = 0; x < board[0].length; x++) {
			for (int y = board.length - 1; y >= 0; y--) {
				if (board[y][x] == 0) {
					down(x, y);
					ret = true;
				}
			}
		}
		/*if (bcl != null) {
			bcl.onchange();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		return ret;
	}

	protected ArrayList<Integer[]> check() {
		ArrayList<Integer[]> clearImgList = new ArrayList<Integer[]>();
		ArrayList<Integer[]> imgList = new ArrayList<>();
		for (int y = 0; y < board.length; y++) {
			int img = 0;
			imgList.clear();
			for (int x = 0; x < board[y].length; x++) {
				if (board[y][x] != img) {
					img = board[y][x];
					if (imgList.size() > 2) {
						clearImgList.addAll(imgList);
					}
					imgList.clear();
				}
				imgList.add(new Integer[] { x, y });
			}
			if (imgList.size() > 2) {
				clearImgList.addAll(imgList);
			}
		}
		for (int x = 0; x < board[0].length; x++) {
			int img = 0;
			imgList.clear();
			for (int y = 0; y < board.length; y++) {
				if (board[y][x] != img) {
					img = board[y][x];
					if (imgList.size() > 2) {
						clearImgList.addAll(imgList);
					}
					imgList.clear();
				}
				imgList.add(new Integer[] { x, y });
			}
			if (imgList.size() > 2) {
				clearImgList.addAll(imgList);
			}
		}
		return clearImgList;
	}

	/*	protected int[] find(int x, int y) {
			for (int ny = y - 1; ny >= 0; ny--) {
				if (board[ny][x] != 0) {
					return new int[] { ny, x };
				}
			}
			board[0][x] = (int) (Math.random() * (imgCount - 1) + 1);
			return new int[] { 0, x };
		}*/

	protected void down(int x, int y) {
		if (y == 0) {
			board[y][x] = (int) (Math.random() * (imgCount - 1) + 1);
		} else {
			int ny = y - 1;
			if (board[ny][x] == 0) {
				down(x, ny);
			} else {
				int tmp = board[y][x];
				board[y][x] = board[ny][x];
				board[ny][x] = tmp;
			}
		}
	}

	@Override
	public int[][] getBoard() {
		return board;
	}

	@Override
	public void begin() {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = (int) (Math.random() * (imgCount - 1) + 1);
			}
		}
		clean();
	}

	@Override
	public Object getWinner() {
		return null;
	}

	@Override
	public boolean isOver() {
		return false;
	}

	public void setBcl(BoardChangeListner bcl) {
		this.bcl = bcl;
	}

	public static interface BoardChangeListner {
		void onchange();
	}

}
