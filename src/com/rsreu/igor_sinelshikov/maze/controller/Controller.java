/**
 * Controller
 */
package com.rsreu.igor_sinelshikov.maze.controller;

import com.rsreu.igor_sinelshikov.maze.model.Model;
import com.rsreu.igor_sinelshikov.maze.model.solvers.SolverType;
import com.rsreu.igor_sinelshikov.maze.view.Viewer;
import com.rsreu.igor_sinelshikov.maze.view.swing.Direction;

/**
 * ���������� ����������.
 * 
 * @author �����_�����������
 * @version 1.01
 * @since 1.01
 */
public class Controller {
	/** ������ ����������. */
	private Model model;
	/** ������������� �����������. */
	private Viewer viewer;
	
	/**
	 * ����������� ������ �����������.
	 * 
	 * @param model ������ ����������
	 * @param viewer ������������� ����������
	 */
	public Controller(Model model, Viewer viewer) {
		this.setModel(model);
		this.viewer = viewer;
	}

	/**
	 * ����������� ������ �����������.
	 */
	public Controller() {
	}

	/**
	 * ���������� ������ �����������.
	 * 
	 * @return ������ �����������
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * ������������� ������ �����������.
	 * 
	 * @param model ������ ����������� ��� ���������
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * ���������� ������������� �����������.
	 * 
	 * @return ������������� �����������
	 */
	public Viewer getViewer() {
		return viewer;
	}

	/**
	 * ������������� ������������� �����������.
	 * 
	 * @param viewer ������������� ����������� ��� ���������
	 */
	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * ��������� ��������, ����� ���������� ������� ��������� ���������
	 * 
	 * @param mazeWidth ������ ���������
	 * @param mazeHeight ������ ���������
	 */
	public void generateMaze(int mazeWidth, int mazeHeight) {
		this.model.generateMaze(mazeWidth, mazeHeight);
	}

	/**
	 * ��������� ��������, ����� ���������� ����� ���� � ���������.
	 * 
	 * @param type ��� �������� ���������
	 */
	public void findPath(SolverType type) {
		this.model.findPath(type, this.model.getMaze());
	}
	
	/**
	 * ��������� ��������, ����� ������������ ���������.
	 * 
	 * @param direction ����������� ��������
	 */
	public void userMoved(Direction direction) {
		this.model.userMoved(direction);
	}
}
