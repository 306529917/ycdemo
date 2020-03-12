package pushbox;

/**
 * ��Ϸ��,���ڲ�����ͼ map
 */
public class Game {

	// ��Ϸ�ĵ�ǰ��ͼ
	private int[][] map;

	// ���õ�ͼ
	public void setMap(int[][] map) {
		this.map = map;
	}

	// ����С�������ƶ�
	public void down() {
		// ���ҵ�С��
		int[] xy = findMan();
		// ����: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// �������ӵ�����
		// x ����
		int newx = x;
		// y �����һ
		int newy = y + 1;
		// �������Ӻ��������
		int newx1 = x;
		int newy1 = y + 2;

		/**
		 * �ж��Ƿ�����ƶ�
		 */
		if (map[newy][newx] == 1) {
			// ǰ���Ƿ���,�����ƶ�
			return;
		} else if (map[newy][newx] == 3) {
			// ���ǰ��������, ���ж�����ǰ����ʲô
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// ����� �̵� 2 ���ߵ� Ŀ�� 4, ��ô���Ӿ��ƹ�ȥ
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// �ƶ�С��
		map[newy][newx] = map[y][x];
		// ��С��ԭ���ĸ��ӻ�ԭ���̵�
		map[y][x] = 2;
	}

	// ����С�������ƶ�
	public void up() {
		// ���ҵ�С��
		int[] xy = findMan();
		// ����: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// �������ӵ�����
		// x ����
		int newx = x;
		// y �����һ
		int newy = y - 1;
		// �������Ӻ��������
		int newx1 = x;
		int newy1 = y - 2;

		/**
		 * �ж��Ƿ�����ƶ�
		 */
		if (map[newy][newx] == 1) {
			// ǰ���Ƿ���,�����ƶ�
			return;
		} else if (map[newy][newx] == 3) {
			// ���ǰ��������, ���ж�����ǰ����ʲô
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// ����� �̵� 2 ���ߵ� Ŀ�� 4, ��ô���Ӿ��ƹ�ȥ
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// �ƶ�С��
		map[newy][newx] = map[y][x];
		// ��С��ԭ���ĸ��ӻ�ԭ���̵�
		map[y][x] = 2;
	}

	// ����С�������ƶ�
	public void left() {
		// ���ҵ�С��
		int[] xy = findMan();
		// ����: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// �������ӵ�����
		int newx = x - 1;
		int newy = y;
		// �������Ӻ��������
		int newx1 = x - 2;
		int newy1 = y;

		/**
		 * �ж��Ƿ�����ƶ�
		 */
		if (map[newy][newx] == 1) {
			// ǰ���Ƿ���,�����ƶ�
			return;
		} else if (map[newy][newx] == 3) {
			// ���ǰ��������, ���ж�����ǰ����ʲô
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// ����� �̵� 2 ���ߵ� Ŀ�� 4, ��ô���Ӿ��ƹ�ȥ
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// �ƶ�С��
		map[newy][newx] = map[y][x];
		// ��С��ԭ���ĸ��ӻ�ԭ���̵�
		map[y][x] = 2;
	}

	public void right() {
		// ���ҵ�С��
		int[] xy = findMan();
		// ����: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// �������ӵ�����
		int newx = x + 1;
		int newy = y;
		// �������Ӻ��������
		int newx1 = x + 2;
		int newy1 = y;

		/**
		 * �ж��Ƿ�����ƶ�
		 */
		if (map[newy][newx] == 1) {
			// ǰ���Ƿ���,�����ƶ�
			return;
		} else if (map[newy][newx] == 3) {
			// ���ǰ��������, ���ж�����ǰ����ʲô
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// ����� �̵� 2 ���ߵ� Ŀ�� 4, ��ô���Ӿ��ƹ�ȥ
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// �ƶ�С��
		map[newy][newx] = map[y][x];
		// ��С��ԭ���ĸ��ӻ�ԭ���̵�
		map[y][x] = 2;
	}

	/**
	 * �ж���Ϸ�Ƿ����
	 * @return
	 */
	public boolean isOver() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// �ҵ�С�˾ͷ�����������ֵ
				if (map[y][x] == 4) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * ��С��
	 */
	public int[] findMan() {
		// ���븴�� ��򵥵ķ�ʽ copy
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// �ҵ�С�˾ͷ�����������ֵ
				if (map[y][x] == 5) {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

}
