package mapa.exams;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mapa.exams.CholesterolExam.CholesterolRisk;

public class CholesterolExamTest {

    static String VALID_NAME = "Joe Doe";
    static BloodType VALID_BLOOD_TYPE = BloodType.AB_NEGATIVE;
    static Date VALID_BIRTH_DATE = Calendar.getInstance().getTime();

    private CholesterolExam getValidExamFromCholesterolSpecifics(Date birthDate, float ldlByMgDl, float hdlByMgDl,
            CholesterolRisk risck) {
        return new CholesterolExam(VALID_NAME, VALID_BLOOD_TYPE, birthDate, ldlByMgDl, hdlByMgDl, risck);
    }

    @Test
    @DisplayName("Should be Good HDL if HDL by md/dl is above 45 and pacient is older than 19 years old")
    void should_be_good_hdl_if_hdl_by_md_dl_is_above_45_and_patient_is_older_than_19_years_old() {
        CholesterolExam exam = getValidExamFromCholesterolSpecifics(getGivenYearsOldDate(19), 41, 46,
                CholesterolRisk.LOW);
        assertTrue(exam.classifyResult() == "Good Hdl Level" || exam.classifyResult() == "Both Good");
    }

    @Test
    @DisplayName("Should be Good HDL if HDL by md/dl is above 40 and pacient is older than 20 years old")
    void should_be_good_hdl_if_hdl_by_md_dl_is_above_40_and_patient_is_older_than_20_years_old() {
        CholesterolExam exam = getValidExamFromCholesterolSpecifics(getGivenYearsOldDate(21), 47, 41,
                CholesterolRisk.LOW);
        assertTrue(exam.classifyResult() == "Good Hdl Level" || exam.classifyResult() == "Both Good");
    }

    @Test
    @DisplayName("Should be Good LDL if LDL by md/dl is below 100 and patient is of low risck")
    void should_be_good_ldl_if_ldl_by_md_dl_is_below_100_and_patient_is_of_low_risck() {
        CholesterolExam exam = getValidExamFromCholesterolSpecifics(getGivenYearsOldDate(21), 47, 99,
                CholesterolRisk.LOW);
        assertTrue(exam.classifyResult() == "Good Ldl Level" || exam.classifyResult() == "Both Good");
    }

    @Test
    @DisplayName("Should be Good LDL if LDL by md/dl is below 70 and patient is of medium risck")
    void should_be_good_ldl_if_ldl_by_md_dl_is_below_70_and_patient_is_of_medium_risck() {
        CholesterolExam exam = getValidExamFromCholesterolSpecifics(getGivenYearsOldDate(21), 47, 69,
                CholesterolRisk.MEDIUM);
        assertTrue(exam.classifyResult() == "Good Ldl Level" || exam.classifyResult() == "Both Good");
    }

    @Test
    @DisplayName("Should be Good LDL if LDL by md/dl is below 70 and patient is of medium risck")
    void should_be_good_ldl_if_ldl_by_md_dl_is_below_50_and_patient_is_of_high_risck() {
        CholesterolExam exam = getValidExamFromCholesterolSpecifics(getGivenYearsOldDate(21), 47, 49,
                CholesterolRisk.LOW);
        assertTrue(exam.classifyResult() == "Good Ldl Level" || exam.classifyResult() == "Both Good");
    }

    private Date getGivenYearsOldDate(int desiredAge) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, 0 - desiredAge);
        return now.getTime();
    }

}