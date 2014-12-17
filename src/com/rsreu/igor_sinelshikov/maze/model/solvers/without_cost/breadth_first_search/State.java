/**
 * State
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.breadth_first_search;

/**
 * Класс позиции клетки.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class State {
	/** X позиция клетки. */
	public int xPos;
	/** Y позиция клетки. */
	public int yPos;
	/** Дистанция до клетки. */
	public int dist;

	/**
	 * Конструктор класса позиции клетки.
	 * 
	 * @param xPos X позиция клетки
	 * @param yPos Y позиция клетки
	 * @param dist Дистанция до клетки
	 */
	public State(int xPos, int yPos, int dist) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.dist = dist;
	}
}