package pthu.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject {

	private int id;
	private String code;
	private String name;
	private int difficulty;

	public Subject(int id, String code, String name, int difficulty) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.difficulty = difficulty;
	}

	public static List<Subject> readSubjectsFromFile(String fileName) {
		List<Subject> subjects = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\\s+");
				int id = Integer.parseInt(parts[0]);
				String code = parts[1];
				String name = parts[2];
				int difficulty = Integer.parseInt(parts[3]);

				Subject subject = new Subject(id, code, name, difficulty);
				subjects.add(subject);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", code=" + code + ", name=" + name + ", difficulty=" + difficulty + "]";
	}
}