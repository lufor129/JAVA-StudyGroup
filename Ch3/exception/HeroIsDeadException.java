package exception;

public class HeroIsDeadException extends Exception {

	// 一個英雄攻擊另一個英雄的時候，如果發現另一個英雄已經掛了，就會拋出HeroIsDeadException
	// 創建一個類HeroIsDeadException，並繼承Exception
	// 提供兩個構造方法
	// 1. 無參的構造方法
	// 2. 帶參的構造方法，並調用父類的對應的構造方法

	public HeroIsDeadException() {

	}

	public HeroIsDeadException(String message) {
		super(message);
	}
}
