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
 * ����� Swing �������������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class SwingViewer extends Viewer {
	/** ���� ����������. */
	private JFrame frame;
	/** ������ ��������� */
	private MazePanel mazePanel;
	/** ������ ���� ����������. */
	private JPanel menuPanel;
	/** ������ ���������� � ���������. */
	private JTextArea solverPanel;
	/** ��������. */
	private static Maze maze;
	/** ������ ������. */
	private static final int POINT_WIDTH = 5;
	/** ������ ������. */
	private static final int POINT_HEIGHT = 5;

	/**
	 * ����������� ������ Swing �������������.
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
		String text = "����� ����������, ��: " + (double)time + "; ";
		text += "���������� ��������������� ������: " + cellCount + "; ";
		text += "����� ����: " + cellPathCount + "; ";
		text += "��������������� ������: " + cellCount/cellPathCount + "; ";
		text += "������������� ��������� ������: " + (double)time/cellCount + "; ";
		this.solverPanel.setText(text);
	}
	
	/**
	 * ��������� ���� ����������.
	 * 
	 * @return ���� ����������
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * ������������� ���� ����������.
	 * 
	 * @param frame ���� ���������� ��� ���������
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * ���������� ������ ���������.
	 * 
	 * @return ������ ���������
	 */
	public JPanel getMazePanel() {
		return mazePanel;
	}

	/**
	 * ������������� ������ ���������.
	 * 
	 * @param mazePanel ������ ��������� ��� ���������
	 */
	public void setMazePanel(MazePanel mazePanel) {
		this.mazePanel = mazePanel;
	}

	/**
	 * ���������� ������ ����.
	 * 
	 * @return ������ ����
	 */
	public JPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * ������������� ������ ����.
	 * 
	 * @param menuPanel ������ ���� ��� ���������
	 */
	public void setMenuPanel(JPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/**
	 * ���������� �������� �������������.
	 * 
	 * @return ��������
	 */
	public static Maze getMaze() {
		return maze;
	}

	/**
	 * ������������� �������� �������������.
	 * 
	 * @param maze �������� ��� ���������
	 */
	public static void setMaze(Maze maze) {
		SwingViewer.maze = maze;
	}

	/**
	 * ���������� ������ ���������� � ���������.
	 * 
	 * @return ������ ���������� � ���������.
	 */
	public JTextArea getSolverPanel() {
		return solverPanel;
	}

	/**
	 * ������������� ������ ���������� � ���������.
	 * 
	 * @param solverPanel ������ ���������� � ��������� ��� ���������
	 */
	public void setSolverPanel(JTextArea solverPanel) {
		this.solverPanel = solverPanel;
	}
}
