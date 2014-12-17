/**
 * DepthPathFinder
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.depth_first_search;

import com.rsreu.igor_sinelshikov.maze.model.Model;
import com.rsreu.igor_sinelshikov.maze.model.ModelListener;
import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;
import com.rsreu.igor_sinelshikov.maze.model.solvers.Solver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.Cell;

/**
 * ����� �������� ��������� ������� ������ � �������.
 *  
 * @author �����_�����������
 * @version 1.01
 * @see Solver
 */
public class DepthFirstSearchSolver implements Solver {
	/** ���� ���������. */
	private int[][] maze;
	/** ������ ��������� ������ ���������. */
	private Cell[][] field;
	/** ����� ��������������� ������. */
	private int cellCount = 0;
	/** ����� ��������������� ����. */
	private int cellPathCount = 0;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Maze solve(Maze maze) {
		long time = System.currentTimeMillis();

		int startRow = 0;
		int startColumn = 0;
		int endRow = 0;
		int endColumn = 0;
		for (ModelListener listener: Model.getListeners()) {
			listener.mazeGenerated(maze);
		}
		this.maze = maze.getField();
		this.field = new Cell[maze.getMazeWidth()][maze.getMazeHeight()];
		for (int i=0; i<maze.getMazeWidth(); i++) {
			for (int j=0; j<maze.getMazeHeight(); j++) {
				Cell cell = new Cell();
				cell.setValue(this.maze[i][j]);
				cell.setTried(false);
				field[i][j] = cell;
				if (this.maze[i][j] == 3) {
					startRow = i;
					startColumn = j;
				}
				if (this.maze[i][j] == 4) {
					endRow = i;
					endColumn = j;
				}
			}
		}
		solve(startRow, startColumn, false, false);
		time = System.currentTimeMillis() - time;
		for (ModelListener listener: Model.getListeners()) {
			listener.searchHappened(time, cellCount, cellPathCount);
		}
		this.maze[startRow][startColumn] = 3;
		this.maze[endRow][endColumn] = 4;
		maze.setField(this.maze);
		return maze;
	}

	/**
	 * ���� ���� � ���������. ��������� �������� �����������
	 * ���������� ������, �� � ����� ������ ���� �� �������� 
	 * ���� ���������.
	 * 
	 * @param maze ��������, � ������� ���������� ����� ����
	 */
	public void findPath(Maze maze) {	
		int startRow = 0;
		int startColumn = 0;
		int endRow = 0;
		int endColumn = 0;
		this.maze = maze.getField();
		this.field = new Cell[maze.getMazeWidth()][maze.getMazeHeight()];
		for (int i=0; i<maze.getMazeWidth(); i++) {
			for (int j=0; j<maze.getMazeHeight(); j++) {
				Cell cell = new Cell();
				cell.setValue(this.maze[i][j]);
				cell.setTried(false);
				field[i][j] = cell;
				if (this.maze[i][j] == 3) {
					startRow = i;
					startColumn = j;
				}
				if (this.maze[i][j] == 4) {
					endRow = i;
					endColumn = j;
				}
			}
		}
		solve(startRow, startColumn, true, false);
		for (int i=0; i < maze.getMazeWidth(); i++) {
			for (int j=0; j < maze.getMazeHeight(); j++) {
				if (field[i][j].getValue() == 2) {
					this.maze[i][j] = 2;
				} else {
					this.maze[i][j] = field[i][j].getValue();
				}	
			}
		}
		this.maze[startRow][startColumn] = 3;
		this.maze[endRow][endColumn] = 4;
		maze.setField(this.maze);
		Model.setCellPathCount(cellPathCount);
	}

	/**
	 * ������ �������� ����������� ���������� ������ � �������.
	 * 
	 * @param row ������� ���
	 * @param column ������� �������
	 * @param isPath ����� �� ���������� ����
	 * @param isCount ����� �� ��������� �����
	 * @return ������ �� ����
	 */
	public boolean solve(int row, int column, boolean isPath, boolean isCount) {
		boolean done = false;
		if (valid(row, column)) {
			cellCount++;
			if (!isPath) {
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(row, column);
				}
			}
			this.field[row][column].setTried(true);
			if (this.field[row][column].getValue()==4) {
				done = true; 
			} else {
				done = solve(row + 1, column, isPath, isCount); 
				if (!done) {
					done = solve(row, column + 1, isPath, isCount);
				}
				if (!done) {
					done = solve(row - 1, column, isPath, isCount); 
				}
				if (!done) {
					done = solve(row, column - 1, isPath, isCount);
				}
			}
			if (done) {
				cellPathCount++;
				if (!isCount && isPath) {
					this.field[row][column].setValue(2);
				}
			}
		}
		return done;  
	}

	/**
	 * ��������� ������ �� ����������.
	 * 
	 * @param row ������� ���
	 * @param column ������� �������
	 * @return �������� �� ������ ��������
	 */
	private boolean valid(int row, int column) {
		boolean result = false;
		if (row >= 0 && row < field.length && column >= 0 && column < field[row].length) {
			if (!field[row][column].isTried() && field[row][column].getValue() != 0) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * ������� ����� ����.
	 * 
	 * @param maze ��������
	 */
	@SuppressWarnings("unused")
	public void calculatePath(Maze maze) {
		int startRow = 0;
		int startColumn = 0;
		int endRow = 0;
		int endColumn = 0;
		this.maze = maze.getField();
		this.field = new Cell[maze.getMazeWidth()][maze.getMazeHeight()];
		for (int i=0; i<maze.getMazeWidth(); i++) {
			for (int j=0; j<maze.getMazeHeight(); j++) {
				Cell cell = new Cell();
				cell.setValue(this.maze[i][j]);
				cell.setTried(false);
				field[i][j] = cell;
				if (this.maze[i][j] == 3) {
					startRow = i;
					startColumn = j;
				}
				if (this.maze[i][j] == 4) {
					endRow = i;
					endColumn = j;
				}
			}
		}
		solve(startRow, startColumn, true, true);
		Model.setCellPathCount(cellPathCount);
	}
}
