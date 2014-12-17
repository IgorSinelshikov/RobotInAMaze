/**
 * SignsPathFinder
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost.uniform_cost_search;

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
 * Класс решателя лабиринта методом равных цен.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @see Solver
 */
public class UniformCostSearchSolver implements Solver {
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
	 * Решает лабиринт. 
	 * Описание алгоритма:
	 * <br>
	 * <code>
	 * procedure UniformCostSearch(Graph, root, goal)<br>
	 * node := root, cost = 0<br>
	 * frontier := priority queue containing node only<br>
	 * explored := empty set<br>
	 * do<br>
	 *   if frontier is empty<br>
	 *     return failure<br>
	 *   node := frontier.pop()<br>
	 *   if node is goal<br>
	 *     return solution<br>
	 *   explored.add(node)<br>
	 *   for each of node's neighbors n<br>
	 *     if n is not in explored<br>
	 *       if n is not in frontier<br>
	 *        frontier.add(n)<br>
	 *       else if n is in frontier with higher cost<br>
	 *        replace existing node with n<br>
	 * </code>   
	 */
	public void solve() {
		cellCount = 0;		
		List<Cell> queue = new ArrayList<Cell>();
		queue.add(cells[startNode.x][startNode.y]);
		while(!queue.isEmpty()){
			Collections.sort(queue, new Comparator<Cell>() {
				@Override
				public int compare(Cell o1, Cell o2) {
					return o1.cost>o2.cost?1:-1;
				}
			});
			Cell r = queue.remove(0);
			cellCount++;
			if (r.goal) {
				return;
			}
			double cost = 0;
			if(r.parent != null){
				cost = cells[r.parent.x][r.parent.y].cost+1;
			}
			visitedList.add(r);
			if (cells[r.current.x][r.current.y+1].value != 0 && !visitedList.contains(cells[r.current.x][r.current.y+1]) && !queue.contains(cells[r.current.x][r.current.y+1])) {
				cells[r.current.x][r.current.y+1].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x][r.current.y+1]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x, r.current.y+1);
				}
			} else if(cells[r.current.x][r.current.y+1].value != 0 && queue.contains(cells[r.current.x][r.current.y+1]) && cells[r.current.x][r.current.y+1].cost>cost){
				cells[r.current.x][r.current.y+1].cost = cost;
				cells[r.current.x][r.current.y+1].parent = new Pair(r.current.x, r.current.y);
			}
			if (cells[r.current.x+1][r.current.y].value != 0 && !visitedList.contains(cells[r.current.x+1][r.current.y]) && !queue.contains(cells[r.current.x+1][r.current.y])) {
				cells[r.current.x+1][r.current.y].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x+1][r.current.y]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x+1, r.current.y);
				}
			} else if(cells[r.current.x+1][r.current.y].value != 0 && queue.contains(cells[r.current.x+1][r.current.y]) && cells[r.current.x+1][r.current.y].cost>cost){
				cells[r.current.x+1][r.current.y].cost = cost;
				cells[r.current.x+1][r.current.y].parent = new Pair(r.current.x, r.current.y);
			}
			if (cells[r.current.x][r.current.y-1].value != 0 && !visitedList.contains(cells[r.current.x][r.current.y-1]) && !queue.contains(cells[r.current.x][r.current.y-1])) {
				cells[r.current.x][r.current.y-1].parent = new Pair(r.current.x, r.current.y);		
				queue.add(cells[r.current.x][r.current.y-1]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x, r.current.y-1);
				}
			} else if(cells[r.current.x][r.current.y-1].value != 0 && queue.contains(cells[r.current.x][r.current.y-1]) && cells[r.current.x][r.current.y-1].cost>cost){
				cells[r.current.x][r.current.y-1].cost = cost;
				cells[r.current.x][r.current.y-1].parent = new Pair(r.current.x, r.current.y);
			}
			if (cells[r.current.x-1][r.current.y].value != 0 && !visitedList.contains(cells[r.current.x-1][r.current.y]) && !queue.contains(cells[r.current.x-1][r.current.y])) {
				cells[r.current.x-1][r.current.y].parent = new Pair(r.current.x, r.current.y);
				queue.add(cells[r.current.x-1][r.current.y]);
				for (ModelListener listener: Model.getListeners()) {
					listener.cellTried(r.current.x-1, r.current.y);
				}
			} else if(cells[r.current.x-1][r.current.y].value != 0 && queue.contains(cells[r.current.x-1][r.current.y]) && cells[r.current.x-1][r.current.y].cost>cost){
				cells[r.current.x-1][r.current.y].cost = cost;
				cells[r.current.x-1][r.current.y].parent = new Pair(r.current.x, r.current.y);
			}

		}
	}
}
