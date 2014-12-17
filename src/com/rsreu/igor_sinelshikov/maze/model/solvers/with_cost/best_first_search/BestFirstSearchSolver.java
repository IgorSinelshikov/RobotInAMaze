/**
 * BestFirstSearchSolver
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost.best_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rsreu.igor_sinelshikov.maze.model.Model;
import com.rsreu.igor_sinelshikov.maze.model.ModelListener;
import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;
import com.rsreu.igor_sinelshikov.maze.model.solvers.Solver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost.Cell;
import com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost.Pair;

/**
 * Класс решателя методом наилучшего первого совпадения.
 * 
 * @author Игорь_синельщиков
 * @version 1.01
 * @see Solver
 */
public class BestFirstSearchSolver implements Solver {
	/** Массив обернутых клеток поля лабиринта. */
	private Cell[][] cells;
	/** Список посещенных узлов. */
	protected List<Cell> visitedList = new ArrayList<Cell>();
	/** Пара координат стартовой позиции в лабиринте. */
	protected Pair startNode;
	/** Время выполнения. */
	private long time;
	/** Число сгенерированных вершин. */
	private int cellCount;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Maze solve(Maze maze) {
		cells = new Cell[maze.getMazeWidth()][maze.getMazeHeight()];
		for (int i=0; i < maze.getMazeWidth(); i++) {
			for (int j=0; j < maze.getMazeHeight(); j++) {
				Cell cell = new Cell(i, j);
				cell.value = maze.getField()[i][j];
				if (maze.getField()[i][j] == 4) {
					cell.goal = true;
				}
				if (maze.getField()[i][j] == 3) {
					startNode = new Pair(i, j);
				}
				cells[i][j] = cell;
			}
		}	
		time = System.currentTimeMillis();
		solve();
		long finish = System.currentTimeMillis();
		time = finish - time;
		for (ModelListener listener: Model.getListeners()) {
			listener.searchHappened(time, cellCount, Model.getCellPathCount());
		}
		return maze;
	}
	
	/**
	 * Решает лабиринт методом первого наилучшего совпадения.
	 */
	public void solve() {
		cellCount = 0;
		List<Cell> queue = new ArrayList<Cell>();
		queue.add(cells[startNode.x][startNode.y]);
		while(!queue.isEmpty()) {
			cellCount++;
			Collections.sort(queue, new Comparator<Cell>() {
				/**
				 * {@inheritDoc}
				 */
				@Override
				public int compare(Cell o1, Cell o2) {
					return o1.bfsCost>o2.bfsCost?1:-1;
				}
			});
			Cell r = queue.remove(0);
			if (r.goal) {
				return;
			}
			visitedList.add(r);
			if (cells[r.current.x][r.current.y+1].value != 0 && !visitedList.contains(cells[r.current.x][r.current.y+1]) && !queue.contains(cells[r.current.x][r.current.y+1])) {
				cells[r.current.x][r.current.y+1].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x][r.current.y+1]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x, r.current.y+1);
				}
			}
			if (cells[r.current.x+1][r.current.y].value != 0 && !visitedList.contains(cells[r.current.x+1][r.current.y]) && !queue.contains(cells[r.current.x+1][r.current.y])) {
				cells[r.current.x+1][r.current.y].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x+1][r.current.y]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x+1, r.current.y);
				}
			}
			if (cells[r.current.x][r.current.y-1].value != 0 && !visitedList.contains(cells[r.current.x][r.current.y-1]) && !queue.contains(cells[r.current.x][r.current.y-1])) {
				cells[r.current.x][r.current.y-1].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x][r.current.y-1]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x, r.current.y-1);
				}
			}
			if (cells[r.current.x-1][r.current.y] .value != 0 && !visitedList.contains(cells[r.current.x-1][r.current.y]) && !queue.contains(cells[r.current.x-1][r.current.y])) {
				cells[r.current.x-1][r.current.y].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x-1][r.current.y]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x-1, r.current.y);
				}
			}
		}
	}
}
