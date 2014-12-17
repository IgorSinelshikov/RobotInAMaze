/**
 * Direction
 */
package com.rsreu.igor_sinelshikov.maze.view.swing;

/**
 * ����������� �������� �������.
 * �������� ���� �������� ����� ��������� �������� <code>RIGHT</code>, <code>LEFT</code>, 
 * <code>UP</code> and <code>DOWN</code>.
 *
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public enum Direction {
	/** ����������� �����. */
	UP(0,-1), 
	/** ����������� ����. */ 
	DOWN(0,1), 
	/** ����������� �����. */
	LEFT(-1,0), 
	/** ����������� ������. */
	RIGHT(1,0),
	/** ��� �����������. */
	NONE;
	
	/** X ���������� �����������. */
	private Integer x;
	/** Y ���������� �����������. */
	private Integer y;
	
	/**
	 * ����������� ������������ �����������.
	 * 
	 * @param x X ���������� �����������
	 * @param y Y ���������� �����������
	 */
	Direction(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * ����������� ������������ �����������.
	 */
	Direction() {	
	}

	/**
	 * ���������� X ���������� �����������
	 * 
	 * @return x X ���������� �����������
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * ���������� Y ���������� �����������
	 * 
	 * @return y Y ���������� �����������
	 */
	public Integer getY() {
		return y;
	}
}
