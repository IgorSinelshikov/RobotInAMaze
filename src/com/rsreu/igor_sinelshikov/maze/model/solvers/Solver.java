/**
 * Solver
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;

/**
 * ��������� �������� ���������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public interface Solver {
	/**
	 * ���� �������� �����-����� � ���������.
	 * 
	 * @param maze ��������, � ������� ���������� ����� �����
	 * @return �������� � ��������� �����
	 */
	 Maze solve(Maze maze);
}
