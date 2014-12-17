/**
 * Model
 */
package com.rsreu.igor_sinelshikov.maze.model;

import java.util.ArrayList;
import java.util.List;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;
import com.rsreu.igor_sinelshikov.maze.model.maze.MazeGenerator;
import com.rsreu.igor_sinelshikov.maze.model.solvers.Solver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.SolverFactory;
import com.rsreu.igor_sinelshikov.maze.model.solvers.SolverType;
import com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.depth_first_search.DepthFirstSearchSolver;
import com.rsreu.igor_sinelshikov.maze.view.swing.Direction;

/**
 * ����� ������ ����������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class Model {
	/** ������� ��������. */
	private Maze maze;
	/** ������� X ������� ������������. */
	private int currentRow;
	/** ������� Y ������� ������������. */
	private int currentColumn;
	/** ������ ���������� ������. */
	private static List<ModelListener> listeners;
	/** ����� ����. */
	private static int cellPathCount;

	/**
	 * ����������� ��� ������ ������ ����������.
	 */
	public Model() {
		Model.listeners = new ArrayList<ModelListener>();
		this.maze = new Maze();
	}

	/**
	 * ���������� �������� ������������� �������.
	 * 
	 * @param mazeWidth ������ ���������
	 * @param mazeHeight ������ ���������
	 */
	public void generateMaze(int mazeWidth, int mazeHeight) {
		MazeGenerator mazeGenerator = new MazeGenerator(); 
		this.maze = mazeGenerator.construct(mazeWidth, mazeHeight);
		currentRow = 1;
		currentColumn = 1;
		this.maze.getField()[1][1] = 3;
		this.maze.getField()[this.maze.getMazeWidth() - 3][this.maze.getMazeHeight() - 3] = 4;
		for (ModelListener listener:listeners) {
			listener.mazeGenerated(this.maze);
		}
	}

	/**
	 * ������� ���� � ������ ���������.
	 * 
	 * @param type ��� ��������
	 * @param maze ��������, � ������� ���������� ����� ����
	 */
	public void findPath(SolverType type, Maze maze) {
		if (maze != null && type != null) {
			DepthFirstSearchSolver pathFinder = (DepthFirstSearchSolver) SolverFactory.getInstance(SolverType.DEPTH_FIRST_SEARCH);
			pathFinder.calculatePath(maze);
			Solver solver = SolverFactory.getInstance(type);
			solver.solve(maze);
			pathFinder.findPath(maze);
			for (ModelListener listener:listeners) {
				listener.mazeGenerated(this.maze);
			}
		}
		
	}

	/**
	 * ��������� ����������, ���������� � ������������ ������
	 * �� ����. ���������, �������� �� ��������� ������ ��������
	 * �, ���� ��� �������� ��������, ���������� ������ �� ��� ������.
	 * ������ ���� ��������� � ������������ � ����� ���������� ������.
	 * 
	 * @param direction ����������� ��������
	 */
	public void userMoved(Direction direction) {
		int row = currentRow + direction.getX() ;
		int column = currentColumn + direction.getY();
		int[][] field = maze.getField();
		if (row >= 0 && row < field.length && column >= 0 && column < field[row].length) {
			if (field[row][column] == 4) {
				this.generateMaze(this.maze.getMazeWidth(), this.maze.getMazeHeight());
			} else {
				if (field[row][column] != 0) {
					for (ModelListener listener:listeners) {
						listener.userMoved(currentRow, currentColumn, row, column);
					}
					this.maze.getField()[currentRow][currentColumn] = 1;
					currentRow = row;
					currentColumn = column;		
					this.maze.getField()[currentRow][currentColumn] = 3;
				}
			}
		}

	}

	/**
	 * ��������� ��������� ������.
	 * 
	 * @param listener ��������� ��� ����������
	 */
	public void addListener(ModelListener listener) {
		listeners.add(listener);
	}

	/**
	 * ���������� ������� ��������.
	 * 
	 * @return ������� ��������
	 */
	public Maze getMaze() {
		return this.maze;
	}

	/**
	 * ���������� ���������� ������.
	 * 
	 * @return ��������� ������
	 */
	public static List<ModelListener> getListeners() {
		return listeners;
	}

	/**
	 * ���������� ����� ����.
	 * 
	 * @return ����� ����
	 */
	public static int getCellPathCount() {
		return cellPathCount;
	}

	/**
	 * ������������� ����� ����.
	 * 
	 * @param cellPathCount ����� ���� ��� ���������
	 */
	public static void setCellPathCount(int cellPathCount) {
		Model.cellPathCount = cellPathCount;
	}	
}
