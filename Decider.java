import java.util.Random;
import java.util.Scanner;
import java.io.*;

/*
    Jason Griffith
	Helps decide what game should be played
	List based on multiplayer games Ed and I share
*/

public class Decider
{
	
	// node for linked list
	private static class Node//(String game, Node next)
	{
	    private String game;
	    private Node next;
		//this.game = game;
		//this.next = next;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		// root of linked list
		Node root;
		int count = 0;
		
		File file = new File("C:\\Users\\Donut\\Desktop\\Test Project\\programs\\game_list.txt");
		try (Scanner scan = new Scanner(file);)
		{
			root = new Node(); // root does not change until picking game
			root.game = scan.next();
			count++;
			Node last = root; // for keeping track
			while (scan.hasNext())
			{
				count++;
				//Node temp = new Node(scan.next(), null);
				Node temp = new Node();
				temp.game = scan.next();
				last.next = temp;
				last = temp;
			}
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("No file found");
			return;
		}
		
		Random rand = new Random();
		int n = rand.nextInt(count);
		
		for (int i = 0; i < n; i++)
		{
			root = root.next;
		}
		
		System.out.println(root.game);
	}
}