public class E {
	public static void main(String[] args) {
		for (int i = 1;; i++) {
			int	peach = i;
			if ((peach - 1) % 5 == 0) {
				peach = (peach - 1) / 5 * 4;
				if ((peach - 1) % 5 == 0) {
					peach = (peach - 1) / 5 * 4;
					if ((peach - 1) % 5 == 0) {
						peach = (peach - 1) / 5 * 4;
						if ((peach - 1) % 5 == 0) {
							peach = (peach - 1) / 5 * 4;
							if ((peach - 1) % 5 == 0) {
								System.out.println(i);
								break;
							}
						}
					}
				}
			}
		}
	}
}

//������41��
//��Ŀ:��̲����һ����,��ֻ��������.��һֻ���Ӱ��������ƾ�ݷ�Ϊ���,����һ��,��ֻ���ӰѶ��һ 
//�����뺣��,������һ��.�ڶ�ֻ���Ӱ�ʣ�µ�������ƽ���ֳ����,�ֶ���һ��,��ͬ���Ѷ��һ�����뺣�� 
//������һ��,����,����,����ֻ���Ӷ�����������,�ʺ�̲��ԭ�������ж��ٸ�����?