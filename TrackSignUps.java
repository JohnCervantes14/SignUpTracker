import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
public class TrackSignUps {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> signUps = readFile("signups.txt");
		ArrayList<String> members = readFile("members.txt");
		HashMap<String, Integer> map = mapSignUps(signUps);
		
		for(Entry<String,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue() + " slots");
		}
		System.out.println();
		System.out.println(map.size() + " bros signed up");
		System.out.println();
		System.out.println("bros who didn't sign up:");
		for(String name : members) {
			if(!map.containsKey(name)) {
				System.out.print(name + " ");
			}
		}
		System.out.println();
	}
	
	private static ArrayList<String> readFile(String filename) throws FileNotFoundException {
		ArrayList<String> signUps = new ArrayList<>();
		Scanner temp = new Scanner(new File(filename));
		while(temp.hasNextLine()) {
			signUps.add(temp.nextLine());
		}
		return signUps;
	}
	
	private static HashMap<String, Integer> mapSignUps(ArrayList<String> list){
		HashMap<String, Integer> map = new HashMap<>();
		map.put(list.get(0), 0);
		for(String name : list) {
			if(map.containsKey(name)) {
				map.put(name, map.get(name)+1);
			}
			else {
				map.put(name, 1);
			}
		}
		
		return map;
		
	}
	

}
