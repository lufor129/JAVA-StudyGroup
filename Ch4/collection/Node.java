package collection;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Node {

	// 左節點
	public Node leftNode;
	// 右節點
	public Node rightNode;
	// 值
	public Object value;

	public void add(Object v) {
		// 當前節點沒有值，把數據放進去
		if (null == value) {
			value = v;
		}
		// 有值額判斷要放左邊還是右邊
		else {
			if ((Integer) v - (Integer) value <= 0) {
				// 若左邊沒有節點，見新結點
				if (null == leftNode)
					leftNode = new Node();
				leftNode.add(v);
			} else {
				// 比大但右邊沒有節點
				if (null == rightNode)
					rightNode = new Node();
				rightNode.add(v);

			}
		}
	}
	
	//中序遍歷，此外還有前序、後續
	public List<Object> values() {
		List<Object> values = new ArrayList<>();
		
//		若有左節點，則繼續遍歷
		if(leftNode!=null)
			values.addAll(leftNode.values());
		
//		加入當前節點
		values.add(value);
		
//		若有右節點，則繼續遍歷
		if(rightNode!=null)
			values.addAll(rightNode.values());
		
		return values;
	}

	public static void main(String[] args) {
		/*-------------二叉樹(聽說台灣叫二元樹，不過我覺得二叉樹好聽)--------*/
		// 這部分是進階(數據結構)，講述集合排序問題，不會在課堂上講解。
		// 有興趣提早認識數據結構的人，超超超大力推薦:https://www.icourse163.org/course/ZJU-93001#/info
		// 陳越姥姥是我的水、我的光、我的神啊~~~

		// 假設通過二叉樹對如下10個亂數進行排序
		// 67,7,30,73,10,0,78,81,10,74
		// 排序的第一個步驟是把資料插入到該二叉樹中
		// 插入基本邏輯是，小、相同的放左邊，大的放右邊
		// 1. 67 放在根節點
		// 2. 7 比 67小，放在67的左節點
		// 3. 30 比67 小，找到67的左節點7，30比7大，就放在7的右節點
		// 4. 73 比67大， 放在67得右節點
		// 5. 10 比 67小，找到67的左節點7，10比7大，找到7的右節點30，10比30小，放在30的左節點。
		// ...
		// ...
		// 9. 10比67小，找到67的左節點7，10比7大，找到7的右節點30，10比30小，找到30的左節點10，10和10一樣大，放在左邊
		
		Random r=new Random();
		int[] ran=new int [10];
		
		for(int i=0;i<10;i++) {
			ran[i]=r.nextInt(100);
		}
		
		for(int k:ran) {
			System.out.println(k);
		}
		
//		根節點
		Node roots=new Node();
		for(int k:ran) {
			roots.add(k);
		}
		
		System.out.println(roots.values());
		
	}

}
