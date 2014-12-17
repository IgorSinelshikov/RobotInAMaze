/**
 * Solver
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;

/**
 * Интерфейс решателя лабиринта.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public interface Solver {
	/**
	 * Ищет конечную точку-выход в лабиринте.
	 * 
	 * @param maze Лабиринт, в котором необходимо найти выход
	 * @return Лабиринт с найденным путем
	 */
	 Maze solve(Maze maze);
}
