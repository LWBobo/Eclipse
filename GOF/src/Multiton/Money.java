package Multiton;

import java.util.ArrayList;

public class Money {
	/**
	 * 多例类，确保系统中，某个对象的类只能存在有限个。
	 */
	private static final int num = 3;
	private static int count = 0;
	private static ArrayList<Money> m = null;
	static {
		m = new ArrayList<Money>(num);
	}

	private Money() {
	}
	/** 普通模式，效率高*/
	public static Money getInstance() {
		if (m.size() < num) {
			while (m.size() < num) {
				Money money = new Money();
				m.add(money);
			}
		}
		return m.get((count++) % 3);
	}
	
	/** 线程安全，效率低*/
	public static Money getInstance_safe() {
		if (m.size() < num) {
			synchronized (m.getClass()) {
				Money money;
				if (m.size() < num) {
					synchronized (m.getClass()) {
						while (m.size() < num) {
							money = new Money();
							m.add(money);
						}
					}
				}

			}
		}
		return m.get((count++) % 3);
	}

}
