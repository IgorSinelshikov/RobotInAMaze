/**
 * Controller
 */
package com.rsreu.igor_sinelshikov.maze.controller;

import com.rsreu.igor_sinelshikov.maze.model.Model;
import com.rsreu.igor_sinelshikov.maze.model.solvers.SolverType;
import com.rsreu.igor_sinelshikov.maze.view.Viewer;
import com.rsreu.igor_sinelshikov.maze.view.swing.Direction;

/**
 * Контроллер приложения.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class Controller {
	/** Модель конроллера. */
	private Model model;
	/** Представление контроллера. */
	private Viewer viewer;
	
	/**
	 * Конструктор класса контроллера.
	 * 
	 * @param model Модель приложения
	 * @param viewer Представление приложения
	 */
	public Controller(Model model, Viewer viewer) {
		this.setModel(model);
		this.viewer = viewer;
	}

	/**
	 * Конструктор класса контроллера.
	 */
	public Controller() {
	}

	/**
	 * Возвращает модель контроллера.
	 * 
	 * @return Модель контроллера
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Устанавливает модель контроллера.
	 * 
	 * @param model Модель контроллера для установки
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Вовзращает представление контроллера.
	 * 
	 * @return Представление контроллера
	 */
	public Viewer getViewer() {
		return viewer;
	}

	/**
	 * Устанавливает представление контроллера.
	 * 
	 * @param viewer Представление контроллера для установки
	 */
	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * Выполняет действия, когда происходит событие генерации лабиринта
	 * 
	 * @param mazeWidth Ширина лабиринта
	 * @param mazeHeight Высота лабиринта
	 */
	public void generateMaze(int mazeWidth, int mazeHeight) {
		this.model.generateMaze(mazeWidth, mazeHeight);
	}

	/**
	 * Выполняет дейтсвия, когда необходимо найти путь в лабиринте.
	 * 
	 * @param type Тип решателя лабиринта
	 */
	public void findPath(SolverType type) {
		this.model.findPath(type, this.model.getMaze());
	}
	
	/**
	 * Выполняет дейтсвия, когда пользователь двигается.
	 * 
	 * @param direction Направление движения
	 */
	public void userMoved(Direction direction) {
		this.model.userMoved(direction);
	}
}
