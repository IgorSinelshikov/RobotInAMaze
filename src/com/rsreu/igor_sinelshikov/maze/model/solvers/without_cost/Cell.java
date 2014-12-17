/**
 * CellWrapper
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost;

/**
 * Класс-обертка клетки поля лабиринта, используемый в алгоритмах
 * поиска пути методом поиска в глубину и ширину.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class Cell {
	/** Значение клетки. */
	private int value;
	/** Флаг, показывающий проходил ли решатель клетку. */
	private boolean isTried;
	
	/**
	 * Возвращает значение клетки.
	 * 
	 * @return Значение клетки
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Задает значние клетки.
	 * 
	 * @param value Значение клетки
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Возвращает флаг, показывающий проходил ли решатель
	 * данную клетку.
	 * 
	 * @return Флаг, показывающий проходил ли решатель
	 * данную клетку
	 */
	public boolean isTried() {
		return isTried;
	}
	
	/**
	 * Задает флаг, показывающий проходил ли решатель
	 * данную клетку
	 * 
	 * @param isTried флаг, показывающий проходил ли решатель
	 * данную клетку
	 */
	public void setTried(boolean isTried) {
		this.isTried = isTried;
	}
}
