package mapa.exams;

import java.util.Date;

public class CholesterolExam extends Exams {

    public enum CholesterolRisk {
        LOW("L"), MEDIUM("M"), HIGH("H");

        private final String value;

        CholesterolRisk(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    private int age;
    private float ldlByMgDl;
    private boolean goodLdlLevel;
    private float hdlByMgDl;
    private boolean goodHdlLevel;
    private CholesterolRisk risck;

    public CholesterolExam(String patientName, BloodType bloodType, Date birthDate, float ldlByMgDl, float hdlByMgDl,
            CholesterolRisk risck) {
        super(patientName, bloodType, birthDate);
        this.ldlByMgDl = ldlByMgDl;
        this.hdlByMgDl = hdlByMgDl;
        this.age = this.calculateAge(birthDate);
        this.risck = risck;
    }

    @Override
    public String classifyResult() {
        boolean goodHdlLevel = handleIfHdlResultIsGood();
        boolean goodLdlLevel = handleIfLdlResultIsGood();
        if (goodHdlLevel && goodLdlLevel) {
            return "Both Good";
        }
        if (goodHdlLevel && !goodLdlLevel) {
            return "Good Hdl Level";
        }
        if (!goodHdlLevel && goodLdlLevel) {
            return "Good Ldl Level";
        }
        return "Both Bad";
    }

    @Override
    public String showResult() {
        String ldlResult = "HDL Level: " + formatLevel(this.ldlByMgDl, goodLdlLevel);
        String hdlResult = "LDL Level: " + formatLevel(this.hdlByMgDl, goodHdlLevel);
        String fullResult = hdlResult + "\n" + ldlResult;
        System.out.println(fullResult);
        return fullResult;
    }

    private String handleGoodOrBadLevel(boolean isGood) {
        return isGood ? "Good" : "Bad";
    }

    private String formatLevel(float level, boolean isGood) {
        return this.hdlByMgDl + "md/dl. It is a " + handleGoodOrBadLevel(isGood) + " Level!";
    }

    private boolean handleIfHdlResultIsGood() {
        boolean olderThan19 = this.age > 19;
        float minimunGoodAmountOfHdl = olderThan19 ? 40 : 45;

        boolean goodHdlLevel = this.hdlByMgDl > minimunGoodAmountOfHdl;
        this.goodHdlLevel = goodHdlLevel;
        return goodHdlLevel;
    }

    private boolean handleIfLdlResultIsGood() {
        if (this.ldlByMgDl > 100) {
            this.goodHdlLevel = false;
            return false;
        }
        boolean goodHdlLevel = this.risck == CholesterolRisk.MEDIUM
                ? this.ldlByMgDl < 70
                : this.ldlByMgDl < 50;
        this.goodHdlLevel = goodHdlLevel;
        return goodHdlLevel;
    }

}