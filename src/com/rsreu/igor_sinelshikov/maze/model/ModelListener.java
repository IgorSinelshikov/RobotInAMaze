/**
 * ModelListener
 */
package com.rsreu.igor_sinelshikov.maze.model;

import com.rsreu.igor_sinelshikov.maze.model.maze.Maze;

/**
 * ��������� ��������� ������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public interface ModelListener {
	/**
	 * ��������� ��������, ����� �������� ��������� �������.
	 * 
	 * @param time ����� ����������
	 * @param cellCount ����� ��������������� ����
	 * @param cellPathCount ���������� ��������������� ������
	 */
	void searchHappened(long time, int cellCount, int cellPathCount);
	
	/**
	 * ��������� ��������, ����� �������� ���
	 * ������������ � ��� ���������� ����������� ������������.
	 * 
	 * @param maze ��������������� ��������
	 */
	void mazeGenerated(Maze maze);

	/**
	 * ��������� ��������, ����� ������������ ��������� ��������.
	 * 
	 * @param oldX ������ X �������
	 * @param oldY ������ Y �������
	 * @param newX ����� X �������
	 * @param newY ����� Y �������
	 */
	void userMoved(int oldX, int oldY, int newX, int newY);

	/**
	 * ��������� ��������, ����� ������ ��������� ����
	 * �������� ���������.
	 * 
	 * @param yPos Y ������� ������
	 * @param xPos X ������� ������
	 */
	void cellTried(int xPos, int yPos);
}
