package com.yc.work.pushbox;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;

public class PbSwtWin {

	protected Shell shell;

	private Label[][] cells = new Label[20][20];

	private Image[] imgs = { SWTResourceManager.getImage(PbSwtWin.class, "imgs/0.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/1.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/2.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/3.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/4.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/5.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/6.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/7.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/8.GIF"),
			SWTResourceManager.getImage(PbSwtWin.class, "imgs/9.GIF") };

	private PbGame pg = new PbGame();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PbSwtWin window = new PbSwtWin();
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
		shell.setSize(720, 660);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));

		Composite compMap = new Composite(shell, SWT.NONE);
		compMap.setLayoutData(BorderLayout.CENTER);
		RowLayout rl_compMap = new RowLayout(SWT.HORIZONTAL);
		rl_compMap.justify = true;
		rl_compMap.spacing = 0;
		compMap.setLayout(rl_compMap);

		/**
		 * 添加全局键盘事件
		 */
		shell.getDisplay().addFilter(SWT.KeyDown, new Listener() {
			@Override
			public void handleEvent(Event e) {
				boolean b = false;
				if (e.keyCode == 16777217) {
					b = pg.moveUp();
				} else if (e.keyCode == 16777218) {
					b = pg.moveDown();
				} else if (e.keyCode == 16777219) {
					b = pg.moveLeft();
				} else if (e.keyCode == 16777220) {
					b = pg.moveRight();
				}
				if (b) {
					refresh();
				}
				if (pg.isYouWin()) {
					pg.next();
					refresh();
				}

			}
		});

		// 创建 400 个地图元素对象
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells[y].length; x++) {
				cells[y][x] = new Label(compMap, SWT.NONE);
			}
		}

		Composite compCtrl = new Composite(shell, SWT.NONE);
		compCtrl.setLayoutData(BorderLayout.EAST);
		RowLayout rl_compCtrl = new RowLayout(SWT.VERTICAL);
		rl_compCtrl.spacing = 10;
		rl_compCtrl.marginBottom = 10;
		rl_compCtrl.marginTop = 10;
		rl_compCtrl.marginRight = 10;
		rl_compCtrl.marginLeft = 10;
		compCtrl.setLayout(rl_compCtrl);

		Button btnNewButton = new Button(compCtrl, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pg.restart();
				refresh();
			}
		});
		btnNewButton.setText("重新开始");

		Button btnNewButton_1 = new Button(compCtrl, SWT.NONE);
		btnNewButton_1.setText("保存进度");
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pg.save();
			}
		});

		Button btnNewButton_2 = new Button(compCtrl, SWT.NONE);
		btnNewButton_2.setText("加载进度");
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pg.load();
				refresh();
			}
		});
		// 打开窗口刷新地图
		refresh();

		/**
		 * 禁止切换焦点, 避免键盘反向键操作, 被当成切换焦点指令
		 */
		TraverseListener tl = new TraverseListener() {
			@Override
			public void keyTraversed(TraverseEvent te) {
				te.doit = false;
			}
		};
		btnNewButton.addTraverseListener(tl);
		btnNewButton_1.addTraverseListener(tl);
		btnNewButton_2.addTraverseListener(tl);
	}

	// 刷新地图
	public void refresh() {
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells[y].length; x++) {
				int i = Integer.parseInt("" + pg.getMap()[y][x]);
				cells[y][x].setImage(imgs[i]);
			}
		}
	}
}
