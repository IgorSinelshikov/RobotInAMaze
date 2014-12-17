/**
 * MazeGenerator.
 */
package com.rsreu.igor_sinelshikov.maze.model.maze;

import java.util.Random;
import java.util.Vector;

/**
 * Класс генератора лабиринта.
 * 
 * @author Игорь_Синельщиков
 * @version 1.01
 * @since 1.01
 */
public class MazeGenerator {
	/** Высота лабиринта. */
	private int height;
	/** Ширина лабиринта. */
	private int width;
	/** Объект поля лабиринта. */
	private int[][] maze;
	/** Генератор случайных чисел. */
	private Random myRandom = new Random();

	/**
	 * Строит лабиринт.
	 * 
	 * @param mazeWidth Ширина лабиринта
	 * @param mazeHeight Высота лабиринта
	 * @return Сконструированный лабиринт
	 */
	public Maze construct(int mazeWidth, int mazeHeight) {
		this.height = mazeHeight;
		this.width = mazeWidth;
		createMaze();
		Maze maze = new Maze(mazeWidth, mazeHeight);
		maze.setField(this.maze);
		return maze;
	}

	/**
	 *Создает новый лабиринт.
	 *
	 *<h5>Описание алгоритма</h5><br/>
	 *<br/>
	 *Замечание: мы предполагаем, что самая левая ячейка имеет границу слева, а самая правая — справа.<br/>
	 *<br/>
	 *<ol>
	 *<li>Создайте первую строку. Ни одна ячейка не будет являться частью ни одного множества.</li>
	 *<li>Присвойте ячейкам, не входящим в множество, свое уникальное множество.</li>
	 *<li>Создайте правые границы, двигаясь слева направо:<ol>
	 *<li>Случайно решите добавлять границу или нет <ol>
	 *<li>Если текущая ячейка и ячейка справа принадлежат одному множеству, то создайте границу между ними (для предотвращения зацикливаний)</li>
	 *<li>Если вы решили не добавлять границу, то объедините два множества в которых находится текущая ячейка и ячейка справа.</li>
	 *</ol></li>
	 *</ol></li>
	 *<li>Создайте границы снизу, двигаясь слева направо:<ul>
	 *<li>Случайно решите добавлять границу или нет. Убедитесь что каждое множество имеет хотя бы одну ячейку без нижней границы (для предотвращения изолирования областей)<ol>
	 *<li>Если ячейка в своем множестве одна, то не создавайте границу снизу</li>
	 *<li>Если ячейка одна в своем множестве без нижней границы, то не создавайте нижнюю границу</li>
	 *</ol></li>
	 *</ul></li>
	 *<li>Решите, будете ли вы дальше добавлять строки или хотите закончить лабиринт<ol>
	 *<li>Если вы хотите добавить еще одну строку, то:<ol>
	 *<li>Выведите текущую строку</li>
	 *<li>Удалите все правые границы</li>
	 *<li>Удалите ячейки с нижней границей из их множества</li>
	 *<li>Удалите все нижние границы</li>
	 *<li>Продолжайте с шага 2</li>
	 *</ol></li>
	 *<li>Если вы решите закончить лабиринт, то:<ol>
	 *<li>Добавьте нижнюю границу к каждой ячейке</li>
	 *<li>Двигаясь слева направо:<ol>
	 *<li>Если текущая ячейка и ячейка справа члены разных множеств, то:<ol>
	 *<li>Удалите правую границу</li>
	 *<li>Объедините множества текущей ячейки и ячейки справа</li>
	 *<li>Выведите завершающую строку</li>
	 *</ol></li>
	 *</ol></li>
	 *</ol></li>
	 *</ol></li>
	 *</ol><br/>
	 */
	private void createMaze() {
		this.maze = new int[this.width][this.height];
		for (int i = 1; i < maze.length - 1; i++) {
			for (int j = 1; j < maze[i].length - 1; j++) {
				if ((i + j) % 2 == 1) {
					maze[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < maze.length - 1; i += 2) {
			for (int j = 1; j < maze[i].length - 1; j += 2) {
				maze[i][j] = 3;
			}
		}
		Vector<int[]> possibleSquares = new Vector<int[]>(maze.length
				* maze[0].length);
		int[] startSquare = new int[2];
		startSquare[0] = getRandomInt(maze.length / 2) * 2 + 1;
		startSquare[1] = getRandomInt(maze[0].length / 2) * 2 + 1;
		maze[startSquare[0]][startSquare[1]] = 2;
		possibleSquares.addElement(startSquare);
		while (possibleSquares.size() > 0) {
			int chosenIndex = getRandomInt(possibleSquares.size());
			int[] chosenSquare = (int[]) possibleSquares.elementAt(chosenIndex);
			maze[chosenSquare[0]][chosenSquare[1]] = 1;
			possibleSquares.removeElementAt(chosenIndex);
			link(chosenSquare, possibleSquares);
		}
		possibleSquares = null;
		System.gc();
	}

	/**
	 * Проверяет окружающие клетки. Если они уже связаны с лабиринтом,
	 * то одна из них присоединяется к данной клетке. Клетки, которые
	 * ранее не были присоединены добавляются в лист возможных клеток
	 * (которые могут быть присоединены в следующей итерации).
	 * 
	 * @param chosenSquare Текущая клетка
	 * @param possibleSquares Множество возможных клеток
	 */
	private void link(int[] chosenSquare, Vector<int[]> possibleSquares) {
		int linkCount = 0;
		int i = chosenSquare[0];
		int j = chosenSquare[1];
		int[] links = new int[8];
		if (i >= 3) {
			if (maze[i - 2][j] == 1) {
				links[2 * linkCount] = i - 1;
				links[2 * linkCount + 1] = j;
				linkCount++;
			} else if (maze[i - 2][j] == 3) {
				maze[i - 2][j] = 2;
				int[] newSquare = new int[2];
				newSquare[0] = i - 2;
				newSquare[1] = j;
				possibleSquares.addElement(newSquare);
			}
		}
		if (j + 3 <= maze[i].length) {
			if (maze[i][j + 2] == 3) {
				maze[i][j + 2] = 2;
				int[] newSquare = new int[2];
				newSquare[0] = i;
				newSquare[1] = j + 2;
				possibleSquares.addElement(newSquare);
			} else if (maze[i][j + 2] == 1) {
				links[2 * linkCount] = i;
				links[2 * linkCount + 1] = j + 1;
				linkCount++;
			}
		}
		if (j >= 3) {
			if (maze[i][j - 2] == 3) {
				maze[i][j - 2] = 2;
				int[] newSquare = new int[2];
				newSquare[0] = i;
				newSquare[1] = j - 2;
				possibleSquares.addElement(newSquare);
			} else if (maze[i][j - 2] == 1) {
				links[2 * linkCount] = i;
				links[2 * linkCount + 1] = j - 1;
				linkCount++;
			}
		}
		if (i + 3 <= maze.length) {
			if (maze[i + 2][j] == 3) {
				maze[i + 2][j] = 2;
				int[] newSquare = new int[2];
				newSquare[0] = i + 2;
				newSquare[1] = j;
				possibleSquares.addElement(newSquare);
			} else if (maze[i + 2][j] == 1) {
				links[2 * linkCount] = i + 1;
				links[2 * linkCount + 1] = j;
				linkCount++;
			}
		}
		if (linkCount > 0) {
			int linkChoice = getRandomInt(linkCount);
			int linkX = links[2 * linkChoice];
			int linkY = links[2 * linkChoice + 1];
			maze[linkX][linkY] = 1;
			int[] removeSquare = new int[2];
			removeSquare[0] = linkX;
			removeSquare[1] = linkY;
			possibleSquares.removeElement(removeSquare);
		}
	}

	/**
	 * Утилита для генерации случайных чисел.
	 * 
	 * @param upper Верхняя граница генератора
	 * @return Случайное число
	 */
	public int getRandomInt(int upper) {
		int retVal = myRandom.nextInt() % upper;
		if (retVal < 0) {
			retVal += upper;
		}
		return (retVal);
	}
}