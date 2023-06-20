public class Main {
    /**
	 * Main method to execute program
     * @param args
     */
    public static void main(String args[]) {
        new Thread(new TestCases("map01.txt", 500, 500)).start(); 
		new Thread(new TestCases("Map02.txt", 500, 500)).start();
		new Thread(new TestCases("Map03.txt", 500, 500)).start();
		new Thread(new TestCases("Map04.txt", 500, 500)).start();
		new Thread(new TestCases("Map05.txt", 500, 500)).start();
		new Thread(new TestCases("Map06.txt", 500, 500)).start();
		new Thread(new TestCases("Map07.txt", 500, 500)).start();
		new Thread(new TestCases("Map08.txt", 500, 500)).start();
		new Thread(new TestCases("Map09.txt", 500, 500)).start();
		new Thread(new TestCases("Map10.txt", 500, 500)).start();
		new Thread(new TestCases("Tokyo.txt", 1000, 1000)).start();
		new Thread(new TestCases("Pisa.txt", 1000, 1000)).start();
		new Thread(new TestCases("Vatican.txt", 1000, 1000)).start();
		new Thread(new TestCases("Triumph.txt", 1000, 1000)).start();
    }
}


