
//import java.awt.*;  
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;

class OnlineTest extends JFrame implements ActionListener {
	JLabel l;

	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	OnlineTest() {

		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Ashik\\Desktop\\diu.jpg")))));

		} catch (IOException e) {
			System.out.println("Image Doesn't Exist");
		}
		// super(s);
		l = new JLabel();

		add(l);
		l.setBackground(Color.orange);
		l.setForeground(Color.black);
		l.setOpaque(true);
		l.setFont(new Font("Georgia Bold", Font.ITALIC, 16));
		
		setTitle("ALGORITHM MCQ TEST");

		bg = new ButtonGroup();

		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1 = new JButton("Next");
		b1.setBackground(Color.PINK);
		b2 = new JButton("Bookmark");
		b2.setBackground(Color.red);
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		set();
		l.setBounds(30, 40, 850, 20);
		l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jb[0].setBounds(50, 80, 100, 20);

		jb[1].setBounds(50, 110, 100, 20);
		jb[2].setBounds(50, 140, 100, 20);
		jb[3].setBounds(50, 170, 100, 20);
		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
		setResizable(false);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			// System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this, "correct ans=" + count);
			System.exit(0);
		}
	}

	void set() {
		jb[4].setSelected(true);
		if (current == 0) {
			l.setText("Que1: push() and pop() functions are found in?");
			jb[0].setText("queues");
			jb[1].setText("lists");
			jb[2].setText("stacks");
			jb[3].setText("trees");
		}
		if (current == 1) {
			l.setText("Que2: Quick sort algorithm is an example of-");
			jb[0].setText("Greedy Approach");
			jb[1].setText("Binary Search");
			jb[2].setText("Dynamic Programming");
			jb[3].setText("Divide & Conquer");
		}
		if (current == 2) {
			l.setText("Que3: Stack is used for - ");
			jb[0].setText("CPU  Resource Allocation");
			jb[1].setText("BFS");
			jb[2].setText("Recursion");
			jb[3].setText("DFS");
		}
		if (current == 3) {
			l.setText("Que4: After each iteration in bubble sort-");
			jb[0].setText("at least one element is sorted");
			jb[1].setText("no element is sorted");
			jb[2].setText("both are true");
			jb[3].setText("none of them are true");
		}
		if (current == 4) {
			l.setText("Que5: Quick sort running time depends on- ");
			jb[0].setText("size of array");
			jb[1].setText("Pivot element");
			jb[2].setText("sequence of values");
			jb[3].setText("none");
		}
		if (current == 5) {
			l.setText("Que6: Measures for the efficiency of an algorithm-");
			jb[0].setText("Processor and memory");
			jb[1].setText("Complexity and capacity");
			jb[2].setText("Time and space");
			jb[3].setText("Data and space");
		}
		if (current == 6) {
			l.setText("Que7: ----- is not the component of data structure ");
			jb[0].setText("Operations");
			jb[1].setText("Storage Structures");
			jb[2].setText("Algorithms");
			jb[3].setText("None of above");
		}
		if (current == 7) {
			l.setText("Que8: ----- is an application of stack?");
			jb[0].setText("finding factorial");
			jb[1].setText("tower of Hanoi");
			jb[2].setText("infix to postfix conversion");
			jb[3].setText("all of the above");
		}
		if (current == 8) {
			l.setText("Que9: which one is best data structure?");
			jb[0].setText("Array");
			jb[1].setText("Linked List");
			jb[2].setText("Both of the Above");
			jb[3].setText("None of the above");
		}
		if (current == 9) {
			l.setText("Que10: In linked list, Start == NULL means ");
			jb[0].setText("underflow");
			jb[1].setText("overflow");
			jb[2].setText("housefull");
			jb[3].setText("saturated");
		}
		l.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			jb[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (jb[2].isSelected());
		if (current == 1)
			return (jb[3].isSelected());
		if (current == 2)
			return (jb[2].isSelected());
		if (current == 3)
			return (jb[0].isSelected());
		if (current == 4)
			return (jb[1].isSelected());
		if (current == 5)
			return (jb[2].isSelected());
		if (current == 6)
			return (jb[3].isSelected());
		if (current == 7)
			return (jb[3].isSelected());
		if (current == 8)
			return (jb[0].isSelected());
		if (current == 9)
			return (jb[0].isSelected());
		return false;
	}

	public static void main(String s[]) {

		new OnlineTest();
	}
}
