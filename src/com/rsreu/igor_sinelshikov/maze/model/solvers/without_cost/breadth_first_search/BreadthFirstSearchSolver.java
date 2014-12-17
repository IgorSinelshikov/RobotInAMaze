/**
 * WidthPathFinder
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.rsreu.igor_sinelshikov.maze.model.Model;
import com.rsreu.igor_sinelshikov.maze.model.ModelListener;
import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;
import com.rsreu.igor_sinelshikov.maze.model.solvers.Solver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.Cell;

/**
 * Класс решателя лабиринта методом поиска в ширину.
 * 
 * @author Игороь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class BreadthFirstSearchSolver implements Solver {
	/** Ряд начала лабиринта. */
	private int startRow; 
	/** Сотлбец начала лабиринта. */
	private int startColumn;
	/** Текущее поле лабиринта. */
	private int[][] maze;
	/** Время выполнения. */
	private long time;
	/** Число сгенерированных вершин. */
	private int cellCount;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Maze solve(Maze maze) {
		for (ModelListener listener: Model.getListeners()) {
			listener.mazeGenerated(maze);
		}
		this.maze = maze.getField();
		Cell[][] cells = new Cell[maze.getMazeWidth()][maze.getMazeHeight()];
		for (int i=0; i < maze.getMazeWidth(); i++) {
			for (int j=0; j < maze.getMazeHeight(); j++) {
				if (this.maze[i][j] == 3) {
					this.startRow = i;
					this.startColumn = j;
				}
				Cell cell = new Cell();
				cell.setValue(this.maze[i][j]);
				cell.setTried(false);
				cells[i][j] = cell;
			}
		}
		State source = new State(this.startRow, this.startColumn, 0);
		time = System.currentTimeMillis();
		search(cells, source);
		long finish = System.currentTimeMillis();
		time = finish - time;
		for (ModelListener listener: Model.getListeners()) {
			listener.searchHappened(time, cellCount, Model.getCellPathCount());
		}
		return maze;
	}

	/**
	 * Находит путь в лабиринте методом поиска в ширину.
	 * 
	 * @param cells Поле, в котором нужно найти путь
	 * @param x Стартовая позиция X
	 * @param y Стартовая позиция Y
	 * @param source Текущая позиция
	 * @return Найден ли путь
	 */
	public int search(Cell[][] cells, State source) {	
		Queue<State> Q = new LinkedList<State>();
		Q.offer(source);
		cells[source.xPos][source.yPos].setTried(true);
		while (Q.peek() != null) {
			cellCount++;
			State current = Q.poll();	
			ArrayList<State> neighbors = getNeighbors(cells, current);
			for (State neighbor : neighbors) {
				if (cells[neighbor.xPos][neighbor.yPos].getValue() == 4) {
					return neighbor.dist;
				}
				Q.offer(neighbor);
				cells[neighbor.xPos][neighbor.yPos].setTried(true);
				for (ModelListener listener: Model.getListeners()) {
						listener.cellTried(neighbor.xPos, neighbor.yPos);
				}
			}
		}
		return 0;
	}

	/**
	 * Добавляет в список соседей клетки, которые являются
	 * граничными с текущей и отвечают требованиям валидности(не стена).
	 * 
	 * @param cells Поле лабиринта
	 * @param current Текущее положение
	 * @return Список соседей клетки
	 */
	public ArrayList<State> getNeighbors(Cell[][] cells, State current) {
		ArrayList<State> neighbors = new ArrayList<State>();
		if (current.yPos > 0 && cells[current.xPos][current.yPos-1].getValue() != 0 && !cells[current.xPos][current.yPos-1].isTried()) {
			neighbors.add(new State(current.xPos, current.yPos-1, current.dist+1));
		}
		if (current.xPos < cells.length-1 && cells[current.xPos+1][current.yPos].getValue() != 0 && !cells[current.xPos+1][current.yPos].isTried()) {
			neighbors.add(new State(current.xPos+1, current.yPos, current.dist+1));
		}
		if (current.yPos < cells[0].length-1 && cells[current.xPos][current.yPos+1].getValue() != 0 && !cells[current.xPos][current.yPos+1].isTried()) {
			neighbors.add(new State(current.xPos, current.yPos+1, current.dist+1));
		}
		if (current.xPos > 0 && cells[current.xPos-1][current.yPos].getValue() != 0 && !cells[current.xPos-1][current.yPos].isTried()) {
			neighbors.add(new State(current.xPos-1, current.yPos, current.dist+1));
		}
		return neighbors;
	}
}
