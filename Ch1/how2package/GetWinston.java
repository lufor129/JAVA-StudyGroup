package how2package;

public class GetWinston {
	public static void main(String[] args) {
		// 用new實例化會失敗
		// Winston Boss=new Winston();

		// 用getWinston來獲得對象

		Winston w1 = Winston.getWinston();
		Winston w2 = Winston.getWinston();
		Winston w3 = Winston.getWinston();

		// 全部只會實例化一個物件
		System.out.println(w1);
		System.out.println(w2);
		System.out.println(w3);
		
		
		w1.getName();

	}
}
