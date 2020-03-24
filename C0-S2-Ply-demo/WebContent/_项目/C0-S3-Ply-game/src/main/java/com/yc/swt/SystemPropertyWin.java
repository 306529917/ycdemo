package com.yc.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowData;
import swing2swt.layout.FlowLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class SystemPropertyWin {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SystemPropertyWin window = new SystemPropertyWin();
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
		shell.setSize(447, 496);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));

		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setLayoutData(BorderLayout.CENTER);

		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("计算机名");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(composite);

		Label label = new Label(composite, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(SystemPropertyWin.class, "/com/yc/swt/imgs/计算机.png"));
		label.setBounds(10, 10, 47, 42);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(78, 22, 304, 17);
		lblNewLabel.setText("Windows 使用以下信息在网络中标识这台计算机");
		
		Label lbld = new Label(composite, SWT.NONE);
		lbld.setBounds(20, 62, 85, 17);
		lbld.setText("计算机描述(D):");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(122, 59, 279, 23);
		
		Label lbld_1 = new Label(composite, SWT.NONE);
		lbld_1.setText("例如:\"书房的计算机\"");
		lbld_1.setBounds(122, 94, 234, 17);
		
		Label lbld_2 = new Label(composite, SWT.NONE);
		lbld_2.setText("计算机全名:");
		lbld_2.setBounds(20, 129, 85, 17);
		
		Label lbld_2_1 = new Label(composite, SWT.NONE);
		lbld_2_1.setText("工作组:");
		lbld_2_1.setBounds(20, 162, 85, 17);
		
		Label lbld_2_2 = new Label(composite, SWT.NONE);
		lbld_2_2.setText("Home");
		lbld_2_2.setBounds(122, 129, 85, 17);
		
		Label lbld_2_2_1 = new Label(composite, SWT.NONE);
		lbld_2_2_1.setText("WorkGroup");
		lbld_2_2_1.setBounds(122, 162, 85, 17);
		
		Label lbld_2_3 = new Label(composite, SWT.WRAP);
		lbld_2_3.setText("若要使用向导将计算机加入域或工作组, 请单击\"网络 ID\"");
		lbld_2_3.setBounds(20, 213, 268, 42);
		
		Button btnId = new Button(composite, SWT.NONE);
		btnId.setText("网络 ID(N)...");
		btnId.setBounds(321, 213, 80, 27);
		
		Label lbld_2_3_1 = new Label(composite, SWT.WRAP);
		lbld_2_3_1.setText("若要使用向导将计算机加入域或工作组, 请单击\"网络 ID\"");
		lbld_2_3_1.setBounds(20, 273, 268, 42);
		
		Button btnc = new Button(composite, SWT.NONE);
		btnc.setText("更改(C)...");
		btnc.setBounds(321, 273, 80, 27);

		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("硬件");

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(composite_1);

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("高级");

		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setLayoutData(BorderLayout.SOUTH);
		RowLayout rl_composite_2 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2.marginLeft = 120;
		rl_composite_2.spacing = 20;
		rl_composite_2.marginHeight = 10;
		rl_composite_2.marginWidth = 10;
		composite_2.setLayout(rl_composite_2);
		
		Button btnNewButton = new Button(composite_2, SWT.NONE);
		btnNewButton.setLayoutData(new RowData(80, SWT.DEFAULT));
		btnNewButton.setText("确   定");
		
		Button btnNewButton_1 = new Button(composite_2, SWT.NONE);
		btnNewButton_1.setLayoutData(new RowData(80, SWT.DEFAULT));
		btnNewButton_1.setText("取  消");
		
		Button btnNewButton_2 = new Button(composite_2, SWT.NONE);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setLayoutData(new RowData(80, SWT.DEFAULT));
		btnNewButton_2.setText("应  用");


	}
}
