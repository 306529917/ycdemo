package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.RowLayout;

public class CleanWin {

	protected Shell shell;
	private Text txtDesc;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CleanWin window = new CleanWin();
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
		shell.setSize(453, 369);
		shell.setText("Clean");
		shell.setLayout(new FormLayout());

		txtDesc = new Text(shell, SWT.WRAP);
		txtDesc.setText("Clean discards all build results and state. The selected projects will be rebuild from scratch.");
		txtDesc.setEditable(false);
		FormData fd_txtDesc = new FormData();
		fd_txtDesc.top = new FormAttachment(0, 10);
		fd_txtDesc.left = new FormAttachment(0, 10);
		fd_txtDesc.right = new FormAttachment(100, -10);
		txtDesc.setLayoutData(fd_txtDesc);

		Button button = new Button(shell, SWT.CHECK);
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(txtDesc, 6);
		fd_button.left = new FormAttachment(txtDesc, 0, SWT.LEFT);
		button.setLayoutData(fd_button);
		button.setText("Clean all projects");

		text = new Text(shell, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(txtDesc, 0, SWT.RIGHT);
		fd_text.top = new FormAttachment(button, 6);
		fd_text.left = new FormAttachment(0, 10);
		text.setLayoutData(fd_text);

		Button btnCancel = new Button(shell, SWT.NONE);
		FormData fd_btnCancel = new FormData();
		fd_btnCancel.left = new FormAttachment(100, -98);
		fd_btnCancel.bottom = new FormAttachment(100, -10);
		fd_btnCancel.right = new FormAttachment(100, -10);
		btnCancel.setLayoutData(fd_btnCancel);
		btnCancel.setText("Cancel");

		Button btnClean = new Button(shell, SWT.NONE);
		btnClean.setText("Clean");
		FormData fd_btnClean = new FormData();
		fd_btnClean.top = new FormAttachment(btnCancel, 0, SWT.TOP);
		fd_btnClean.left = new FormAttachment(btnCancel, -94, SWT.LEFT);
		fd_btnClean.right = new FormAttachment(btnCancel, -6);
		btnClean.setLayoutData(fd_btnClean);

		Composite composite = new Composite(shell, SWT.BORDER | SWT.V_SCROLL);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		RowLayout rl_composite = new RowLayout(SWT.VERTICAL);
		rl_composite.wrap = false;
		composite.setLayout(rl_composite);
		FormData fd_composite = new FormData();
		fd_composite.left = new FormAttachment(txtDesc, 0, SWT.LEFT);
		fd_composite.top = new FormAttachment(text, 6);
		fd_composite.bottom = new FormAttachment(btnCancel, -6);
		fd_composite.right = new FormAttachment(txtDesc, 0, SWT.RIGHT);
		composite.setLayoutData(fd_composite);
		
		newChkBtn(composite,"C0-S2-Ply-demo",SWT.CHECK);
		newChkBtn(composite,"C0-S2-Ply-exercise",SWT.CHECK);
		newChkBtn(composite,"C76-S3-Ply-blog",SWT.CHECK);
		newChkBtn(composite,"C76-S3-Ply-ebuy-back",SWT.CHECK);
		newChkBtn(composite,"C85-S1-Ply-java",SWT.CHECK);
		newChkBtn(composite,"teach-java",SWT.CHECK);
		newChkBtn(composite,"Servers2",SWT.CHECK);
		newChkBtn(composite,"helper",SWT.CHECK);
		newChkBtn(composite,"C0-S2-Ply-demo",SWT.CHECK);
		newChkBtn(composite,"C0-S2-Ply-exercise",SWT.CHECK);
		newChkBtn(composite,"C76-S3-Ply-blog",SWT.CHECK);
		newChkBtn(composite,"C76-S3-Ply-ebuy-back",SWT.CHECK);
		newChkBtn(composite,"C85-S1-Ply-java",SWT.CHECK);
		newChkBtn(composite,"teach-java",SWT.CHECK);
		newChkBtn(composite,"Servers2",SWT.CHECK);
		newChkBtn(composite,"helper",SWT.CHECK);
		

	}

	public Button newChkBtn(Composite parent, String text, int style) {
		Button btn = new Button(parent, style);
		btn.setText(text);
		btn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		return btn;
	}
}
