/**
 * ButtonListener
 */
package com.rsreu.igor_sinelshikov.maze.view.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import static com.rsreu.igor_sinelshikov.maze.model.solvers.SolverType.*;

import com.rsreu.igor_sinelshikov.maze.controller.Controller;

/**
 * Класс слушателя кнопок Swing представления.
 * 
 * @author Igor_Sinelshikov
 * @version 1.01
 * @since 1.01
 */
public class ButtonListener implements ActionListener {
	/** Название кнопки генерации лабиринта. */
	private static final String GENERATE_BUTTON = "Генерация лабиринта";
	/** Название кнопки поиска в глубину. */
	private static final String DEPTH_METHOD_BUTTON = "Поиск в глубину";
	/** Название кнопки поиска в ширину. */
	private static final String BREADTH_METHOD_BUTTON = "Поиск в ширину";
	/** Название кнопки поиска по первому наилучшему совпадению. */
	private static final String GREEDY_BEST_FIRST_METHOD_BUTTON = "Поиск \"Первый-лучше\"";
	/** Название кнопки поиска методом равных цен. */
	private static final String UNIFORM_METHOD_BUTTON = "Поиск методом равных цен";
	/** Название кнопки влево. */
	private static final String LEFT_BUTTON = "Влево";
	/** Название кнопки вправо. */
	private static final String RIGHT_BUTTON = "Вправо";
	/** Название кнопки вверх. */
	private static final String UP_BUTTON = "Вверх";
	/** Название кнопки вниз. */
	private static final String DOWN_BUTTON = "Вниз";
	/** Button listener controller. */
	private Controller controller;
	
	/**
	 * Конструктор класса слушателя кнопок представления.
	 * 
	 * @param controller Контроллер представления
	 */
	public ButtonListener(Controller controller) {
		this.controller = controller;
	}
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button =  (JButton) e.getSource();
		String title = button.getText();
		Direction direction = null;
		if (title.equals(GENERATE_BUTTON)) {
			int mazeWidth = 250;
			int mazeHeight = 150;
			this.controller.generateMaze(mazeWidth, mazeHeight);
		}
		if (title.equals(DEPTH_METHOD_BUTTON)) {
			this.controller.findPath(DEPTH_FIRST_SEARCH);
		}
		if (title.equals(BREADTH_METHOD_BUTTON)) {
			this.controller.findPath(BREADTH_FIRST_SEARCH);
		}
		if (title.equals(GREEDY_BEST_FIRST_METHOD_BUTTON)) {
			this.controller.findPath(BEST_FIRST_SEARCH);
		}
		if (title.equals(UNIFORM_METHOD_BUTTON)) {
			this.controller.findPath(UNIFORM_COST_SEACRH);
		}
		if (title.equals(LEFT_BUTTON)) {
			direction = Direction.LEFT;
			this.controller.userMoved(direction);
		}
		if (title.equals(RIGHT_BUTTON)) {
			direction = Direction.RIGHT;
			this.controller.userMoved(direction);
		}
		if (title.equals(UP_BUTTON)) {
			direction = Direction.UP;
			this.controller.userMoved(direction);
		}
		if (title.equals(DOWN_BUTTON)) {
			direction = Direction.DOWN;
			this.controller.userMoved(direction);
		}
	}
}
