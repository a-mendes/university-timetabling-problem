package pthu.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private int id;
    private String startTime;
    private String endTime;
    private int duration;

    public Schedule(int id, String startTime, String endTime, int duration) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public static List<Schedule> readSchedulesFromFile(String fileName) {
        List<Schedule> schedules = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                String startTime = parts[1];
                String endTime = parts[2];
                int duration = Integer.parseInt(parts[3]);

                Schedule schedule = new Schedule(id, startTime, endTime, duration);
                schedules.add(schedule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return schedules;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", duration=" + duration
				+ "]";
	}
}
