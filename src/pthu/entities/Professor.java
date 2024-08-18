package pthu.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Professor {

    private int id;
    private String name;

    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Professor> readProfessorsFromFile(String fileName) {
        List<Professor> professors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                Professor professor = new Professor(id, name);
                professors.add(professor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return professors;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + "]";
	}
}
