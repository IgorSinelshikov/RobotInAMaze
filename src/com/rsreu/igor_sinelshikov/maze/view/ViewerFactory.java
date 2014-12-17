/**
 * ViewerFactory
 */
package com.rsreu.igor_sinelshikov.maze.view;

import com.rsreu.igor_sinelshikov.maze.view.swing.SwingViewer;

/**
 * Класс абстрактной фабрики представлений приложения.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public abstract class ViewerFactory {
	/** Сообщение о некорреткном типе представления. */
	private static final String ILLEGAL_VIEWER_TYPE_MESSAGE = "Specified viewer type is undefined";

	/**
	 * Возвращает представление определенного типа.
	 * 
	 * @param type Тип представления
	 * @return Представление определенного типа
	 */
	public static Viewer getInstance(ViewerType type) {
		switch (type) {
		case SWING:
			return new SwingViewer();
		default:
			throw new IllegalArgumentException(ILLEGAL_VIEWER_TYPE_MESSAGE);		
		}
	}
}
