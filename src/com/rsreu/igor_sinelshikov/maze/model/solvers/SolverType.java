/**
 * SolverType 
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers;

/**
 * Перечисление типов решателей.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public enum SolverType {
	/** Метод поиска в глубину. */
	DEPTH_FIRST_SEARCH,
	/** Метод поиска в ширину. */
	BREADTH_FIRST_SEARCH,
	/** Метод равных цен. */
	UNIFORM_COST_SEACRH,
	/** Метод поиска по первому наилучшему совпадению. */
	BEST_FIRST_SEARCH;
}
