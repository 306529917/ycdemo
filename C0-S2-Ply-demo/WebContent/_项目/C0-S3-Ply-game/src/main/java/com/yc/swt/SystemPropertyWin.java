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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
		shell.setSize(447, 620);
		shell.setText("系统属性");
		shell.setLayout(new BorderLayout(0, 0));

		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setLayoutData(BorderLayout.NORTH);
		
		TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("计算机名");
		
				Composite composite = new Composite(tabFolder, SWT.NONE);
				tabItem_1.setControl(composite);
				
						Label label = new Label(composite, SWT.NONE);
						label.setImage(SWTResourceManager.getImage(SystemPropertyWin.class, "/com/yc/swt/imgs/计算机.png"));
						label.setBounds(20, 10, 47, 42);
						
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
						lbld_2_3_1.setText("要重命名这台计算机, 或者更改其他域或工作组, 请单击\"更改\"");
						lbld_2_3_1.setBounds(20, 273, 268, 42);
						
						Button btnc = new Button(composite, SWT.NONE);
						btnc.setText("更改(C)...");
						btnc.setBounds(321, 273, 80, 27);
										
												TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
												tbtmNewItem_1.setText("硬件");
												
														Composite composite_1 = new Composite(tabFolder, SWT.NONE);
														tbtmNewItem_1.setControl(composite_1);
														
														Label label_1 = new Label(composite_1, SWT.CENTER);
														label_1.setBounds(20, 19, 61, 17);
														label_1.setText("设备管理器");
														
														Label label_1_1 = new Label(composite_1, SWT.CENTER);
														label_1_1.setText("设备安装设置");
														label_1_1.setBounds(20, 176, 78, 17);
														
														Composite composite_3 = new Composite(composite_1, SWT.BORDER);
														composite_3.setBounds(10, 27, 403, 128);
														
														Label label_2 = new Label(composite_3, SWT.NONE);
														label_2.setImage(SWTResourceManager.getImage(SystemPropertyWin.class, "/com/yc/swt/imgs/设备管理.png"));
														label_2.setBounds(10, 10, 61, 49);
														
														Button btnNewButton_3 = new Button(composite_3, SWT.NONE);
														btnNewButton_3.setBounds(184, 87, 215, 27);
														btnNewButton_3.setText("设备管理器(D)");
														
														Label lblNewLabel_1 = new Label(composite_3, SWT.NONE);
														lblNewLabel_1.setBounds(93, 10, 296, 59);
														lblNewLabel_1.setText("设备管理器列出所有安装在计算机上的硬件设备。请使用设备管理器来更改设备的属性。");
														
														Composite composite_3_1 = new Composite(composite_1, SWT.BORDER);
														composite_3_1.setBounds(10, 184, 403, 128);
														
														Label lblpng = new Label(composite_3_1, SWT.NONE);
														lblpng.setImage(SWTResourceManager.getImage(SystemPropertyWin.class, "/com/yc/swt/imgs/设备安装.png"));
														lblpng.setBounds(9, 9, 61, 49);
														
														Button btnNewButton_3_1 = new Button(composite_3_1, SWT.NONE);
														btnNewButton_3_1.addSelectionListener(new SelectionAdapter() {
															@Override
															public void widgetSelected(SelectionEvent e) {
															}
														});
														btnNewButton_3_1.setText("设备安装设置(S)");
														btnNewButton_3_1.setBounds(174, 87, 215, 27);
														
														Label lblNewLabel_1_1 = new Label(composite_3_1, SWT.NONE);
														lblNewLabel_1_1.setText("选择Windows是否下载制造商提供的可用于你的设备的应用和自定义图标。");
														lblNewLabel_1_1.setBounds(93, 9, 296, 59);
								
										TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
										tabItem.setText("高级");
										
										Composite composite_4 = new Composite(tabFolder, SWT.NONE);
										tabItem.setControl(composite_4);
										
										Label label_3 = new Label(composite_4, SWT.NONE);
										label_3.setAlignment(SWT.CENTER);
										label_3.setBounds(24, 31, 32, 17);
										label_3.setText("性能");
										
										Label label_3_1 = new Label(composite_4, SWT.NONE);
										label_3_1.setText("用户配置文件");
										label_3_1.setAlignment(SWT.CENTER);
										label_3_1.setBounds(20, 173, 78, 17);
										
										Label label_3_1_1 = new Label(composite_4, SWT.NONE);
										label_3_1_1.setText("启动和故障恢复");
										label_3_1_1.setAlignment(SWT.CENTER);
										label_3_1_1.setBounds(20, 319, 91, 17);
										
										Composite composite_3_1_1 = new Composite(composite_4, SWT.BORDER);
										composite_3_1_1.setBounds(16, 40, 403, 128);
										
										Button btnNewButton_3_1_1 = new Button(composite_3_1_1, SWT.NONE);
										btnNewButton_3_1_1.setText("設置(S)");
										btnNewButton_3_1_1.setBounds(306, 87, 83, 27);
										
										Label lblNewLabel_1_1_1 = new Label(composite_3_1_1, SWT.NONE);
										lblNewLabel_1_1_1.setText("視覺效果,處理器計劃,內存使用,以及虛擬內存");
										lblNewLabel_1_1_1.setBounds(10, 10, 379, 59);
										
										Label lblNewLabel_2 = new Label(composite_4, SWT.NONE);
										lblNewLabel_2.setBounds(23, 10, 208, 17);
										lblNewLabel_2.setText("要進行大多數修改,你必須作為管理員登入.");
										
										Composite composite_3_1_1_1 = new Composite(composite_4, SWT.BORDER);
										composite_3_1_1_1.setBounds(10, 181, 403, 128);
										
										Button btnNewButton_3_1_1_1 = new Button(composite_3_1_1_1, SWT.NONE);
										btnNewButton_3_1_1_1.setText("設置(E)");
										btnNewButton_3_1_1_1.setBounds(306, 87, 83, 27);
										
										Label lblNewLabel_1_1_1_1 = new Label(composite_3_1_1_1, SWT.NONE);
										lblNewLabel_1_1_1_1.setText("與登錄賬戶相關的桌面設置");
										lblNewLabel_1_1_1_1.setBounds(10, 10, 379, 59);
										
										Composite composite_3_1_1_1_1 = new Composite(composite_4, SWT.BORDER);
										composite_3_1_1_1_1.setBounds(10, 327, 403, 128);
										
										Button btnNewButton_3_1_1_1_1 = new Button(composite_3_1_1_1_1, SWT.NONE);
										btnNewButton_3_1_1_1_1.setText("設置(T)");
										btnNewButton_3_1_1_1_1.setBounds(306, 87, 83, 27);
										
										Label lblNewLabel_1_1_1_1_1 = new Label(composite_3_1_1_1_1, SWT.NONE);
										lblNewLabel_1_1_1_1_1.setText("系統啟動,系統故障和調試信息");
										lblNewLabel_1_1_1_1_1.setBounds(10, 10, 379, 59);

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
