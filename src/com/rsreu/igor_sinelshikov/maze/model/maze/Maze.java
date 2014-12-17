/**
 * Maze
 */
package com.rsreu.igor_sinelshikov.maze.model.maze;

/**
 * ����� �������� ������� - ���������.
 * 
 * @author �����_�����������
 * @version 1.01
 */
public class Maze {
	/** ������ ��������� �� ���������. */
	private static final int DEFAULT_WIDTH = 40;
	/** ������ ��������� �� ���������. */
	private static final int DEFAULT_HEIGHT = 40;
	/** ���� ���������. */
	private int[][] mazeField;
	/** ������ ���������. */
	private int mazeWidth;
	/** ������ ���������. */
	private int mazeHeight;
	
	/**
	 * ����������� ������ ���������.
	 */
	public Maze() {
		this.mazeWidth = DEFAULT_WIDTH;
		this.mazeHeight = DEFAULT_HEIGHT;
		this.mazeField = new int[this.mazeWidth][this.mazeHeight];
	}
	
	/**
	 * ����������� ������ ���������.
	 * 
	 * @param mazeWidth ������ ���������
	 * @param mazeHeight ������ ���������
	 * 
	 */
	public Maze(int mazeWidth, int mazeHeight) {
		this.mazeWidth = mazeWidth;
		this.mazeHeight = mazeHeight;
		this.mazeField = new int[mazeWidth][mazeHeight];
	}

	/**
	 * ���������� ���� ���������.
	 * 
	 * @return ���� ���������
	 */
	public int[][] getField() {
		return mazeField;
	}

	/**
	 * ������������� ���� ���������.
	 * 
	 * @param mazeField ���� ��������� ��� ���������
	 */
	public void setField(int[][] mazeField) {
		this.mazeField = mazeField;
	}	
	
	/**
	 * ���������� ������ ���������.
	 * 
	 * @return ������ ���������
	 */
	public int getMazeWidth() {
		return this.mazeWidth;
	}

	/**
	 * ���������� ������ ���������.
	 * 
	 * @return ������ ���������
	 */
	public int getMazeHeight() {
		return this.mazeHeight;
	}
}
