import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PenguinInfo {
	static final String FOOD = "FOOD";
	static final String WEIGHT = "WEIGHT";
	static final String HEIGHT = "HEIGHT";
	static final String MUSIC = "MUSIC";
	static final String POET = "POET";

	static String penguinInfo(List<Penguin> penguins, String sort){
		Penguin[] pengs = new Penguin[penguins.size()];
		for (int i = 0; i < penguins.size(); ++i) {
			pengs[i] = penguins.get(i);
			pengs[i].sortType = sort;
		}
		Arrays.sort(pengs);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < pengs.length; ++i) {
			if (i != 0) {
				builder.append(" ");
			}
			builder.append(pengs[i].getName());
		}
		return builder.toString();
	}

	//Class which represents Penguins
	static public class Penguin implements Comparable<Penguin> {
		final String name;
		final String favoriteFood;
		final double weight;
		final double height;
		final String musicalArtist;
		final String poet;		
		
		public String sortType;
		
		public Penguin(String name, String favoriteFood, double weight,
				double height, String musicalArtist, String poet){
			this.name = name;
			this.favoriteFood = favoriteFood;
			this.weight = weight;
			this.height = height;
			this.musicalArtist = musicalArtist;
			this.poet = poet;
		}

		public String getName() {
			return name;
		}

		public String getFavoriteFood() {
			return favoriteFood;
		}

		public double getWeight() {
			return weight;
		}

		public double getHeight() {
			return height;
		}

		public String getMusicalArtist() {
			return musicalArtist;
		}

		public String getPoet() {
			return poet;
		}

		public String toString() {
			return name;
		}

		@Override
		public int compareTo(Penguin arg0) {
			if (sortType.equals(FOOD)) {
				return getFavoriteFood().compareTo(arg0.getFavoriteFood());
			} else if (sortType.equals(WEIGHT)) {
				return new Double(getWeight()).compareTo(arg0.getWeight());
			} else if (sortType.equals(HEIGHT)) {
				return new Double(getHeight()).compareTo(arg0.getHeight());
			} else if (sortType.equals(MUSIC)) {
				return getMusicalArtist().compareTo(arg0.getMusicalArtist());
			} else if (sortType.equals(POET)) {
				return getPoet().compareTo(arg0.getPoet());
			}
			return 0;
		}

	}


	//main method for reading input for text files
	//--------------------------------------
	//Format for text files:
	//END OF PROBLEM
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("PenguinInfoIN.txt"));
		//Scanner in = new Scanner(new File("/Users/alex/Downloads/questions/PenguinInfoIN.txt"));
		List<Penguin> penguins = new LinkedList<Penguin>();
		while(in.hasNext()){
			String next = in.nextLine();
			while(!next.equals("*****")){
				penguins.add(new Penguin(next,in.nextLine(),Double.parseDouble(in.nextLine()),Double.parseDouble(in.nextLine()),in.nextLine(),in.nextLine()));
				next = in.nextLine();
			}
			System.out.println(penguinInfo(penguins,in.next()));
			penguins.clear();
			if(in.hasNext()){
				in.nextLine();
			}
		}
	}
}
