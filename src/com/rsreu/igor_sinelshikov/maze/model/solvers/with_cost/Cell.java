/**
 * Cell
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.with_cost;

/**
 * ����� ������� ��� ������ ���� ���������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class Cell {
	/** ���� ��������� ��������������� ������. */
	public Pair parent;
	/** ���� ��������� ������� ������. */
	public Pair current;
	/** ���� ������. */
	public double cost;
	/** �������� ������. */
	public int value;
	/** �������� �� ������ ������� �� ���������. */
	public boolean goal;
	/** ���� ������ � ��������� �� ������� ���������� ����������. */
	public double bfsCost;
	
	/**
	 * ����������� ������ ������� ������ ���������.
	 * 
	 * @param x ���������� X ������
	 * @param y ���������� Y ������
	 */
	public Cell(int x, int y){
		this.current = new Pair(x, y);
		cost = 0;
		value = 0;
		goal = false;
		bfsCost = Math.sqrt((Math.pow((x), 2)+Math.pow((y), 2)));
	}
}
