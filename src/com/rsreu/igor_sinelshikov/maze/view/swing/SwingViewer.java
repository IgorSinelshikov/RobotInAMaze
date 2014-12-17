/**
 * SwingViewer
 */
package com.rsreu.igor_sinelshikov.maze.view.swing;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;
import com.rsreu.igor_sinelshikov.maze.view.Viewer;

/**
 * Класс Swing представления.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class SwingViewer extends Viewer {
	/** Окно приложения. */
	private JFrame frame;
	/** Панель лабиринта */
	private MazePanel mazePanel;
	/** Панель меню приложения. */
	private JPanel menuPanel;
	/** Панель информации о решателях. */
	private JTextArea solverPanel;
	/** Лабиринт. */
	private static Maze maze;
	/** Ширина клетки. */
	private static final int POINT_WIDTH = 5;
	/** Высота клетки. */
	private static final int POINT_HEIGHT = 5;

	/**
	 * Конструктор класса Swing представления.
	 */
	public SwingViewer() {
		final SwingViewer viewer = this;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame nframe = SwingViewerUtilities.createFrame(viewer);
				frame = nframe;
				mazePanel.setFocusable(true);
				mazePanel.setFocusTraversalKeysEnabled(true);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mazeGenerated(Maze maze) {
		setMaze(maze);
		for (int i=0; i<maze.getMazeWidth(); i++) {
			for (int j=0; j<maze.getMazeHeight(); j++) {
				Rectangle rectangle = new Rectangle();
				rectangle.setRect(i*POINT_WIDTH, j*POINT_HEIGHT, POINT_WIDTH, POINT_HEIGHT);
				mazePanel.getRepaintActions().put(rectangle, maze.getField()[i][j]);
			}
		}
		this.mazePanel.paintComponent(this.mazePanel.getGraphics());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void userMoved(int oldX, int oldY, int newX, int newY) {
		setMaze(maze);
		Rectangle rectangleOld = new Rectangle();
		rectangleOld.setRect(oldX*POINT_WIDTH, oldY*POINT_HEIGHT, POINT_WIDTH, POINT_HEIGHT);	
		Rectangle rectangleNew = new Rectangle();
		rectangleNew.setRect(newX*POINT_WIDTH, newY*POINT_HEIGHT, POINT_WIDTH, POINT_HEIGHT);
		mazePanel.getRepaintActions().put(rectangleOld, 1);
		mazePanel.getRepaintActions().put(rectangleNew, 3);
		this.mazePanel.paintComponent(this.mazePanel.getGraphics());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cellTried(int x, int y) {
		Rectangle rectangle = new Rectangle();
		rectangle.setRect(x*POINT_WIDTH, y*POINT_HEIGHT, POINT_WIDTH, POINT_HEIGHT);
		mazePanel.getRepaintActions().put(rectangle, 2);
		this.mazePanel.paintComponent(this.mazePanel.getGraphics());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void searchHappened(long time, int cellCount, int cellPathCount) {
		String text = "Время выполнения, мс: " + (double)time + "; ";
		text += "Количество сгенерированных вершин: " + cellCount + "; ";
		text += "Длина пути: " + cellPathCount + "; ";
		text += "Разветвленность поиска: " + cellCount/cellPathCount + "; ";
		text += "Эффективность просмотра вершин: " + (double)time/cellCount + "; ";
		this.solverPanel.setText(text);
	}
	
	/**
	 * Возвращет окно приложения.
	 * 
	 * @return Окно приложения
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Устанавливает окно приложения.
	 * 
	 * @param frame Окно приложения для установки
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Вовзращает панель лабиринта.
	 * 
	 * @return Панель лабиринта
	 */
	public JPanel getMazePanel() {
		return mazePanel;
	}

	/**
	 * Устанавливает панель лабиринта.
	 * 
	 * @param mazePanel Панель лабиринта для установки
	 */
	public void setMazePanel(MazePanel mazePanel) {
		this.mazePanel = mazePanel;
	}

	/**
	 * Возвращает панель меню.
	 * 
	 * @return Панель меню
	 */
	public JPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * Устанавливает панель меню.
	 * 
	 * @param menuPanel Панель меню для установки
	 */
	public void setMenuPanel(JPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/**
	 * Вовзращает лабиринт представления.
	 * 
	 * @return Лабиринт
	 */
	public static Maze getMaze() {
		return maze;
	}

	/**
	 * Устанавливает лабиринт представления.
	 * 
	 * @param maze Лабиринт для установки
	 */
	public static void setMaze(Maze maze) {
		SwingViewer.maze = maze;
	}

	/**
	 * Возвращает панель информации о решателях.
	 * 
	 * @return Панель информации о решателях.
	 */
	public JTextArea getSolverPanel() {
		return solverPanel;
	}

	/**
	 * Устанавливает панель информации о решателях.
	 * 
	 * @param solverPanel Панель информации о решателях для установки
	 */
	public void setSolverPanel(JTextArea solverPanel) {
		this.solverPanel = solverPanel;
	}
}
