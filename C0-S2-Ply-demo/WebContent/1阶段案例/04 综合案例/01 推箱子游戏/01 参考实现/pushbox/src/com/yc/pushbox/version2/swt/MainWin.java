package com.yc.pushbox.version2.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.pushbox.version2.core.Game;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyListener;
import java.util.function.Consumer;
import org.eclipse.swt.events.KeyEvent;

public class MainWin {

	protected Shell shell;
	private static final Image[] IMGS = new Image[10];
	static {
		for (int i = 0; i < IMGS.length; i++) {
			IMGS[i] = SWTResourceManager.getImage(MainWin.class, "/imgs/" + i + ".gif");
		}
	}

	private int[][] map = Game.next();
	private Label[][] labelMap = new Label[map.length][map[0].length];


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWin window = new MainWin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.ARROW_UP) {
					Game.up();
				} else if(e.keyCode == SWT.ARROW_DOWN) {
					Game.down();
				} else if(e.keyCode == SWT.ARROW_LEFT) {
					Game.left();
				} else if(e.keyCode == SWT.ARROW_RIGHT) {
					Game.right();
				}
				refresh();
				if(Game.isOver()) {
					MessageBox mb = new MessageBox(shell);
					mb.setText("系统提示");
					mb.setMessage("你赢了！");
					mb.open();
					map = Game.next();
					refresh();
				}
			}
		});
		shell.setText("推箱子");
		shell.setLayout(new GridLayout(map.length, false));
		shell.setSize(370, 400);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labelMap[i][j] = createLabel(j,i);
			}
		}
	}
	
	private Label createLabel(int x, int y) {
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(IMGS[map[y][x]]);
		lblNewLabel.setSize(30, 30);
		return lblNewLabel;
	}
	
	private void refresh() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labelMap[i][j].setImage(IMGS[map[i][j]]);
			}
		}
	}

}
