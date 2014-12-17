/**
 * RobotInAMaze
 */
package com.rsreu.igor_sinelshikov.maze;

import com.rsreu.igor_sinelshikov.maze.controller.Controller;
import com.rsreu.igor_sinelshikov.maze.model.Model;
import com.rsreu.igor_sinelshikov.maze.view.Viewer;
import com.rsreu.igor_sinelshikov.maze.view.ViewerFactory;
import com.rsreu.igor_sinelshikov.maze.view.ViewerType;

/**
 * Класс приложения.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class RobotInAMaze {
	/** Представление приложения. */
	private Viewer viewer;
	
	/**
	 * Входная точка в приложение.
	 * 
	 * @param args Параметры запуска
	 */
	public static void main(String[] args) {
		RobotInAMaze application = new RobotInAMaze();
		application.startApplication();
	}

	/**
	 * Начинает выполнение приложения.
	 */
	private void startApplication() {
		Controller controller = new Controller();
		this.viewer = ViewerFactory.getInstance(ViewerType.SWING);
		viewer.setController(controller);
		controller.setViewer(viewer);
		Model model = new Model();
		controller.setModel(model);		
		model.addListener(viewer);
	}
}
