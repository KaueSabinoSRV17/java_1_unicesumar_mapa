package mapa.exams;

import java.util.Date;

public class BloodSugarExam extends Exams {

    private float glucoseByMgDl;
    private String result;

    public BloodSugarExam(String patientName, BloodType bloodType, Date birthDate, float glucoseByMgDl) {
        super(patientName, bloodType, birthDate);
        this.glucoseByMgDl = glucoseByMgDl;
    }

    @Override
    public String classifyResult() {
        this.result = handleResult();
        return this.result;
    }

    @Override
    public String showResult() {
        String result = "Glucose: " + this.glucoseByMgDl + "mg/dl." + "Result: " + this.result;
        System.out.println(result);
        return result;
    }

    private String handleResult() {
        if (glucoseByMgDl < 100) {
            return "Normoglycemia";
        }
        if (glucoseByMgDl < 126) {
            return "Pre-Diabetes";
        }
        return "Diabetes";
    }

}