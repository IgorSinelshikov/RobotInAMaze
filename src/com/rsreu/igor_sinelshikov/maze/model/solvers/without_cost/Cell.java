/**
 * CellWrapper
 */
package com.rsreu.igor_sinelshikov.maze.model.solvers.without_cost;

/**
 * �����-������� ������ ���� ���������, ������������ � ����������
 * ������ ���� ������� ������ � ������� � ������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class Cell {
	/** �������� ������. */
	private int value;
	/** ����, ������������ �������� �� �������� ������. */
	private boolean isTried;
	
	/**
	 * ���������� �������� ������.
	 * 
	 * @return �������� ������
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * ������ ������� ������.
	 * 
	 * @param value �������� ������
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * ���������� ����, ������������ �������� �� ��������
	 * ������ ������.
	 * 
	 * @return ����, ������������ �������� �� ��������
	 * ������ ������
	 */
	public boolean isTried() {
		return isTried;
	}
	
	/**
	 * ������ ����, ������������ �������� �� ��������
	 * ������ ������
	 * 
	 * @param isTried ����, ������������ �������� �� ��������
	 * ������ ������
	 */
	public void setTried(boolean isTried) {
		this.isTried = isTried;
	}
}
