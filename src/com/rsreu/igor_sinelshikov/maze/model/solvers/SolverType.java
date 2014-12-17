/**
 * SolverType 
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers;

/**
 * ������������ ����� ���������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public enum SolverType {
	/** ����� ������ � �������. */
	DEPTH_FIRST_SEARCH,
	/** ����� ������ � ������. */
	BREADTH_FIRST_SEARCH,
	/** ����� ������ ���. */
	UNIFORM_COST_SEACRH,
	/** ����� ������ �� ������� ���������� ����������. */
	BEST_FIRST_SEARCH;
}
