/**
 * Solver
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers;

import com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost.best_first_search.BestFirstSearchSolver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost.uniform_cost_search.UniformCostSearchSolver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.breadth_first_search.BreadthFirstSearchSolver;
import com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.depth_first_search.DepthFirstSearchSolver;

/**
 * ����� ����������� ������� ��������� ���������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public abstract class SolverFactory {
	/** ��������� � ������������ ���� ������. */
	private static final String ILLEGAL_METHOD_TYPE_MESSAGE = "Incorrect method type.";

	/**
	 * ��������� ������ ������� ��������� � �����������
	 * �� ���������� ����.
	 * 
	 * @param type ��� ��������
	 * @return ������ ��������
	 */
	public static Solver getInstance(SolverType type) {
		switch(type) {
		case DEPTH_FIRST_SEARCH:
			return new DepthFirstSearchSolver();
		case BREADTH_FIRST_SEARCH: 
			return new BreadthFirstSearchSolver();
		case UNIFORM_COST_SEACRH:
			return new UniformCostSearchSolver();
		case BEST_FIRST_SEARCH:
			return new BestFirstSearchSolver();
		default:
			throw new IllegalArgumentException(ILLEGAL_METHOD_TYPE_MESSAGE);
		}
	}
}
