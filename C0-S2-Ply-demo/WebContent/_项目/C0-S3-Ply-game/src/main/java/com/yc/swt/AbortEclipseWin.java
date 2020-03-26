package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class AbortEclipseWin {

	private static List<Image> imgList = new ArrayList<>();

	static {
		Image img = null;
		for (int i = 1; i <= 18; i++) {
			img = SWTResourceManager.getImage(AbortEclipseWin.class, "/com/yc/swt/imgs/eclipse/" + i + ".png");
			imgList.add(img);
		}
	}

	protected Shell shlAbortEclipseIde;
	private Text text;
	private Composite composite_1;
	private Button btnNewButton;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AbortEclipseWin window = new AbortEclipseWin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws IOException 
	 */
	public void open() throws IOException {
		Display display = Display.getDefault();
		createContents();
		shlAbortEclipseIde.open();
		shlAbortEclipseIde.layout();
		while (!shlAbortEclipseIde.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws IOException 
	 */
	protected void createContents() throws IOException {
		shlAbortEclipseIde = new Shell();
		shlAbortEclipseIde.setSize(881, 346);
		shlAbortEclipseIde.setText("Abort Eclipse IDE");
		GridLayout gl_shlAbortEclipseIde = new GridLayout(2, false);
		gl_shlAbortEclipseIde.horizontalSpacing = 0;
		shlAbortEclipseIde.setLayout(gl_shlAbortEclipseIde);

		Label label = new Label(shlAbortEclipseIde, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setImage(SWTResourceManager.getImage(AbortEclipseWin.class, "/com/yc/swt/imgs/eclipse/left.png"));

		text = new Text(shlAbortEclipseIde, SWT.WRAP | SWT.V_SCROLL);
		GridData gd_text = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_text.heightHint = 23;
		text.setLayoutData(gd_text);

		Composite composite = new Composite(shlAbortEclipseIde, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

		composite_1 = new Composite(shlAbortEclipseIde, SWT.NONE);
		composite_1.setLayout(new FormLayout());
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_composite_1.heightHint = 72;
		composite_1.setLayoutData(gd_composite_1);
		btnNewButton = new Button(composite_1, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(100, -10);
		fd_btnNewButton.left = new FormAttachment(0, 56);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Information Details");

		Label label_1 = new Label(composite_1, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage(AbortEclipseWin.class, "/com/yc/swt/imgs/eclipse/help.png"));
		FormData fd_label_1 = new FormData();
		fd_label_1.bottom = new FormAttachment(100, -9);
		fd_label_1.right = new FormAttachment(btnNewButton, -12);
		label_1.setLayoutData(fd_label_1);

		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.bottom = new FormAttachment(100, -10);
		fd_btnNewButton_1.right = new FormAttachment(100, -10);
		fd_btnNewButton_1.left = new FormAttachment(100, -100);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Close");

		// 添加图标
		for (Image img : imgList) {
			Label imgLabel = new Label(composite, SWT.NONE);
			imgLabel.setImage(img);
		}

		// 读入版权信息, 读取指定类路径下的文件
		InputStream is = getClass().getResourceAsStream("imgs/eclipse/版权信息.txt");
		// 字节流转字符流
		InputStreamReader isr = new InputStreamReader(is);
		// 缓冲字符流可以按行读取
		BufferedReader br = new BufferedReader(isr);
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				// 将读入的文字追加到文本框中, \r\n 是换行符
				text.setText(text.getText() + line + "\r\n");
			}
		} finally {
			// 只要关闭资源流就可以了
			is.close();
		}

	}
}
