package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class FindWin {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FindWin window = new FindWin();
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
		shell.setSize(450, 300);
		shell.setText("Find/Replace");
		shell.setLayout(new GridLayout(2, false));
		
		Label lblFind = new Label(shell, SWT.NONE);
		lblFind.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1));
		lblFind.setText("Find:");
		
		text = new Text(shell, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 400;
		text.setLayoutData(gd_text);
		
		Label lblReplaceWith = new Label(shell, SWT.NONE);
		lblReplaceWith.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		lblReplaceWith.setText("Replace with:");
		
		text_1 = new Text(shell, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_text_1.widthHint = 400;
		text_1.setLayoutData(gd_text_1);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(null);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 61, 17);
		lblNewLabel.setText("New Label");
		
		Composite composite_2 = new Composite(composite, SWT.NONE);

	}
}
