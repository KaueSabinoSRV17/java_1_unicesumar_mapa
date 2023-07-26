package mapa.exams;

import java.util.Date;

public class TriglyceridesExam extends Exams {

    public int age;
    public float triglycerideByMdDl;
    public String result;

    public TriglyceridesExam(String patientName, BloodType bloodType, Date birthDate, float triglycerideByMdDl) {
        super(patientName, bloodType, birthDate);
        this.age = this.calculateAge(birthDate);
        this.triglycerideByMdDl = triglycerideByMdDl;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String classifyResult() {
        this.result = handleResult();
        return this.result;
    }

    @Override
    public String showResult() {
        String result = "Your Triglycerides level is at " + triglycerideByMdDl + " mg/dl. Those are " + this.result
                + " levels.";
        System.out.println(result);
        return result;
    }

    private String handleResult() {
        if (this.triglycerideByMdDl > 150) {
            return "Bad";
        }
        if (this.age > 9) {
            return this.triglycerideByMdDl < 90 ? "Good" : "Bad";
        }
        return this.triglycerideByMdDl < 75 ? "Good" : "Bad";
    }

}