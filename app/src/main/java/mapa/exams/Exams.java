package mapa.exams;

import java.util.Date;
import java.util.Calendar;
import java.util.regex.Pattern;

public abstract class Exams {

    public static int MAX_AGE = 122;

    private String patientName;
    private BloodType bloodType;
    protected Date patientBirthDate;

    public Exams(String patientName, BloodType bloodType, Date birthDate) {
        validatePatientName(patientName);
        validatePatientBirthDate(birthDate);
        // No need to validate Blood Type, since it is an Enum
        this.patientName = patientName;
        this.bloodType = bloodType;
        this.patientBirthDate = birthDate;
    }

    public abstract String classifyResult();

    public abstract String showResult();

    public abstract void registerExam();

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        validatePatientName(patientName);
        this.patientName = patientName;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Date getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(Date birthDate) {
        validatePatientBirthDate(birthDate);
        this.patientBirthDate = birthDate;
    }

    private void validatePatientName(String patientName) {
        Pattern onlyLettersSpacesAndCommonPunctuation = Pattern.compile("^[\\p{L}'\\-.,]+( [\\p{L}'\\-.,]+)*$");

        boolean isValid = onlyLettersSpacesAndCommonPunctuation
                .matcher(patientName)
                .matches();

        if (!isValid) {
            throw new Error("Invalid Name.");
        }
    }

    protected void validatePatientBirthDate(Date birthDate) {
        int maxAge = MAX_AGE;
        int age = calculateAge(birthDate);

        if (age > maxAge) {
            throw new Error("Person is way too old");
        }

        if (age < 0) {
            throw new Error("Age should not be Negative");
        }
    }

    protected int calculateAge(Date birthDate) {
        Calendar birthCalendar = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        birthCalendar.setTime(birthDate);

        int age = now.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
        return age;
    }

}