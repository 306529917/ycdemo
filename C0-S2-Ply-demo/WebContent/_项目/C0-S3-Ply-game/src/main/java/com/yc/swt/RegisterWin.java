package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.game.common.util.SwtLabelPaintListner;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class RegisterWin {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Label label_5;
	private Label label_6;
	private Composite composite;
	private Composite composite_1;
	private Button button;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Label lblNewLabel;
	private Button button_4;
	private Composite composite_2;
	private Button btnNewButton_1;
	private Button button_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegisterWin window = new RegisterWin();
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
		shell.setSize(447, 367);
		shell.setText("学生信息窗口");
		GridLayout gl_shell = new GridLayout(3, false);
		gl_shell.marginLeft = 5;
		gl_shell.horizontalSpacing = 10;
		gl_shell.verticalSpacing = 10;
		gl_shell.marginHeight = 20;
		gl_shell.marginWidth = 20;
		shell.setLayout(gl_shell);
		
		Label label = new Label(shell, SWT.NONE);
		GridData gd_label = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 51;
		label.setLayoutData(gd_label);
		label.setText("姓名:");
		
		text = new Text(shell, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 155;
		text.setLayoutData(gd_text);
		
		lblNewLabel = new Label(shell, SWT.BORDER);
		lblNewLabel.setImage(SWTResourceManager.getImage(RegisterWin.class, "/com/yc/swt/imgs/头像.jpg"));
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 4);
		gd_lblNewLabel.heightHint = 107;
		gd_lblNewLabel.widthHint = 87;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("学号:");
		
		text_1 = new Text(shell, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_1.widthHint = 190;
		text_1.setLayoutData(gd_text_1);
		
		label_2 = new Label(shell, SWT.NONE);
		label_2.setText("身份证:");
		
		text_2 = new Text(shell, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_2.widthHint = 167;
		text_2.setLayoutData(gd_text_2);
		
		label_3 = new Label(shell, SWT.NONE);
		label_3.setText("电话:");
		
		text_3 = new Text(shell, SWT.BORDER);
		GridData gd_text_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_3.widthHint = 170;
		text_3.setLayoutData(gd_text_3);
		
		label_4 = new Label(shell, SWT.NONE);
		label_4.setText("邮箱:");
		
		text_4 = new Text(shell, SWT.BORDER);
		GridData gd_text_4 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_4.widthHint = 167;
		text_4.setLayoutData(gd_text_4);
		
		button_4 = new Button(shell, SWT.NONE);
		button_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		button_4.setText("选择照片");
		
		label_5 = new Label(shell, SWT.NONE);
		label_5.setText("爱好:");
		
		composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		button = new Button(composite_1, SWT.CHECK);
		button.setText("篮球");
		
		button_1 = new Button(composite_1, SWT.CHECK);
		button_1.setText("瑜伽");
		
		button_2 = new Button(composite_1, SWT.CHECK);
		button_2.setText("电影");
		
		button_3 = new Button(composite_1, SWT.CHECK);
		button_3.setText("看书");
		
		label_6 = new Label(shell, SWT.NONE);
		label_6.setText("籍贯:");
		
		composite = new Composite(shell, SWT.NONE);
		FillLayout fl_composite = new FillLayout(SWT.HORIZONTAL);
		fl_composite.spacing = 5;
		composite.setLayout(fl_composite);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		
		combo = new Combo(composite, SWT.NONE);
		
		combo_1 = new Combo(composite, SWT.NONE);
		
		combo_2 = new Combo(composite, SWT.NONE);
		
		composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setLayout(new FormLayout());
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_composite_2.heightHint = 71;
		composite_2.setLayoutData(gd_composite_2);
		
		btnNewButton_1 = new Button(composite_2, SWT.NONE);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.top = new FormAttachment(0, 22);
		fd_btnNewButton_1.left = new FormAttachment(100, -189);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("保存");
		
		button_5 = new Button(composite_2, SWT.NONE);
		fd_btnNewButton_1.right = new FormAttachment(button_5, -7);
		button_5.setText("取消");
		FormData fd_button_5 = new FormData();
		fd_button_5.top = new FormAttachment(0, 22);
		fd_button_5.right = new FormAttachment(100, -10);
		fd_button_5.left = new FormAttachment(100, -95);
		button_5.setLayoutData(fd_button_5);

		lblNewLabel.addPaintListener(new SwtLabelPaintListner());
	}

}
