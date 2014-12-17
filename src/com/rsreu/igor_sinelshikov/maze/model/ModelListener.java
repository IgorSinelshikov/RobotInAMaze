/**
 * ModelListener
 */
package com.rsreu.igor_sinelshikov.maze.model;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;

/**
 * Интерфейс слушателя модели.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public interface ModelListener {
	/**
	 * Выполняет действия, когда решатель завершает просчет.
	 * 
	 * @param time Время выполнения
	 * @param cellCount Длина результирубщего пути
	 * @param cellPathCount Количество сгенерированных вершин
	 */
	void searchHappened(long time, int cellCount, int cellPathCount);
	
	/**
	 * Выполняет действия, когда лабиринт был
	 * сгенерирован и его необходимо представить пользователю.
	 * 
	 * @param maze Сгенерированный лабиринт
	 */
	void mazeGenerated(Maze maze);

	/**
	 * Выполняет действия, когда пользователь совершает движение.
	 * 
	 * @param oldX Старая X позиция
	 * @param oldY Старая Y позиция
	 * @param newX Новая X позиция
	 * @param newY Новая Y позиция
	 */
	void userMoved(int oldX, int oldY, int newX, int newY);

	/**
	 * Выполняет действия, когда клетка лабиринта была
	 * пройдена решателем.
	 * 
	 * @param yPos Y позиция клетки
	 * @param xPos X позиция клетки
	 */
	void cellTried(int xPos, int yPos);
}
