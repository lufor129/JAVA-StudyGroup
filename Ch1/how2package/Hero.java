package how2package;

//使用其他包下的類
import method.Weapon;

public class Hero {

	// id 為private,只有Hero自己可以訪問
	// 子類無法繼承
	// 其他類無法訪問
	private String id;

	// 不寫 default package
	// 無修飾符的name
	//
	// 自己可以訪問
	// 同包子類可以繼承
	// 不同包子類不能繼承
	//
	// 同包類可以訪問
	// 不同包類不能訪問

	String name;

	protected int hp;

	// protected 的 hp
	// 自己可以訪問
	//
	// 同包子類可以繼承
	// 不同包子類可以繼承
	//
	// 同包子可以訪問
	// 不同包子類不可訪問

	public int damage;

	// public的属性 damage
	// 自己可以访问
	//
	// 同包子类可以继承
	// 不同包子类可以继承
	//
	// 同包类可以访问
	// 不同包类可以访问

	private float moveSpeed;

	// 總結
	// 1. 属性通常使用private封装起来
	// 2. 方法一般使用public用于被调用
	// 3. 会被子类继承的方法，通常使用protected
	// 4. package用的不多，一般新手会用package,因为还不知道有修饰符这个东西
	// 封裝原則
	// 简单说，能用private就用private，
	// 不行就放大一级，用package,再不行就用protected，
	// 最后用public。
	// 这样就能把数据尽量的封装起来，没有必要露出来的，就不用露出来了

	public void equip(Weapon w) {
		// 裝備武器
		this.damage += w.damage;
	}

	protected Hero(String name) {
		this.name = name;
	}

	/*----------靜態static-----------*/

	// 類屬性： 又叫做靜態屬性
	// 物件屬性： 又叫實例屬性，非靜態屬性
	//
	// 當一個屬性被static修飾的時候，就叫做類屬性，又叫做靜態屬性
	// 當一個屬性被聲明成類屬性，那麼所有的物件，都共用一個值
	//
	// 給英雄設置一個類屬性叫做“版權" (copyright), 無論有多少個具體的英雄，所有的英雄的版權都屬於 Blizzard
	// Entertainment公司

	// 靜態屬性
	public static String copyright;

	// 類方法： 又叫做靜態方法
	//
	// 物件方法： 又叫實例方法，非靜態方法

	// 常見: Math.random();
	// 訪問一個物件方法，必須建立在有一個物件的前提的基礎上
	// 訪問類方法，不需要物件的存在，直接就訪問

	// 只要是英雄都會勝利
	public static void battleWin() {
		System.out.println("you win ");
	}

	// 在靜態方法中調用動態方法
	// public static void useWeapon() {
	// Weapon hammer=new Weapon();
	// hammer.damage=100;
	//
	// this.equip(hammer);
	// }

}
