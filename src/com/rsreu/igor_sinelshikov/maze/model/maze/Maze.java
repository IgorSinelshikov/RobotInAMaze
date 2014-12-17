/**
 * Maze
 */
package com.rsreu.igor_sinelshikov.maze.model.maze;

/**
 * Класс игрового объекта - лабиринта.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 */
public class Maze {
	/** Ширина лабиринта по умолчанию. */
	private static final int DEFAULT_WIDTH = 40;
	/** Высота лабиринта по умолчанию. */
	private static final int DEFAULT_HEIGHT = 40;
	/** Поле лабиринта. */
	private int[][] mazeField;
	/** Ширина лабиринта. */
	private int mazeWidth;
	/** Высота лабиринта. */
	private int mazeHeight;
	
	/**
	 * Конструктор класса лабиринта.
	 */
	public Maze() {
		this.mazeWidth = DEFAULT_WIDTH;
		this.mazeHeight = DEFAULT_HEIGHT;
		this.mazeField = new int[this.mazeWidth][this.mazeHeight];
	}
	
	/**
	 * Конструктор класса лабиринта.
	 * 
	 * @param mazeWidth Ширина лабиринта
	 * @param mazeHeight Высота лабиринта
	 * 
	 */
	public Maze(int mazeWidth, int mazeHeight) {
		this.mazeWidth = mazeWidth;
		this.mazeHeight = mazeHeight;
		this.mazeField = new int[mazeWidth][mazeHeight];
	}

	/**
	 * Возвращает поле лабиринта.
	 * 
	 * @return Поле лабиринта
	 */
	public int[][] getField() {
		return mazeField;
	}

	/**
	 * Устанавливает поле лабиринта.
	 * 
	 * @param mazeField Поле лабиринта для установки
	 */
	public void setField(int[][] mazeField) {
		this.mazeField = mazeField;
	}	
	
	/**
	 * Возвращает ширину лабиринта.
	 * 
	 * @return Ширина лабиринта
	 */
	public int getMazeWidth() {
		return this.mazeWidth;
	}

	/**
	 * Возвращает высоту лабиринта.
	 * 
	 * @return Высота лабиринта
	 */
	public int getMazeHeight() {
		return this.mazeHeight;
	}
}
