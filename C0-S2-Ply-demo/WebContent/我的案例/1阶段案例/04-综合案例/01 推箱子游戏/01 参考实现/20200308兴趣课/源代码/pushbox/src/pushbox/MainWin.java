package pushbox;

// ������
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ��Ϸ������, �̳� Swing (ͼ�α�̿��) �� JFrame ������
 */
public class MainWin extends JFrame {

	/**
	 * �����ͼ
	 */
	private int[][] map = Maps.next();

	/**
	 * ����ͼƬ�ؼ�����, ʵ�ֵ�ͼmap��ͼƬ�ؼ���ӳ��, �� map �Ĵ�Сһ��
	 */
	private JLabel[][] labelMap = new JLabel[10][10];

	// ����ͼ������
	private Icon[] imgs = new Icon[10];

	public static void main(String[] args) {
		// �������������
		MainWin mainWin = new MainWin();
	}

	// MainWin ���췽��( ��ʼ�� )
	public MainWin() {

		// ����10��ͼƬ
		loadImg();

		// ���ò��ֹ�����, ʹ�����񲼾�
		this.setLayout(new GridLayout(10, 10));

		// ��ʼ��ͼƬ�ؼ�
		initLabel();
		
		// ������Ϸ����
		Game game = new Game();
		// ����Ϸ�������õ�ͼ
		game.setMap(map);
		
		/**
		 * ��Ӽ����¼�����
		 */
		this.addKeyListener(new KeyAdapter() {
			/**
			 * �������̰��µ��¼�
			 */
			public void keyPressed(KeyEvent e) {
				// �ж��Ƿ���"��������"��
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.down();
				} else if(e.getKeyCode() == KeyEvent.VK_UP) {
					game.up();
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.left();
				} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.right();
				}
				// ����ͼ������ͬ����ͼƬ�ؼ���
				updateLabel();
				// �ж���Ϸ�Ƿ����
				if( game.isOver()) {
					// ��������ʾ�򴰿�
					JOptionPane.showMessageDialog(null, "Ӣ��!��Ӯ��!");
				}
			}
		});

		// ��ʼ������
		initWindow();

	}

	/**
	 * ����ͼƬ
	 */
	public void loadImg() {
		for (int i = 0; i < 10; i++) {
			imgs[i] = new ImageIcon(MainWin.class.getResource("/imgs/" + i + ".gif"));
		}
	}

	/**
	 * �ڴ����������ͼ�ؼ�
	 */
	public void initLabel() {
		// Ƕ��ѭ������ map ����,���� label
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// ���ݵ�ͼ��ǰ����ֵ, ȡ��Ӧ��ͼƬ
				int index = map[y][x];
				// ��ȡ��ͼ����ֵ��Ӧ��ͼƬ
				Icon icon = imgs[index];
				// ������ǩ����
				JLabel label = new JLabel(icon);
				// ����ǩ���봰����
				this.add(label);
				// ��ͼƬ���뵽ͼƬ�ؼ�������
				labelMap[y][x] = label;
			}
		}
	}

	/**
	 * ����ͼ������ͬ����ͼƬ�ؼ���
	 */
	public void updateLabel() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// ���ݵ�ͼ��ǰ����ֵ, ȡ��Ӧ��ͼƬ
				int index = map[y][x];
				// ��ȡ��ͼ����ֵ��Ӧ��ͼƬ
				Icon icon = imgs[index];
				// �������ÿؼ���ͼƬ
				labelMap[y][x].setIcon(icon);
			}
		}
	}

	/**
	 * ��ʼ������
	 */
	public void initWindow() {
		// ���ƴ����С, �Զ���Ӧ�ڲ�Ԫ��
		this.pack();
		// ��ʾ����
		this.setVisible(true);

		/**
		 * ���ھ���, ���㴰�ڵ�λ��, Ȼ���������ô���λ��
		 */
		// ��ȡ��Ļ���
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		// ��ȡ��Ļ�߶�
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		// ��ȡ���ڵĿ��
		int selfWidth = this.getSize().width;
		// ��ȡ���ڵĸ߶�
		int selfHeight = this.getSize().height;
		// ���㴰�ڵľ���λ��
		int x = (screenWidth - selfWidth) / 2;
		int y = (screenHeight - selfHeight) / 2;
		// �������ô���λ��
		this.setLocation(x, y);

		// ���ô���رռ����˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
