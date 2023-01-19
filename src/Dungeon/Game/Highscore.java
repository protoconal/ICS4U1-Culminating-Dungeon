// package Dungeon.Game;

// import java.io.*;
// import java.util.Scanner;

// public class Highscore {

//   public static void Highscore(String[] args) throws IOException {
//     Lesson.run();
//   }

// public static int getAge(int Line, String file) throws IOException {

//     String string = "";
//     int finalString = -1;
//     BufferedReader inputStream = null;

//     try {
// 			inputStream = new BufferedReader(new FileReader(file));


// 			for (int i = 0; i < Line - 1; i++) {
//         inputStream.readLine();
//       }


//     string = inputStream.readLine();
//       if (string != null) {
//         finalString = Integer.parseInt(string.substring(string.length() - 12, string.length() - 10));
//       } else {
//         finalString = -1;
//       }


// 		}


// 		catch (IOException e) {
// 			System.out.println("There was an IOException thrown");
// 		}
// 		finally {
// 			if (inputStream != null) {
// 				inputStream.close();
// 			} 
// 		}


//     return finalString;
//   }

// }