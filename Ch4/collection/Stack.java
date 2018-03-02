package collection;

public interface Stack {
	
//	Stack是一個先進後出的集合，可以想像成一個河內塔
//	ps.等二年級數據結構時就可以學得更深入了，到時候就能用C語言完整的實現Stack了!!!(很好玩的)
	
//	將新的Hero押入最上層
	public void push(Hero h);
//	將最上層的Hero取出
	public Hero pull();
//	查看最上層的Hero
	public Hero peek();
}
