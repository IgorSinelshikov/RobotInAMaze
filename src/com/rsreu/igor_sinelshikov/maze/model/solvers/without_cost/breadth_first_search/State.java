/**
 * State
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost.breadth_first_search;

/**
 * ����� ������� ������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class State {
	/** X ������� ������. */
	public int xPos;
	/** Y ������� ������. */
	public int yPos;
	/** ��������� �� ������. */
	public int dist;

	/**
	 * ����������� ������ ������� ������.
	 * 
	 * @param xPos X ������� ������
	 * @param yPos Y ������� ������
	 * @param dist ��������� �� ������
	 */
	public State(int xPos, int yPos, int dist) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.dist = dist;
	}
}