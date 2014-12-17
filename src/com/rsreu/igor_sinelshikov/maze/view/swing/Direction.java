/**
 * Direction
 */
package com.rsreu.igor_sinelshikov.maze.view.swing;

/**
 * Направление игрового объекта.
 * Движение всех объектов может принимать значение <code>RIGHT</code>, <code>LEFT</code>, 
 * <code>UP</code> and <code>DOWN</code>.
 *
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public enum Direction {
	/** Направление вверх. */
	UP(0,-1), 
	/** Направление вниз. */ 
	DOWN(0,1), 
	/** Направление влево. */
	LEFT(-1,0), 
	/** Направление вправо. */
	RIGHT(1,0),
	/** Без направления. */
	NONE;
	
	/** X координата направления. */
	private Integer x;
	/** Y координата направления. */
	private Integer y;
	
	/**
	 * Конструктор перечисления направлений.
	 * 
	 * @param x X координата направления
	 * @param y Y координата направления
	 */
	Direction(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Конструктор перечисления направлений.
	 */
	Direction() {	
	}

	/**
	 * Возвращает X координата направления
	 * 
	 * @return x X координата направления
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * Возвращает Y координата направления
	 * 
	 * @return y Y координата направления
	 */
	public Integer getY() {
		return y;
	}
}
