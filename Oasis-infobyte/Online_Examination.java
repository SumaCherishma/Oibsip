import java.util.Scanner;

class User {
	String username;
	String password;
	
	User(String username, String password){
		this.username = username;
		this.password = password;
	}
}

class Question {
	String question;
	String[] options;
	int correctAnswer;
	
	Question(String question, String[] options, int correctAnswer){
		this.question=question;
		this.options=options;
		this.correctAnswer=correctAnswer;
	}
}

public class Online_Examination {
	
	static Scanner sc = new Scanner(System.in);
	static int score = 0;
	static long examTimeLimit = 30;

	public static void main(String[] args) {
		
		User user = new User("admin","1234");
		
		//Login
		System.out.println("************* ONLINE EXAMINATION SYSTEM **************");
		System.out.print("Enter Username: ");
		String u = sc.nextLine();
		
		System.out.print("Enter Password:");
		String p = sc.nextLine();
		
		if(!u.equals(user.username) || !p.equals(user.password)) {
			System.out.println("Invalid login. Exiting..");
			return;
		}
		
		System.out.println("\nLogin successful!\n");
		
		while(true) {
			System.out.println("\n===MENU===");
			System.out.println("1.Update Profile/Password");
			System.out.println("2. Start exam");
			System.out.println("3. Logout");
			System.out.println("Choose option: ");
			int choice= sc.nextInt();
			sc.nextLine();
			
			if(choice == 1) {
				updateProfile(user);
				startExam();
			}
			else if(choice ==2) {
				startExam();
			}
			else if(choice == 3) {
				System.out.println("Logged out successfully.");
				break;
			}else {
				System.out.println("Invalid choice.");
			}
		}
	}
	//update profile
	static void updateProfile(User user) {
		System.out.println("Enter new username: ");
		user.username = sc.nextLine();
		System.out.println("Enter new password: ");
		user.password = sc.nextLine();
		System.out.println("Profile updated successfully.");
	}
		
		//Start exam
		static void startExam() {
			score = 0;
		
		//Questions
		Question[] questions= {
				new Question(
					"1. What is Java?",
					new String[] {"Programming Language", "Database", "OS", "Browser"},
					1
					),
				new Question(
						"2. Which concept is not a part of OOP?",
						new String[] {"Encapsulation","Inheritance","Compilation","Polymorphism"},
						3
						),
				new Question(
						"3. Which keyword is used to create object?",
						new String[] {"class", "new", "this", "object"},
						2
						),
				new Question(
						"4. Which loop is entry controlled?",
						new String[] {"do-While","for", "none","infinite"},
						2
						),
				new Question(
						"5. JVM stands for?",
						new String[] {"Java Virtual Machine", "Java Variable Method", "Joint VM", "None"},
						1
						)
		};
		long startTime = System.currentTimeMillis();
		
		//Exam
		for(Question q:questions) {
			long currentTime = System.currentTimeMillis();
			if((currentTime - startTime)/ 1000 >= examTimeLimit) {
				System.out.println("\nTime up! Auto submitting exam..");
				break;
			}
			askQuestion(q);
		}
		showResult(questions.length);
		System.exit(0);
		}
		
		static void askQuestion(Question q) {
			System.out.println("\n"+ q.question);
			for(int i=0;i<q.options.length; i++) {
				System.out.print((i+1) +". " +q.options[i]+" ");
			}
			
			System.out.print("\nEnter your answer (1-4):");
			int answer = sc.nextInt();
			
			if(answer == q.correctAnswer) {
				score++;
			}
		}
		
		//Result
		static void showResult(int total) {
		System.out.println("\n========= Result ==========");
		System.out.println("Score: " + score + "/" + total);
		
		if (score >= 3) {
			System.out.println("Status: PASS");
		}else {
			System.out.println("Status: FAIL");
		}
		System.out.println("Thank you for attending the exam.");
				
	}

}
