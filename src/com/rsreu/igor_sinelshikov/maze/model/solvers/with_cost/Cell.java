/**
 * Cell
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost;

/**
 * Класс обертки для клетки поля лабиринта.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class Cell {
	/** Пара координат предшественника клетки. */
	public Pair parent;
	/** Пара координат текущей клетки. */
	public Pair current;
	/** Цена клетки. */
	public double cost;
	/** Значение клетки. */
	public int value;
	/** Является ли клетка выходом из лабиринта. */
	public boolean goal;
	/** Цена поиска в алгоритме по первому наилучшему совпадению. */
	public double bfsCost;
	
	/**
	 * Конструктор класса обертки клетки лабиринта.
	 * 
	 * @param x Координата X клетки
	 * @param y Координата Y клетки
	 */
	public Cell(int x, int y){
		this.current = new Pair(x, y);
		cost = 0;
		value = 0;
		goal = false;
		bfsCost = Math.sqrt((Math.pow((x), 2)+Math.pow((y), 2)));
	}
}
