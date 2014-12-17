/**
 * Pair
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost;

/**
 * Класс пары координат.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class Pair {
	/** Координата X. */
	public int x;
	/** Координата Y. */
	public int y;
	
	/**
	 * Конструктор класса пары координат.
	 * 
	 * @param x Координата X
	 * @param y Координата Y
	 */
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
