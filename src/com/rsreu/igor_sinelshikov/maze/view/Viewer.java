/**
 * Viewer
 */
package com.rsreu.igor_sinelshikov.maze.view;

import com.rsreu.igor_sinelshikov.maze.controller.Controller;
import com.rsreu.igor_sinelshikov.maze.model.ModelListener;

/**
 * Абстрактный класс представления.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public abstract class Viewer implements ModelListener {
	/** Контроллер представления. */
	protected Controller controller;

	/**
	 * Устанавливает контроллер представления.
	 * 
	 * @param controller Устанавливаемый контроллер
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Возвращает контроллер представления.
	 * 
	 * @return Контроллер представления
	 */
	public Controller getController() {
		return this.controller;
	}
}
